import java.util.Scanner;

public class FactorialOfIntegers {
    public static int factorial(int number){
        if(number==0){
            return 1;
        }
        else{
            return number*factorial(number-1);
        }
    }
    public static void main(String[] args) {
        //Declaring variables.
        int firstInteger,secondInteger,sum;
        
        //Getting User Input.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first integer : ");
        firstInteger=scanner.nextInt();
        System.out.print("Enter the second integer : ");
        secondInteger=scanner.nextInt();
        
        //Checking that the first input is greater for problem statement.
        if(firstInteger>secondInteger){
            System.out.print(0);
        }
        else{//Else finding the factorial sum of the numbers from firstInteger to secondInteger
            sum=0;
            for(int i=firstInteger;i<=secondInteger;i++){
                sum+=factorial(i);
            }
            System.out.print(sum);
        }
        
        //Dereferencing the scanner object.
        scanner.close();
    }
}
