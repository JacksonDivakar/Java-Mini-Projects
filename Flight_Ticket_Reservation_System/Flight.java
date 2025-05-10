package Flight_Ticket_Reservation_System;

import java.util.ArrayList;

public class Flight {
    final static int TOTAL_SEATS=60;
    int flightNo;
    flightType flightName;
    int flightSeat=TOTAL_SEATS;
    ArrayList<Passenger> passengerList = new ArrayList<>();

    public void addPassenger(int ID,String name,int age,int noOfSeats){
        Passenger newPassenger= new Passenger(ID, name, age,noOfSeats);
        passengerList.add(newPassenger);
    }
    public void removePassenger(int ID){
        for(Passenger passenger : passengerList){
            if(passenger.passengerID==ID){
                passengerList.remove(passenger);
                break;
            }
            else{
                System.out.println("Passenger ID not found");
            }
        }
    }
    Flight(int flightNo,flightType flightName){
        this.flightNo=flightNo;
        this.flightName=flightName;
    }
    public int getFlightNo(){
        return this.flightNo;
    }
    public flightType getFlightName(){
        return this.flightName;
    }
    public  int getAvailableSeats(){
        return this.flightSeat;
    }
    public boolean setSeats(int noOfSeats){
        if(flightSeat-noOfSeats>=0){
        flightSeat-=noOfSeats;
        return true;
        }
        else{
            System.out.printf("%d seats are not available in flight %s.\n",noOfSeats,getFlightName());
            return false;
        }
    }
    public boolean setCancelSeats(int noOfSeats){
        if(flightSeat+noOfSeats<=TOTAL_SEATS){
        flightSeat+=noOfSeats;
        return true;
        }
        else{
            System.out.printf("%d seats are not available in flight %s. Invalid no of seats\n",noOfSeats,getFlightName());
            return false;
        }
    }
    public void getFlightInfo(){
        System.out.println("Flight Name : "+this.getFlightName());
        System.out.println("Flight No : "+this.getFlightNo());
        System.out.println("Flight Available Seats : "+this.getAvailableSeats());
        
    }

}
