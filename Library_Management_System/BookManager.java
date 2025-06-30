

package Library_Management_System;

import java.util.*;
public class BookManager {
    ArrayList<Integer> bookCapacity= new ArrayList<>();
    
    final private int TOTAL_BOOKS=5;

    private Map<BookNames,Integer> bookIndex = new TreeMap<>();
    public Map getMap(){
        return bookIndex;
    }
    public void setBookCapacity(){
        String books[]= {"LIFE","JACK","FRIENDS","WORLD","COMICS"};
        Scanner scan = Main.scan;
        for(int i=0;i<TOTAL_BOOKS;i++){
            
            System.out.printf("Enter the total book count for %s :",books[i]);
            bookIndex.put(BookNames.valueOf(books[i]),i);
            bookCapacity.add(scan.nextInt());
            System.out.println();
        }
    }



    

    public void getAvailabilityDetails(){
        for(Map.Entry<BookNames,Integer> bookEntry : bookIndex.entrySet()){
            System.out.println("Book Name : "+bookEntry.getKey());
            System.out.println("Total Available Books : "+bookCapacity.get(bookEntry.getValue()));
            System.out.println("--------------------------------------------------------------------------");
        }
    }
    public boolean isBookAvailable(int id){
        return bookCapacity.get(id)>0;
    }

    public void updateBookCapacity(BookNames book,String status){
        int id=bookIndex.get(book);
        if(status.equals("LEND")){
        if(isBookAvailable(id)){
            bookCapacity.set(id,bookCapacity.get(id)-1);
        }
        else{
            System.out.println("The book is N/A. Try other books.");
        }
    }
    else{
        bookCapacity.set(id,bookCapacity.get(id)+1);
    }
    }
    
}
