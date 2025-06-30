package Library_Management_System;
import java.util.*;

public class LibraryMember {
    private String name;
    private int id;
    private char gender;
    private int age;
    
    private ArrayList<BookNames> totalBooks= new ArrayList<>();
    public String getName(){
        return name;
    }
    public int getID(){
        return id;
    }
    public char getGender(){
        return gender;
    }
    public int getAge(){
        return age;
    }
    public ArrayList<BookNames> getBook(){
        return totalBooks;
    }

    public void getMemberDetails(){
        System.out.println("Name : "+getName());
        System.out.println("Id : "+getID());
        System.out.println("Gender : "+(getGender()=='M' ? 'M' : 'F'));
        System.out.println("Books : "+getBook());
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }







    public void setName(String name){
        this.name=name;
    }
    public void setID(int id){
        this.id=id;
    }
    public void setGender(char gender){
        this.gender=gender;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setLibraryMember(String name,int id,char gender,int age){
        setName(name);
        setID(id);
        setGender(gender);
        setAge(age);
        
    }
    public boolean setBook(BookNames book,String status){

        if(status.equals("LEND")){
        for(BookNames bk : totalBooks){
            if(bk.equals(book)){
                System.out.println("This book is already lended by you.");
                return false;
            }
        }
        totalBooks.add(book);
        return true;
    }
    else{
        for(BookNames bk : totalBooks){
            if(bk.equals(book)){
                System.out.println("This book returned.");
                totalBooks.remove(book);
                return true;
            }
        }
        System.out.println("Sorry , you don't have the book "+book);
        return false;
    }
    }
}
