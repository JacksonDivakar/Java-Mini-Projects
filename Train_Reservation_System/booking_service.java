package Train_Reservation_System;

import java.util.*;

class booking_service {
    static int ticket_price = 1000;

    public passenger getPassengerInformation(train train_obj) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Passenger ID : ");

        int passengerID = sc.nextInt();
        sc.nextLine();
        System.out.println();

        System.out.print("Enter the name : ");
        String name = sc.nextLine();
        System.out.println();

        System.out.print("Enter the gender : ");
        char gender = sc.next().charAt(0);
        System.out.println();

        System.out.print("Enter the age : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println();

        System.out.print("Enter the seat preference [L/M/U/RAC Berth/RAC Seat] : ");
        String seat = sc.nextLine();

        String available_seat = "";
        if (gender == 'F') {

            System.out.print("Are you with children [Y/N]: ");
            if (sc.next().charAt(0) == 'Y') {
                available_seat = bookForWomenWithChildren(train_obj, passengerID, name, age, gender, seat);
            } else if (isElder(age)) {
                available_seat = bookForElders(train_obj, passengerID, name, age, gender, seat);
            } else {
                available_seat = normalBooking(train_obj, passengerID, name, age, gender, seat);
            }

        } else {
            if (isElder(age)) {
                available_seat = bookForElders(train_obj, passengerID, name, age, gender, seat);
            } else {
                available_seat = normalBooking(train_obj, passengerID, name, age, gender, seat);
            }
        }

        if ("No seat".equals(seat)) {
            boolean result = train_obj.setWaitingList(true);
            if (!result) {
                throw new IllegalArgumentException("Condition not satisfied");
            }
        }

        int passenger_ticket_price = ticket_price;
        ticket_price += 200;

        passenger passenger_obj = new passenger(passengerID, name, gender, false, available_seat, age,
                passenger_ticket_price);
        System.out.println(available_seat);
        return passenger_obj;
    }

    public boolean isChild(int age) {
        return age <= 5;
    }

    public String normalBooking(train train_obj, int passengerID, String name, int age, char gender, String seat) {

        return book_ticket(train_obj, passengerID, name, age, gender, seat);

    }

    public String bookForElders(train train_obj, int passengerID, String name, int age, char gender, String seat) {

        String result = book_ticket(train_obj, passengerID, name, age, gender, "L");
        if ("No Seats".equals(result)) {
            result = book_ticket(train_obj, passengerID, name, age, gender, seat);
        }
        return result;

    }

    public String bookForWomenWithChildren(train train_obj, int passengerID, String name, int age, char gender,
            String seat) {

        String result = book_ticket(train_obj, passengerID, name, age, gender, "L");
        if ("No Seats".equals(result)) {
            result = book_ticket(train_obj, passengerID, name, age, gender, seat);
        }
        return result;
    }

    public String book_ticket(train train_obj, int passengerID, String name, int age, char gender, String seat) {
        switch (seat) {
            case "U":
                if (train_obj.setTotalAvailableUpperClass(1)) {
                    return "U";
                }

            case "M":
                if (train_obj.setTotalAvailableMiddleClass(1)) {
                    return "M";
                }

            case "L":
                if (train_obj.setTotalAvailableLowerClass(1)) {
                    return "L";
                }
            case "RAC Berth":
                if (train_obj.setRACBerth(1)) {
                    return "RAC Berth";
                }

            case "RAC Seat":
                if (train_obj.setRAC_Seat(1)) {
                    return "RAC Seat";
                }
        }
        return "No Seats";
    }

    public boolean isLowerAvailable(train train_obj) {
        return train_obj.getTotalAvailableLowerClass() > 0;
    }

    public train getTrainInformation(Set<train> train_obj_set) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the train ID : ");
        int train_id = sc.nextInt();
        System.out.println();
        for (train train_obj : train_obj_set) {
            if (train_obj.train_no == train_id) {
                return train_obj;
            }
        }
        train train_obj = new train(train_id);
        return train_obj;
    }

    public boolean isElder(int age) {
        return age >= 60;
    }

}
