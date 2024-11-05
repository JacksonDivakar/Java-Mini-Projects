import java.util.Scanner;


public class ProductOfOddIntegers {
    public static boolean isPrime(int number){
        if (number==1){
            return false;
        }

        boolean flag=true;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        //Declaring variables.
        int firstInteger,secondInteger,product;
        
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
        else{//Else finding the square of the numbers from firstInteger to secondInteger
            product=1;
            for(int i=firstInteger;i<=secondInteger;i++){
                if(isPrime(i)){
                product*=i;
                System.out.println(i);
                }
            }
            System.out.print("The output is :"+ String.valueOf(product));
        }
        
        //Dereferencing the scanner object.
        scanner.close();
    }
    }

