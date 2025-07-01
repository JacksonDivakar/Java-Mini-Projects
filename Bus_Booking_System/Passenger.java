
import java.util.*;
public class Passenger {
    private String passengerName;
    private String passengerGender;
    private String busName;
    public String getPassengerGender(){
        return passengerGender;
    }
    public String getPassengerName(){
        return passengerName;
    }
    
    
    public String getBusName(){
        return busName;
    }
    
    
    public void setPassengerName(String name){
        this.passengerName=name;
    }
    public void setPassengerGender(String gender){
        this.passengerGender=gender;
    }
    public void setBusName(String busName){
        this.busName=busName;
    }

    public void getPassengerDetails(){
        System.out.println("Passenger Name : "+getPassengerName());
        System.out.println("Passenger Gender : "+getPassengerGender());
        System.out.println("----------------------------------------------------------------------------------------------------");
      

    }
    public void setPassengerDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Passenger Name : ");
        
        String name=sc.nextLine();
        setPassengerName(name);
        System.out.println();
        System.out.print("Passenger Gender : ");
        String gender=sc.nextLine();
        setPassengerGender(gender);
        System.out.println();
        System.out.print("Bus Name : ");
        String busName=sc.nextLine();
        setBusName(busName);
        System.out.println();
  
    }

}
