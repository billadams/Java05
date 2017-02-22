package adams.business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Claim {
	private int claimNumber;
	private int empId;
	private String firstName;
	private String lastName;
	private String claimType;
	private LocalDate dateOfService;
	private double amountRequested;
	
	public Claim() 
	{
		this.claimNumber = 0;
		this.empId = 0;
		this.firstName = "";
		this.lastName = "";
		this.claimType = "";
		this.dateOfService = null;
		this.amountRequested = 0;
	}
	
	public Claim(int claimNumber, int empId, String firstName, String lastName, String claimType, LocalDate dateOfService,
			double amountRequested) 
	{
		this.claimNumber = claimNumber;
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.claimType = claimType;
		this.dateOfService = dateOfService;
		this.amountRequested = amountRequested;
	}

	public int getClaimNumber()
	{
		return claimNumber;
	}
	
	public void setClaimNumber(int claimNumber)
	{
		this.claimNumber = claimNumber;
	}
	
	public int getEmpId()
	{
		return empId;
	}

	public void setEmpId(int empId)
	{
		this.empId = empId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getClaimType()
	{
		return claimType;
	}

	public void setClaimType(String claimType)
	{
		this.claimType = claimType;
	}

	public LocalDate getDateOfService()
	{
		return dateOfService;
	}

	public void setDateOfService(LocalDate dateOfService)
	{
		this.dateOfService = dateOfService;
	}

	public double getAmountRequested()
	{
		return amountRequested;
	}

	public void setAmountRequested(double amountRequested)
	{
		this.amountRequested = amountRequested;
	}

	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        
        sb.append("Claim Number:     " + this.claimNumber + "\n");
        sb.append("Employee ID:      " + this.empId + "\n");
        sb.append("Employee Name:    " + this.firstName + " " + this.lastName + "\n");
        sb.append("Claim Type:       " + this.claimType + "\n");
        sb.append("Date Of Service:  " + dtf.format(this.dateOfService) + "\n");
        sb.append("Amount Requested: " + this.amountRequested + "\n");
		
		return sb.toString();
	}

}
