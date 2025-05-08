package Train_Reservation_System;

import java.util.*;

public class passenger {
    int passenger_id;

    String passenger_name;
    int passenger_age;
    char passenger_gender;

    boolean isMother = false;

    String passenger_seat;

    int passenger_ticket_price;

    passenger(int passenger_id, String passenger_name, char passenger_gender, boolean isMother, String passenger_seat,
            int passenger_age, int passenger_ticket_price) {
        this.passenger_id = passenger_id;
        this.passenger_name = passenger_name;
        this.passenger_gender = passenger_gender;
        this.passenger_seat = passenger_seat;
        this.isMother = isMother;
        this.passenger_age = passenger_age;
        this.passenger_ticket_price = passenger_ticket_price;

    }

    public void getPassengerInfo() {
        System.out.printf("The passenger id is %d. \n", this.getPassengerID());
        System.out.printf("Passenger name :  %s. \n", this.getPassengerName());
        System.out.printf("Passenger's Gender : %c. \n", this.getPassengerGender());
        System.out.printf("Passenger's age : %d. \n", this.getPassengerAge());
        System.out.printf("Passenger's Seat : %s. \n", this.getPassengerSeat());
        System.out.printf("Is passenger is a mother : %b. \n", this.isMother());

    }

    public String getPassengerSeat() {
        return this.passenger_seat;
    }

    public int getPassengerID() {
        return this.passenger_id;
    }

    public int getPassengerAge() {
        return this.passenger_age;
    }

    public String getPassengerName() {
        return this.passenger_name;
    }

    public char getPassengerGender() {
        return this.passenger_gender;
    }

    public boolean isMother() {
        return this.isMother;
    }

}
