package ca.durhamcollege.utility;

import java.util.Date;

public class WorkTicket {

	// PRIVATE  VARIABLES

	protected int myTicketNumber;
	protected String myClientId;
	protected Date myDate;
	protected String myDescription;

	public int getMyTicketNumber() {
		return myTicketNumber;
	}

	public void setMyTicketNumber(int myTicketNumber) {
		this.myTicketNumber = myTicketNumber;
	}

	public String getMyClientId() {
		return myClientId;
	}

	public void setMyClientId(String myClientId) {
		this.myClientId = myClientId;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	public String getMyDescription() {
		return myDescription;
	}

	public void setMyDescription(String myDescription) {
		this.myDescription = myDescription;
	}

	public WorkTicket() {
		this.myTicketNumber = 0;
		this.myClientId = "";
		this.myDate = MyDate.SetDate(1,1,2000);
		this.myDescription = "";
	}

	public WorkTicket(final int ticket_number, final String client_id, final int month, final int day, final int year, final String description) {
		// Set each data member with appropriate validation:
		SetTicketNumber(ticket_number);
		SetClientId(client_id);
		SetDescription(description);
		SetDate(day, month, year);
	}

	public WorkTicket(final WorkTicket original) {
		myTicketNumber = original.myTicketNumber;
		myClientId = original.myClientId;
		myDate = original.myDate;
		myDescription = original.myDescription;
	}

	public boolean SetWorkTicket(final int ticket_number, final String client_id, int day, int month, int year, final String description) {
		MyDate workingDate = new MyDate();
		final int min_year = 2000;
		final int max_year = 2099;
		boolean valid = true; // flag for if parameters are valid

		// check numeric parameters
		if (ticket_number < 0 || year < min_year || year > max_year) {
			valid = false;
		}
		// check string parameters
		else if (client_id.length() < 1 || description.length() < 1) {
			valid = false;
		} else {
			try {
				// sets the date (may throw an exception even if rules are met)
				workingDate.SetDate(day, month, year);
			} catch (java.lang.Exception e) {
				valid = false;
			}
		}

		if (valid) // all parameters are valid
		{
			// set the workticket date
			//myDate = workingDate;

			// set atributes to parameter values
			myTicketNumber = ticket_number;
			myClientId = client_id;
			myDescription = description;
		}
		// return true or false based on parameter validity
		return valid;
	}

	/***************************************************************************
	 *	ShowWorkTicket( )
	 *	An accessor method to display all the object's attributes neatly in
	 *	the console window.
	 ***************************************************************************/

	public void ShowWorkTicket() {
		// display the attributes of the object neatly to the console
		System.out.print("\nWork Ticket #: ");
		System.out.print(myTicketNumber);
		System.out.print("\nClient ID:     ");
		System.out.print(myClientId);
		System.out.print("\nDate:          ");
		System.out.print(myDate);
		System.out.print("\nIssue:         ");
		System.out.print(myDescription);
		System.out.print("\n");
	}

	public void SetTicketNumber(final int ticketNumber)
	{

		if (ticketNumber > 0) {
			myTicketNumber = ticketNumber;
		} else {
			throw new IllegalArgumentException("Ticket number must be greater than zero. ");
		}
	}

	public final int GetTicketNumber() {
		return myTicketNumber;
	}

	// Client ID
	public final void SetClientId(String clientId) {
		myClientId = clientId;
	}

	public final String GetClientId() {
		return myClientId;
	}

	public final void SetDescription(String description) {
		myDescription = description;
	}

	public final String GetDescription() {
		return myDescription;
	}

	public void SetDate(final int day, final int month, final int year) throws IllegalArgumentException
	{

		final int MIN_YEAR = 2000;
		final int MAX_YEAR = 2099;
		if (year >= MIN_YEAR && year <= MAX_YEAR) // unique year requirements
		{
			MyDate.SetDate(day, month, year); // day and month validated in the method
		} else {
			System.out.println("Year must be between " + MIN_YEAR + " and " + MAX_YEAR + ". ");
			throw new IllegalArgumentException();
		}
	}

	public boolean equalsTo(final WorkTicket original) {

		return myTicketNumber == original.myTicketNumber && myClientId.equals(original.myClientId) && myDate == original.myDate && myDescription.equals(original.myDescription);
	}
}





