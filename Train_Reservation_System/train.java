package Train_Reservation_System;

import java.util.*;

public class train {
    int train_no;
    int total_train_seats = 63;
    int upper_class = 21;
    int middle_class = 21;
    int lower_class = 21;
    final int WAITING_LIST_SIZE = 10;
    float RAC_Berth = 9;
    float RAC_Seats = 2 * RAC_Berth;
    int waiting_list = 0;

    public int getWaitingList() {
        return this.waiting_list;
    }

    public boolean setWaitingList(boolean var) {
        if (var == true) {
            if (getWaitingList() < this.WAITING_LIST_SIZE) {
                this.waiting_list += 1;
                return true;
            } else {
                System.out.print("Waiting List is full.");
                return false;
            }
        } else {
            if (getWaitingList() > 0) {
                this.waiting_list -= 1;
                return true;
            }
            return false;
        }
    }

    train(int train_no) {
        this.train_no = train_no;
    }

    public float getRACBerth() {
        return RAC_Berth;
    }

    public float getRAC_Seat() {
        return RAC_Seats;
    }

    public int getTrainNo() {
        return train_no;
    }

    public void getTrainSeatStats() {
        System.out.printf("The train no is %d. \n", this.getTrainNo());
        System.out.printf("Total available seats :  %d. \n", this.getTotalAvailableSeats());
        System.out.printf("Total available upper-class seats : %d. \n", this.getTotalAvailableUpperClass());
        System.out.printf("Total available middle-class seats : %d. \n", this.getTotalAvailableMiddleClass());
        System.out.printf("Total available lower-class seats : %d. \n", this.getTotalAvailableLowerClass());

    }

    public int getTotalAvailableSeats() {
        return total_train_seats;
    }

    public int getTotalAvailableUpperClass() {
        return upper_class;
    }

    public int getTotalAvailableMiddleClass() {
        return middle_class;
    }

    public int getTotalAvailableLowerClass() {
        return lower_class;
    }

    public boolean setRACBerth(int no_of_seats) {
        if (this.getRACBerth() - no_of_seats > 0) {
            this.RAC_Berth -= no_of_seats;
            this.RAC_Seats -= 2 * no_of_seats;
            return true;
        } else {
            System.out.printf("There are only %.2f seats available in RAC Berth\n", this.getRACBerth());
            System.out.printf("There are only %.2f seats available in RAC Seats\n", this.getRAC_Seat());
            return false;
        }

    }

    public boolean setRAC_Seat(int no_of_seats) {
        if (this.getRAC_Seat() - no_of_seats > 0) {
            this.RAC_Seats -= no_of_seats;
            this.RAC_Berth -= no_of_seats / 2.0;
            return true;
        } else {
            System.out.printf("There are only %.2f seats available in RAC Seats\n", this.getRAC_Seat());
            return false;
        }
    }

    public boolean setTotalAvailableSeats(int no_of_seats) {
        if (this.total_train_seats - no_of_seats > 0) {
            this.total_train_seats -= no_of_seats;
            return true;
        } else {
            System.out.printf("Total no of avilable seats are %d.\n", this.getTotalAvailableSeats());
            return false;
        }

    }

    public boolean setTotalAvailableUpperClass(int no_of_seats) {
        if (this.upper_class - no_of_seats > 0) {
            this.upper_class -= no_of_seats;
            this.total_train_seats -= no_of_seats;
            return true;
        } else {
            System.out.printf("Total no of avilable seats are %d.\n", this.getTotalAvailableUpperClass());
            return false;
        }

    }

    public boolean setTotalAvailableMiddleClass(int no_of_seats) {
        if (this.middle_class - no_of_seats > 0) {
            this.middle_class -= no_of_seats;
            this.total_train_seats -= no_of_seats;
            return true;
        } else {
            System.out.printf("Total no of avilable seats are %d.\n", this.getTotalAvailableMiddleClass());
            return false;
        }
    }

    public boolean setTotalAvailableLowerClass(int no_of_seats) {
        if (this.lower_class - no_of_seats > 0) {
            this.lower_class -= no_of_seats;
            this.total_train_seats -= no_of_seats;
            return true;
        } else {
            System.out.printf("Total no of avilable seats are %d.\n", this.getTotalAvailableLowerClass());
            return false;
        }
    }

}
