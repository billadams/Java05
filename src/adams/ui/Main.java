package adams.ui;

import java.time.LocalDate;
import java.util.List;

import adams.business.Claim;
import adams.io.ClaimIO;

public class Main
{

	public static void main(String[] args)
	{
		System.out.println("Flexible Spending Accounts");
		System.out.println();
		
		displayMenu();
		
		// Start getting input from the user.
		String action = "";
		while (!action.equalsIgnoreCase("exit"))
		{
			action = Validation.getString("Enter a command: ");
			System.out.println();
			
			if (action.equalsIgnoreCase("claim"))
			{
				addAccount();
			}
			else if (action.equalsIgnoreCase("list"))
			{
				displayAllClaims();
			}
			else if (action.equalsIgnoreCase("del"))
			{
				deleteClaim();
			}
			else if (action.equalsIgnoreCase("help"))
			{
				displayMenu();
			}
			else if (action.equalsIgnoreCase("exit"))
			{
				System.out.println("All transactions completed.");
			}
			else
			{
				System.out.println("Please enter a valid option to continue");
			}
		}
	}
	
	public static void displayMenu()
	{
		System.out.println("List of Commands");
		System.out.println("claim  - Create a claim");
		System.out.println("list   - List all transactions");
		System.out.println("del    - Delete a record");
		System.out.println("help   - Display this menu");
		System.out.println("exit   - Exit the application");
	}
	
    public static void addAccount() {
    	// Get the next available claim number.
    	int claimNumber = ClaimIO.getNextClaimNumber();
        int id = Validation.getInt("Enter employee ID: ");
        String firstName = Validation.getString("Enter first name: ");
        String lastName = Validation.getString("Enter last name: ");
        int claimUserInput = Validation.getInt("Enter claim type \n" +
        										"(1) - Health Care \n" +
        										"(2) - Dependent Childcare: ", 1, 2);
        String claimType = "";
        switch (claimUserInput)
        {
        	case 1:
        		claimType = "Health Care";
        		break;
        	case 2:
        		claimType = "Dependent Childcare";
        		break;
        }
        LocalDate dateOfService = Validation.getDate("Enter date of service (mm/dd/yyyy): ");
        double amountRequested = Validation.getDouble("Enter amount requested: ", 1, 10000);

        Claim c = new Claim();
        c.setClaimNumber(claimNumber);
        c.setEmpId(id);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setClaimType(claimType);
        c.setDateOfService(dateOfService);
        c.setAmountRequested(amountRequested);

        ClaimIO.add(c);
        System.out.println("\n Claim for employee id " + id + ", " + " was added to the database.\n");
    }
    
    public static void displayAllClaims() 
    {
        System.out.println("CLAIMS LIST");

        List<Claim> accounts = ClaimIO.getAll();
        
        if (accounts == null) 
        {
            System.out.println("\nError! Unable to get claims.\n");
        } else 
        {
            Claim a;

            for (Claim account : accounts) 
            {
                a = account;
                System.out.println(a.toString());
            }
        }
    }
    
    /**
     * Removes a claim based on its claim number, not the employee id. This allows an employee to have multiple claims.
     * @return void
     */
    public static void deleteClaim() {
        int claimNumber = Validation.getInt("Enter claim number to delete: ");

        Claim c = ClaimIO.get(claimNumber);
        if (c == null) {
            System.out.println("\nError! Unable to get product.");
        }
        else {        
            ClaimIO.delete(c);        
            System.out.println("\n" + c.toString() + 
                    " was deleted from the database.\n");
        }
    }
}
