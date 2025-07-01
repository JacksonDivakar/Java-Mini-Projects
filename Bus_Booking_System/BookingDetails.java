
import java.util.*;
public class BookingDetails {
    HashMap<BusClass,ArrayList<Passenger>> busStorage= new HashMap<>();
    
    

    public void updateBusStorage(BusClass bus , Passenger ps){
        if(busStorage.containsKey(bus)){
            ArrayList<Passenger> psList = busStorage.get(bus);
            psList.add(ps);
            busStorage.put(bus,psList);
        }
        else{
            ArrayList<Passenger> psList = new ArrayList<>();
            psList.add(ps);
            busStorage.put(bus,psList);
        }
    }
    public boolean checkAvailability(BusClass bus){
        if(busStorage.containsKey(bus)){
            System.out.println("Checker "+bus.isAvailable());
            return bus.isAvailable();
        }
        return true;
    }
    public BusClass getBusClass(String name){
        name=name.toLowerCase();
        if(!busStorage.isEmpty()){
        Set<BusClass> hs= busStorage.keySet();
        for( BusClass bs : hs){
            if(bs.getName().equals(name)){
                return bs;
            }
           
        }
    }
        if(name.equals("ac")){
            return new acBus();
        }
        else if(name.equals("express")){
            return new expressBus();
        }
        else{
            return new normalBus();
        }
        

    }

    public void getBookedDetails(){
        for(Map.Entry<BusClass,ArrayList<Passenger>> entry : busStorage.entrySet()){
            ArrayList<Passenger> passengerList= entry.getValue();
            System.out.print("Bus : ");
            System.out.println(entry.getKey().getName());
            for(Passenger ps : passengerList ){
                ps.getPassengerDetails();
            }
        }
    }

    public void getBusDetails(){
        Set<BusClass> hs= busStorage.keySet();
        if(hs.isEmpty()){
            System.out.print("No bookings are done till now.");
        }
        for( BusClass bs : hs){
            bs.getBusDetails();
        }
    }

    
    
}
