package adams.business;

import java.time.LocalDate;

public class Account {
	private int empId;
	private String firstName;
	private String lastName;
	private String claimType;
	private LocalDate dateOfService;
	private double amountRequested;
	
	public Account() 
	{
		this.empId = 0;
		this.firstName = "";
		this.lastName = "";
		this.claimType = "";
		this.dateOfService = null;
		this.amountRequested = 0;
	}
	
	public Account(int empId, String firstName, String lastName, String claimType, LocalDate dateOfService,
			double amountRequested) 
	{
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.claimType = claimType;
		this.dateOfService = dateOfService;
		this.amountRequested = amountRequested;
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

}
