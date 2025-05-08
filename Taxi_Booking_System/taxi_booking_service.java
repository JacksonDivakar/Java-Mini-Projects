package Taxi_Booking_System;
import java.util.*;
class taxi{
    int taxi_id;
    char taxi_position;
    int taxi_wages=0;
    int taxi_available_time=0;
    taxi(int taxi_id,char taxi_position){
        this.taxi_id=taxi_id;
        this.taxi_position=taxi_position;

    }
    public int getTaxiID(){
        return this.taxi_id;
    }
    public int getTaxiWages(){
        return this.taxi_wages;
    }
    public char getTaxiPosition(){
        return this.taxi_position;
    }
    public int getTaxiAvailableTime(){
        return this.taxi_available_time;
    }
    public void setTaxiPosition(char newPos){
        
        this.taxi_position=newPos;
        
        
    }
    

    public void setTaxiWages(char Pos,char newPos){
        
        int distance=(int)Math.abs(newPos-Pos);
        this.taxi_wages+=100;
        if(distance>5){
            this.taxi_wages+=(distance-5)*100;
        }

    }
    public void SetTaxiAvailableTime(char pickup_point,char drop_point){
        int unit_difference=Math.abs(drop_point-pickup_point);
        this.taxi_available_time=this.taxi_available_time+unit_difference;
    }
    public void updateAfterBooking(char pickup_point,char drop_point){
        this.setTaxiPosition(drop_point);
        this.setTaxiWages(pickup_point,drop_point);
        this.SetTaxiAvailableTime(pickup_point, drop_point);
    }
}

class booking{
    static HashMap<Integer,taxi> taxi_data=new LinkedHashMap<>();
    

    

    public void setTaxiInformation(taxi taxi_obj){
        taxi_data.put(taxi_obj.taxi_id,taxi_obj);
    }

    public static void getTaxiInformation(){
        System.out.println("Taxi Information");
        for(Map.Entry<Integer,taxi> entry:taxi_data.entrySet()){
            taxi obj=entry.getValue();
            System.out.println("Taxi ID "+obj.getTaxiID());
            System.out.println("Taxi Position "+obj.getTaxiPosition());
            System.out.println("Taxi Wages "+obj.getTaxiWages());
            System.out.println("Available time "+obj.getTaxiAvailableTime());
        }
    }
    

}
class booking_service extends booking{

    int customer_id;
    char pickup_point;
    char drop_point;
    int pickup_time;
    
    
    public void reserveTaxi(int customer_id,char pickup_point,char drop_point,int pickup_time){
        this.customer_id=customer_id;
        this.pickup_point=pickup_point;
        this.drop_point=drop_point;
        this.pickup_time=pickup_time;
        int result=nearestTaxi(pickup_point);
        
        book_taxi(result);
    }

    public int nearestTaxi(char pickup_point){
        int min_distance=Integer.MAX_VALUE;
        int min_taxi_wages=Integer.MAX_VALUE;
        int available_taxi=-1;
       
        for(Map.Entry<Integer,taxi> entry:this.taxi_data.entrySet()){
            taxi obj=entry.getValue();
            int taxi_id=obj.getTaxiID();
            int taxi_position=obj.getTaxiPosition();
            int taxi_wages=obj.getTaxiWages();
            int distance=Math.abs(taxi_position-pickup_point);
           
            
            if(distance<min_distance && taxi_wages<min_taxi_wages && pickup_time>=obj.getTaxiAvailableTime()){
                available_taxi=taxi_id;
            }
            
        }
        return available_taxi;
    }
    public void book_taxi(int available_taxi){
        if(available_taxi==-1){
            System.out.println("No taxi available");
        }
        else{
            System.out.printf("Taxi - %d is allocated to the Customer ID %d\n",available_taxi,this.customer_id);
            taxi available_taxi_obj=taxi_data.get(available_taxi);
            
            available_taxi_obj.updateAfterBooking(pickup_point, drop_point);
            
        }
    }

}

public class taxi_booking_service {
    public static void main(String[] args) {
        
        taxi taxi_1=new taxi(1,'A');
        taxi taxi_2=new taxi(2,'A');
        taxi taxi_3=new taxi(3,'A');
        taxi taxi_4=new taxi(4,'A');

        booking bk = new booking();
        booking_service bs = new booking_service();
        bs.setTaxiInformation(taxi_1);
        bs.setTaxiInformation(taxi_2);
        bs.setTaxiInformation(taxi_3);
        bs.setTaxiInformation(taxi_4);

        while(true){
            System.out.println("Welcome to the taxi booking service . ");
            System.out.println("1) Book Service ");
            System.out.println("2) Get Details ");
            System.out.println("0) Exit ");
            Scanner sc = new Scanner(System.in);
            int input=sc.nextInt();

            sc.nextLine();
            if(input==0){
                break;
            }
            else if(input==1){
                System.out.print("Enter the customer Id : ");
                int customer_id=sc.nextInt();
                sc.nextLine();
                System.out.println();
                
                System.out.print("Enter the pickup point (A-F) : ");
                char pickup_point=sc.next().charAt(0);
                System.out.println();

                System.out.print("Enter the drop point (A-F) : ");
                char drop_point=sc.next().charAt(0);
                System.out.println();

                System.out.print("Enter the pickup time : ");
                int pickup_time=sc.nextInt();
                sc.nextLine();
                System.out.println();
                
                bs.reserveTaxi(customer_id, pickup_point, drop_point, pickup_time);
            
            }
            else if(input==2){
                bk.getTaxiInformation();
            }
            else{
                System.out.print("Invalid Input");
            }
            
        }


        
        
    }
}
