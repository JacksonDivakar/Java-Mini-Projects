
package Flight_Ticket_Reservation_System;


import java.util.*;

enum flightType{
    ASIA,AMERICA,CHINA;
}

public class Main {

    static Scanner scan= new Scanner(System.in);

    public static void main(String[] args) {
        BookingService bk= new BookingService();
        OUTER:
        while (true) {
            System.out.print("Welcome to Flight Booking System.\n");
            System.out.print("1)Book Tickets\n2)Cancel Tickets\n3)Booking Details\n4)Exit menu\n");
            int input=scan.nextInt();
            switch (input) {
                case 1:
                    bk.flightBooking();
                    break;
                case 2:
                    bk.cancelBooking();
                    break;
                case 3:
                    Booking.displayBookingDetails();
                    break;
                case 0:
                    break OUTER;
                default:
                    System.out.println("Invalid Input , try Again.");
                    break;
            }
            System.out.println();
        }

        

    }
}










