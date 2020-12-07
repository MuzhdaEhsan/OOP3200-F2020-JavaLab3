package ca.durhamcollege.utility;

public class ExtendedWorkTicket extends WorkTicket
{
	private boolean isOpen;
	//Default and parameterized constructor
	public ExtendedWorkTicket()
	{
		this.isOpen = true;
	}

	//Method Definitions
	public ExtendedWorkTicket(int ticket_number, final String client_id, int day, int month, int year, final String description, boolean is_open)
	{
		SetTicketNumber(ticket_number);
		SetClientId(client_id);
		SetDescription(description);
		SetDate(day, month, year);
		isOpen = is_open;
	}

	//Accessor and mutator for isOpen value
//C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
//ORIGINAL LINE: boolean IsOpen() const
	public final boolean IsOpen()
	{
		return isOpen;
	}
	public final void CloseTicket(boolean is_not_open)
	{
		is_not_open = false;
		isOpen = is_not_open;
	}

	//Overload SetWorkTicket
	public boolean SetWorkTicket(int ticket_number, final String client_id, int day, int month, int year, final String description, boolean is_open)
	{
		if (super.SetWorkTicket(ticket_number, client_id, day, month, year, description))
		{
			if (is_open == false)
			{
				CloseTicket(isOpen);
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void ShowWorkTicket()
	{
		super.ShowWorkTicket();
		System.out.print("Ticket:        ");
		if (IsOpen() == true)
		{
			System.out.print("OPEN");
			System.out.print("\n");
		}
		else
		{
			System.out.print("CLOSED");
			System.out.print("\n");
		}
	}
}