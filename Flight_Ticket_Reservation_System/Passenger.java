package Flight_Ticket_Reservation_System;

public class Passenger{
    int passengerID;
    int passengerAge;
    String passengerName;
    int noOfSeats;
    Passenger(int passengerID,String passengerName,int passengerAge,int noOfSeats){
        this.passengerID=passengerID;
        this.passengerAge=passengerAge;
        this.passengerName=passengerName;
        this.noOfSeats=noOfSeats;
    }
    
    public void getPassengerDetails(){
        System.out.println("Passenger ID : "+passengerID);
        System.out.println("Passenger Name : "+passengerName);
        System.out.println("Passenger Age : "+passengerAge);
        System.out.println("No of seats booked : "+noOfSeats);
        
    }
}