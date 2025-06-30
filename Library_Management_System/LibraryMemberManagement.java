package Library_Management_System;
import java.util.*;
public class LibraryMemberManagement {
    Set<LibraryMember> members = new HashSet<LibraryMember>();
    public LibraryMember fetchMemberObject(int id){
        for(LibraryMember LM : members){
            if(LM.getID()==id){
                return LM;
            }
        }
        return null;
    }

    public void signUp(LibraryMember LM){
        System.out.println("Welcome to padichu palagalaam library");
        members.add(LM);
    }
    
    public void membersDetails(){
        for(LibraryMember LM : members){
            LM.getMemberDetails();
        }
    }

}
