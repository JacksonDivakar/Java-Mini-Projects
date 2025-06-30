
package Library_Management_System;
import java.util.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        //Admin Process
        System.out.println("Set Book Capacity");
        BookManager bk= new BookManager();
        bk.setBookCapacity();
        


        BookProcess BP= new BookProcess();
        

        
        
        while(true){
            System.out.println("Enter your option : ");
            System.out.println("1) To display available books");
            System.out.println("2) Lend or return books ");
            System.out.println("3) Member details");
            System.out.println("4) To exit");
            System.out.print("Enter you choice : ");
            int input=scan.nextInt();
            if(input==1){
                bk.getAvailabilityDetails();
            }
            else if(input==2){
                BP.getDetailsAndProcess(bk);
            }
            else if(input==3){
                LibraryMemberManagement LLM=BP.getLibraryObject();
                LLM.membersDetails();
            }
            else if(input==4){
                break;
            }
            else{
                System.out.println("Invalid option.");
            }

        }
        // String input=scan.next();
        // BookNames bookName=BookNames.valueOf(input.toUpperCase());
        // System.out.print(bookName);

    }
}
