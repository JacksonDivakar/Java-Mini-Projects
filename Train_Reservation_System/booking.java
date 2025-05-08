package Train_Reservation_System;

import java.util.*;

class booking extends booking_service {
    train train_obj;
    passenger passenger_obj;

    static HashMap<train, ArrayList<passenger>> data_store = new LinkedHashMap<>();

    booking() {
        this.train_obj = getTrainInformation(data_store.keySet());

        this.passenger_obj = getPassengerInformation(this.train_obj);
        ArrayList<passenger> new_list = data_store.getOrDefault(this.train_obj, new ArrayList<passenger>());
        new_list.add(passenger_obj);
        data_store.put(this.train_obj, new_list);
        System.out.println(passenger_obj.passenger_ticket_price); // Passengers ticket price
        System.out.println(super.ticket_price); // Printing current ticket price
    }

    public static void getBookingDetails() {
        for (Map.Entry<train, ArrayList<passenger>> train_booking : data_store.entrySet()) {
            train train_obj = train_booking.getKey();
            train_obj.getTrainSeatStats();
            for (passenger ps : train_booking.getValue()) {
                ps.getPassengerInfo();
            }
        }
    }

}
