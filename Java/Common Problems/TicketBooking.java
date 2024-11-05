import java.util.Scanner;


public class TicketBooking {
    public static int getTicketPrice(int age){
        if(age>60){
            return 30;
        }
        else if(age<12){
            return 20;
        }
        else{
            return 50;
        }
    }
    public static void main(String[] args) {
        //Getting the input for number of items
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the no of tickets : ");
        int numberOfItems=scanner.nextInt();
        
        //Gracefully handling the input
        while (numberOfItems<=0){
            System.out.print("The input must be positive.Enter the no of tickets: ");
            numberOfItems=scanner.nextInt();
        }
        
        // Getting the total price
        int totalAmount=0;
        int arr[]=new int[numberOfItems];
        for(int i=0;i<numberOfItems;i++){
            System.out.print("Enter the ages : ");
            arr[i] = scanner.nextInt();
            totalAmount+=getTicketPrice(arr[i]);
        }
        System.out.println("Total Price : "+String.valueOf(totalAmount));
        scanner.close();
    }
}
