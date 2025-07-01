

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        

        BookingDetails bookingInfo = new BookingDetails();

        BookingSeats seatBooking= new BookingSeats();
        

        

        
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Welcome to ticket booking app");
            System.out.println("1) To book ticket\n2) To display reserved information\n3) To display bus details\n0)Exit");
            System.out.print("Enter your choice : ");
            int no= sc.nextInt();
            System.out.println();
            if(no==1){
                seatBooking.bookSeats(bookingInfo);
            }
            else if(no==2){
                bookingInfo.getBookedDetails();
            }
            else if(no==3){
                bookingInfo.getBusDetails();
            }
            else{
                break;
            }

        }

        

    }
}