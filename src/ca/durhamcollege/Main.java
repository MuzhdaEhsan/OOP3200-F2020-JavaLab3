package ca.durhamcollege;

import ca.durhamcollege.utility.ExtendedWorkTicket;

public class Main {

    public static void main(String[] args)
    {
        /* FIX THIS BY IMPLEMENTING A WORKING ExtendedWOrkTicket Class*/
        ExtendedWorkTicket testTicket1 = new ExtendedWorkTicket();
        ExtendedWorkTicket testTicket2 = new ExtendedWorkTicket(1, "AMCE_123", 1, 7, 2014, "Password Reset", true);

        System.out.print("\n");
        System.out.print("As Initialized: ");
        System.out.print("\n");
        testTicket1.ShowWorkTicket();
        testTicket2.ShowWorkTicket();


        if (!testTicket1.SetWorkTicket(2, "MACDONALD-001", 10, 3, 2012, "User cannot locate \'any\' key.", true))
        {
            System.out.print("\nErrors! No changes to the ticket made.");
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.print("Ticket 1: ");
        System.out.print(testTicket1);
        System.out.print("\n");

        if (!testTicket2.SetWorkTicket(-1, "BLAGO-042", 13, 32, 11, "", false))
        {
            System.out.print("\nErrors! No changes to the ticket made.");
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.print("Ticket 2: ");
        System.out.print(testTicket2);
        System.out.print("\n");

        testTicket2.CloseTicket(testTicket2.IsOpen());

        System.out.print("\n");
        System.out.print("After Ticket 2 closed: ");
        System.out.print(testTicket2);
        System.out.print("\n");

        System.out.print("\n");
        System.out.print("\n");
    }
}

