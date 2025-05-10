package Flight_Ticket_Reservation_System;
import java.util.*;

class BookingService extends Booking{
    public void flightBooking(){// Books the flight tickets
        ArrayList<Object> flightInfo=getFlightInfo();
        Integer result=checkFlightExists(flightInfo);
        if(result==null){
            // Creating new combination
            Flight flight = new Flight((int)flightInfo.getFirst(), flightType.valueOf((String)flightInfo.getLast()));
            
            bookSeats(flight);
            flightRegistry.add(flight);
        }
        else{
            Flight flight= flightRegistry.get(result);
            bookSeats(flight);
        }
    }
    public void cancelBooking(){ // cancels the booked tickets
        ArrayList<Object> flightInfo=getFlightInfo();
        Integer result=checkFlightExists(flightInfo);
        if(result==null){
            // Creating new combination
            System.out.println("Invalid Flight Information.");
        }
        else{
            Flight flight= flightRegistry.get(result);
            System.out.print("Enter the passenger ID : ");
            int id=Main.scan.nextInt();
            Main.scan.nextLine();
            System.out.println();
            Integer passengerResult=checkPassengerExists(flight,id);
            if(passengerResult!=null){
                Passenger revokePassenger=flight.passengerList.get(passengerResult);
                flight.passengerList.remove((int)passengerResult);

                cancelSeats(flight,revokePassenger);
            }
            else{
                System.out.println("Passenger ID not found");
            }
            
        }
    }
}
class GetDetails{
    public Passenger getPassengerDetails(){
        System.out.print("Enter the passenger ID : ");
        int id=Main.scan.nextInt();
        Main.scan.nextLine();
        System.out.println();
        System.out.print("Enter the passenger Name : ");
        String name=Main.scan.nextLine();
        System.out.println();
        System.out.print("Enter the passenger age : ");
        int age=Main.scan.nextInt();
        Main.scan.nextLine();
        System.out.println();
        System.out.print("No of seats needed : ");
        int noOfSeats=Main.scan.nextInt();
        Main.scan.nextLine();
        System.out.println();
        Passenger newPassenger = new Passenger(id, name, age, noOfSeats);
        return newPassenger;

    }
    public ArrayList<Object> getFlightInfo(){
        System.out.print("Enter the flight ID : ");
        int flightID=Main.scan.nextInt();
        Main.scan.nextLine();
        System.out.println();
        System.out.print("Enter the flight Name [Asia,America,China]: ");
        String flightName=Main.scan.nextLine().toUpperCase();
        System.out.println();
        return new ArrayList<Object>(Arrays.asList(flightID,flightName));
    }
}



class Booking extends GetDetails{
    final static int BASE_PRICE=5000;
    int VARIATION_VALUE=200;
    static int bookingPrice=BASE_PRICE;
    static int totalBookings=0;
    static ArrayList<Flight> flightRegistry= new ArrayList<>();

    public static void displayBookingDetails(){ // Displays the booked details
        System.out.println("Current Booking Price : "+bookingPrice);
        System.out.println("Total Booking : "+totalBookings);
        for(Flight flight:flightRegistry){
            flight.getFlightInfo();
            for(Passenger passenger : flight.passengerList){
                passenger.getPassengerDetails();
            }
        }
    }
    public Integer checkFlightExists(ArrayList<Object> flightInfo){
        for(int i=0;i<flightRegistry.size();i++){
            Flight flights =flightRegistry.get(i);
            if(flights.flightNo==(int)flightInfo.getFirst() && flights.flightName==(flightType.valueOf((String)flightInfo.getLast())) ){
                return i;
            }
        }
        return null;
    }
    public void bookSeats(Flight flight){
        Passenger newPassenger=getPassengerDetails();
        int noOfSeats=newPassenger.noOfSeats;
        boolean result=flight.setSeats(noOfSeats);

        if(result){
            bookingPriceIncreaser(noOfSeats);
            flight.passengerList.add(newPassenger);
            totalBookings+=noOfSeats;
        }

    }

    public Integer checkPassengerExists(Flight flight,int passengerID){
    ArrayList<Passenger> passengerList=flight.passengerList;
    for(int i=0;i<passengerList.size();i++){
        if(passengerList.get(i).passengerID==passengerID){
            return i;
        }
    }
    return null;
   }
    public void bookingPriceIncreaser(int noOfSeats){
        while(noOfSeats!=0){
            bookingPrice+=VARIATION_VALUE;
            noOfSeats-=1;
        }
    }
    public void bookingPriceDecreaser(int noOfSeats){
        while(noOfSeats!=0){
            bookingPrice-=VARIATION_VALUE;
            noOfSeats-=1;
        }
    }

    public void getCancelSeatInformation(){
        System.out.print("Enter the Flight no : ");
        int flightNo=Main.scan.nextInt();
        Main.scan.nextLine();
        System.out.println();
        System.out.print("Enter the passenger ID : ");
        int id=Main.scan.nextInt();
        Main.scan.nextLine();
        System.out.println();
        
    }
    public void cancelSeats(Flight flight ,Passenger passenger){
        int noOfSeats=passenger.noOfSeats;
        
        boolean result=flight.setCancelSeats(noOfSeats);
        if(result){
            bookingPriceDecreaser(noOfSeats);
            totalBookings-=noOfSeats;
        }
    }

}
