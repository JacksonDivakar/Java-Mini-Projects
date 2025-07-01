
import java.util.*;
public class BookingSeats {
    
    public void bookSeats(BookingDetails bs){
        
        Passenger newPassenger = new Passenger();
        newPassenger.setPassengerDetails();
        
        BusClass bus= bs.getBusClass(newPassenger.getBusName());

        if(bs.checkAvailability(bus)){
            
            System.out.println("The ticket price is "+bus.getSeatPrice());
            Scanner scanner=new Scanner(System.in);
            System.out.print("Enter y to confirm : ");
            String confirmation= scanner.next();
            confirmation=confirmation.toLowerCase();
            if(confirmation.equals("y")){
                bs.updateBusStorage(bus, newPassenger);
                bus.setAvailableSeat();
                System.out.println("The ticket booked.");
            }
            else{
            System.out.println("The ticket not booked. Try again.");
            }

            System.out.println();
        
        
        }
        else{
            System.out.println("Please explore the other buses. The tickets are full.");
        }
        

        

        

    }


}
