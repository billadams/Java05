package adams.business;

@SuppressWarnings("serial")
public class DateOutOfRangeException extends Exception
{
	public DateOutOfRangeException() {}
	
	public DateOutOfRangeException(String message)
	{
		super(message);
	}
}
