
public interface BusClass {
    int getAvailableDetails();
    int getSeatPrice();
   
    void setSeatPrice(int price);
    void setAvailableSeat();
    void getBusDetails();
    boolean isAvailable();

    public Object getName();
}

class normalBus implements BusClass{
    int SIZE=1;
    private int AvailableSeats=SIZE;
    private int seatPrice=1000;
    private String name="normal";
    
    public boolean isAvailable(){
        return getAvailableDetails() >0;
    }
   


    public void setSeatPrice(int price){
        seatPrice=price;
    }
    public String getName(){
        return name;
    }

    public void setAvailableSeat(){
         this.AvailableSeats--;
    }
    public int getAvailableDetails(){
        return AvailableSeats;
    }
    public int getSeatPrice(){
        return seatPrice;
    }
    public void getBusDetails(){
        System.out.println("The Bus name : "+getName());
        System.out.println("The seat price : "+getSeatPrice());
        System.out.println("The available seats : "+getAvailableDetails());
        System.out.println("Is seat available ? "+isAvailable());
        System.out.println();
        

    }
}

class expressBus implements BusClass{
    int SIZE=5;
    private int AvailableSeats=SIZE;
    private int seatPrice=2000;
    private String name="express";

   
    
    public boolean isAvailable(){
        return getAvailableDetails() >0;
    }
   
    public void getBusDetails(){
        System.out.println("The Bus name : "+getName());
        System.out.println("The seat price : "+getSeatPrice());
        System.out.println("The available seats : "+getAvailableDetails());
        System.out.println("Is seat available ? "+isAvailable());
        

    }

    public void setSeatPrice(int price){
        seatPrice=price;
    }
    public String getName(){
        return name;
    }
    public void setAvailableSeat(){
        this.AvailableSeats--;
    }
    public int getAvailableDetails(){
        return AvailableSeats;
    }
    public int getSeatPrice(){
        return seatPrice;
    }
}
class acBus implements BusClass{
    int SIZE=5;
    private int AvailableSeats=SIZE;
    private int seatPrice=3000;
    private String name="ac";


    
    public boolean isAvailable(){
        return getAvailableDetails() >0;
    }
  

    public void setSeatPrice(int price){
        seatPrice=price;
    }
    public String getName(){
        return name;
    }

    public void setAvailableSeat(){
         this.AvailableSeats--;
    }
    public int getAvailableDetails(){
        return AvailableSeats;
    }
    public int getSeatPrice(){
        return seatPrice;
    }
    public void getBusDetails(){
        System.out.println("The Bus name : "+getName());
        System.out.println("The seat price : "+getSeatPrice());
        System.out.println("The available seats : "+getAvailableDetails());
        System.out.println("Is seat available ? "+isAvailable());
        

    }
}