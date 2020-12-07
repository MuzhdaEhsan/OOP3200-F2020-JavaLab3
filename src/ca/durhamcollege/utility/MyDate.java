package ca.durhamcollege.utility;

import java.util.Date;

public class MyDate
{
	private static int myDay;
	private static int myMonth;
	private static int myYear;


	static final int day_limits[] = new int[31];        // the limit of the day based on the month, e.g. 31
	static final String month_names[] = new String[12];    // the month names e.g. "January"
	static final String days_of_week[] = new String[7];    // the day of week names e.g. "Sunday
	private static int year;

	public MyDate() {
		this.myDay = 1;
		this.myMonth = 1;
		this.myYear = 2000;
	}


	public MyDate(final int day, final int month, final int year) {
		this.SetDate(day, month, year);
	}


	public MyDate(final MyDate copy) {
		this.myDay = copy.myDay;
		this.myMonth = copy.myMonth;
		this.myYear = copy.myYear;
	}

	public MyDate(final int day_number)
	{
		final int last_day = 3652059; // 31 Dec 9999

		// if the parameter is valid
		if (day_number >= 1 && day_number <= last_day)
		{
			// Local variables
			int day = 1; // temporary day
			int month = 1; // temporary month
			int year = 1; // temporary year
			int day_limit; // the highest day of any given month

			// Loop from 1 to the parameter
			for (int i = 1; i < day_number; i++)
			{
				// determine the highest day for the current month
				day_limit = day_limits[month];
				// adjust if it is a leap year and Feb
				if (IsLeapYear(year) && month == 2)
				{
					day_limit = 29;
				}

				// increase the day counter by 1
				day++;

				// if the day counter exceeded the limit for this month:
				if (day > day_limit)
				{
					month++; // roll to the next month
					day = 1; // reset to the 1st

					// if the month counter exceeded December (12)
					if (month > 12)
					{
						year++; // roll to the next year
						month = 1; // reset to Jan (1)
					}
				} // end of adjustment for roll-over
			} // end of counting up to parameter

			// Sets the fields to the day/month/year counters
			myDay = day;
			myMonth = month;
			myYear = year;
		}
		else // Otherwise, parameter was not valid
		{
			// Build an error string

			System.out.println(day_number + " is an invalid value for a day number.\nValue must be greater than 0.");
			// throw exception
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	public static Date SetDate(int day, int month, int year)
	{
		SetYear(year);
		SetMonth(month);
		SetDay(day);
		return null;
	}
	public static void SetYear(final int year)
	{
		final int max_year = 9999; // max possible year
		final int min_year = 1; // min possible year

		// if the year is in range
		if (year >= min_year && year <= max_year)
		{
			myYear = year; // set the year field
		}
		else // otherwise
		{
			// Build an error msg

			System.out.println(year +" is an invalid value for year.\nValue must be between " + min_year + " and " + max_year + " inclusive.");
			// throw an exception
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	public static void SetMonth(int month) {
		final int max_month = 12; // max possible month
		final int min_month = 1; // min possible month

		// if the month is in range
		if (month >= min_month && month <= max_month) {
			myMonth = month; // set the month field
		} else // otherwise
		{
			// Build an error msg

			System.out.println(month + " is an invalid value for month.\nValue must be between " + min_month + " and " + max_month + " inclusive.");
			// throw an exception
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public static void SetDay(final int day) {
		final int min_day = 1; // min possible day
		int max_day = day_limits[myMonth]; // max possible day (depends on month)

		// if it is Feb and a leap year
		if (IsLeapYear() && myMonth == 2) {
			max_day = 29; // set the max to 29
		}

		// if the day is in range
		if (day >= min_day && day <= max_day) {
			myDay = day; // set the day field
		} else // otherwise
		{

			System.out.println(day + " is an invalid value for a day in " + month_names[myMonth] + " " + myYear + ".\nValue must be between " + min_day + " and " + max_day + " inclusive.");
			// throw an exception
			throw new ArrayIndexOutOfBoundsException();
		}
	}



	public final String GetDayOfWeek() {
		return days_of_week[(int) 7 + 1];
	}


	public final int GetMonth() {
		return myMonth;
	}

	public final int GetYear() {
		return myYear;
	}


	public final int GetDay() {
		return myDay;
	}


	public static boolean IsLeapYear() {
		return IsLeapYear(myYear);
	}

	public static boolean IsLeapYear(final int year)
	{
		MyDate.year = year;

		boolean leapYear = false; // assume it is not a leap year

		if (year % 4 == 0) // Leap years must be evenly divisible by 4
		{
			// If year can be evenly divided by 100
			if (year % 100 == 0)
			{
				// it is NOT a leap year, UNLESS
				// year is also evenly divisible by 400
				if (year % 400 == 0)
				{
					// it is a leap year
					leapYear = true;
				}
			}
			else // Leap year was not divisible by 100
			{
				// it is a leap year
				leapYear = true;
			}
		}
		return leapYear;
	}
}