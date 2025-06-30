package Library_Management_System;

import java.util.*;

public class BookProcess {
    Scanner scan = Main.scan;
    LibraryMemberManagement LMM = new LibraryMemberManagement();

    public LibraryMemberManagement getLibraryObject(){
        return LMM;
    }
    public void getDetailsAndProcess(BookManager BM){
        
        
        
        System.out.print("Enter your ID : ");
        int Id=scan.nextInt();
        scan.nextLine();
        LibraryMember LM = LMM.fetchMemberObject(Id);
        
        if(LM!=null){
            System.out.println("Welcome "+LM.getName());
            returnOrLend(LM,BM);
        }
        else{
            LM= new LibraryMember();
            LMM.signUp(LM);
        System.out.print("Enter your name : ");
        String name=scan.nextLine();
        System.out.print("Enter your gender : ");
        char gender=Character.toUpperCase(scan.next().charAt(0));
        System.out.print("Enter your age : ");
        int age=scan.nextInt();

        LM.setLibraryMember(name,Id,gender,age);
        returnOrLend(LM,BM);
        }
    }

    public BookNames displayBook(BookManager BM){
        Map bookMap=BM.getMap();
        while(true){
            System.out.println("1) LIFE 2) JACK 3)FRIEND 4)WORLD 5)COMICS");
            System.out.print("Enter your choice : ");
            int input=scan.nextInt();

            switch(input){
                case 1:
                   return BookNames.LIFE;
                case 2:
                   return BookNames.JACK;
                case 3:
                   return BookNames.FRIENDS;
                case 4:
                   return BookNames.WORLD;
                case 5:
                   return BookNames.COMICS;
                default:
                   System.out.println("Invalid Option..");
            }
        }
        
    }
    public void returnOrLend(LibraryMember LM,BookManager BM){
        while(true){
        System.out.println("Enter the option 1) Lend or 2) Return 3)Exit");
        System.out.print("Enter your choice: ");
        int option=scan.nextInt();
        String status;
        if(option==1){
            status="LEND";
            BM.getAvailabilityDetails();
            BookNames BN=displayBook(BM);
            boolean result=LM.setBook(BN, status);
            if (result) BM.updateBookCapacity(BN, status);
        }
        else if(option==2){
            status="RETURN";
            BM.getAvailabilityDetails();
            BookNames BN=displayBook(BM);
            boolean result=LM.setBook(BN, status);
            if (result) BM.updateBookCapacity(BN, status);
           
        }
        else if(option==3){
            break;
        }
        else{
            System.out.println("Invalid Option. Try again.");
        }

        }
    }
    
}
