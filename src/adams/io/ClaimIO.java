package adams.io;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import adams.business.Claim;

public class ClaimIO
{
    private static final Path claimsPath = Paths.get("claims.txt");
    private static final File claimsFile = claimsPath.toFile();
    private static final String FIELD_SEP = "\t";
    private static List<Claim> claims = getAll();
    
    /**
     * Gets all of the claims from the claims file.
     * @return ArrayList
     */
    public static List<Claim> getAll()
    {
    	if (claims != null)
    	{
    		return claims;
    	}
    	
    	claims = new ArrayList<>();
    	if (Files.exists(claimsPath))
    	{
    		try (BufferedReader in = new BufferedReader(
    								 new FileReader(claimsFile)))
    		{
                String line = in.readLine();
                while(line != null) {
                    String[] columns = line.split(FIELD_SEP);
                    String claimNumber = columns[0];
                    String empId = columns[1];
                    String firstName = columns[2];
                    String lastName = columns[3];
                    String claimType = columns[4];
                    String dateOfService = columns[5];
                    String amountRequested = columns[6];

                    Claim c = new Claim();
                    c.setClaimNumber(Integer.parseInt(claimNumber));
                    c.setEmpId(Integer.parseInt(empId));
                    c.setFirstName(firstName);
                    c.setLastName(lastName);
                    c.setClaimType(claimType);
                    c.setDateOfService(LocalDate.parse(dateOfService));
                    c.setAmountRequested(Double.parseDouble(amountRequested));
                    claims.add(c);

                    line = in.readLine();                    
                }
    		}
            catch(IOException e) 
    		{
                System.out.println(e);
                return null;
            }
    	}
    	
		return claims;
    }

    /**
     * 
     * @param int claimNumber
     * @return Claim claim, null if not found.
     */
    public static Claim get(int claimNumber) 
    {
        for (Claim c : claims) 
        {
            if (c.getClaimNumber() == claimNumber)
                return c;
        }
        return null;
    }
    

    /**
     * 
     * Gets the next unique claim number. This will allow the ability to remove just a record based on it's claim number,
     * rather than an employee id. An employee can have multiple withdraws using the same employee id.
     * 
     * @return int
     */
    public static int getNextClaimNumber()
    {
    	int highestClaimNumber = 0;
    	int nextClaimNumber = 0;
    	
    	for (Claim c : claims)
    	{
    		int currentNumber = c.getClaimNumber();
    		
    		if (currentNumber >= highestClaimNumber)
    		{
    			highestClaimNumber = currentNumber;
    		}
    	}   	
    	nextClaimNumber = highestClaimNumber + 1;
    	
    	return nextClaimNumber;
    }
    
    /**
     * 
     * @return boolean
     */
    private static boolean saveAll() 
    {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(claimsFile)))) 
        {
        	
            // Write all products in the array list to the file
            for (Claim c : claims) {
            	out.print(c.getClaimNumber() + FIELD_SEP);
                out.print(c.getEmpId() + FIELD_SEP);
                out.print(c.getFirstName() + FIELD_SEP);
                out.print(c.getLastName() + FIELD_SEP); 
                out.print(c.getClaimType() + FIELD_SEP);		
                out.print(c.getDateOfService() + FIELD_SEP);
                out.println(c.getAmountRequested());
            }
        }
        catch(IOException e) 
        {
            System.out.println(e);
            return false;
        }

        return true;
    }

    /**
     * 
     * @param Claim c
     * @return boolean
     */
    public static boolean add(Claim c) 
    {
        claims.add(c);
        return saveAll();
    }
    
    /**
     * 
     * @param Claim c
     * @return boolean
     */
    public static boolean delete(Claim c) {
        claims.remove(c);
        return saveAll();
    }
}
