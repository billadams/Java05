package adams.io;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import adams.business.Account;

public class AccountIO
{
    private static final Path productsPath = Paths.get("accounts.txt");
    private static final File productsFile = productsPath.toFile();
    private static final String FIELD_SEP = "\t";
    private static List<Account> accounts = getAll();
    
    public static List<Account> getAll()
    {
    	if (accounts != null)
    	{
    		return accounts;
    	}
    	
    	accounts = new ArrayList<>();
    	if (Files.exists(productsPath))
    	{
    		try (BufferedReader in = new BufferedReader(
    								 new FileReader(productsFile)))
    		{
                String line = in.readLine();
                while(line != null) {
                    String[] columns = line.split(FIELD_SEP);
                    String empId = columns[0];
                    String firstName = columns[1];
                    String lastName = columns[2];
                    String claimType = columns[3];
                    String dateOfService = columns[4];
                    String amountRequested = columns[5];

                    Account a = new Account();
                    a.setEmpId(Integer.parseInt(empId));
                    a.setFirstName(firstName);
                    a.setLastName(lastName);
                    a.setClaimType(claimType);
                    a.setDateOfService((LocalDate) dateOfService); // TODO
                    a.setAmountRequested(Double.parseDouble(amountRequested));
                    accounts.add(a);

                    line = in.readLine();                    
                }
    		}
            catch(IOException e) 
    		{
                System.out.println(e);
                return null;
            }
    	}
    }
}
