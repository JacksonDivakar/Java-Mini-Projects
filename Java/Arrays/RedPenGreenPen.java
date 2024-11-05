import java.util.*;
public class RedPenGreenPen {
    public static void main(String[] args){
        
        //Getting the input for number of items
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the no of items : ");
        int numberOfItems=scanner.nextInt();
        
        //Gracefully handling the input
        while (numberOfItems<=0){
            System.out.print("The input must be positive.Enter the no of items : ");
            numberOfItems=scanner.nextInt();
        }
        
        // Making the array for traversal
        int arr[]=new int[numberOfItems];
        for(int i=0;i<numberOfItems;i++){
            System.out.print("Enter the input : ");
            arr[i] = scanner.nextInt();
        }
        
        //Counting the odd from even counts
        int swapCount=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]%2!=0 && arr[i+1]%2==0){
                swapCount+=1;
            }
        }
        
        //Closing the scanner object
        scanner.close();
        
        //Printing the final output
        System.out.println("Swap count : "+String.valueOf(swapCount));
    }

    
}
