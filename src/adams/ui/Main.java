package adams.ui;

import java.time.LocalDate;
import java.util.List;

public class Main
{

	public static void main(String[] args)
	{
		System.out.println("Flexible Spending Accounts");
		System.out.println();
		
		displayMenu();
		
		String action = "";
		while (!action.equalsIgnoreCase("exit"))
		{
			action = Validation.getString("Enter a command: ");
			System.out.println();
			
			if (action.equalsIgnoreCase("draw"))
			{
				// TODO 
				// code make a withdrawal
			}
			else if (action.equalsIgnoreCase("list"))
			{
				// TODO
			}
			else if (action.equalsIgnoreCase("del"))
			{
				// TODO
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
		System.out.println("draw - Make a withdrawal");
		System.out.println("list - List all transactions");
		System.out.println("del  - Delete a record");
		System.out.println("help - Display this menu");
		System.out.println("exit - Exit the application");
	}
}
