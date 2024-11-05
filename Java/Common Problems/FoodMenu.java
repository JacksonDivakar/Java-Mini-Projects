import java.util.*;
public class FoodMenu {
    static Scanner scanner = new Scanner(System.in);
        public static int getOrderList(int currentPrice,int userFoodSelection){
            int quantity=0;
            switch(userFoodSelection){
                case 1:
                {
                    System.out.print("Enter your Quantity : ");
                    quantity=scanner.nextInt();
                    currentPrice+=quantity*200;
                    break;
            }
            case 2:
                {
                    System.out.print("Enter your Quantity : ");
                    quantity=scanner.nextInt();
                    currentPrice+=quantity*80;
                    break;
            }
            case 3:
                {
                    System.out.print("Enter your Quantity : ");
                    quantity=scanner.nextInt();
                    currentPrice+=quantity*180;
                    break;
            }
            case 4:
                {
                    System.out.print("Enter your Quantity : ");
                    quantity=scanner.nextInt();
                    currentPrice+=quantity*250;
                    break;
            }
            case 5:
                {
                    System.out.print("Enter your Quantity : ");
                    quantity=scanner.nextInt();
                    currentPrice+=quantity*50;
                    break;
            }
        }
            return currentPrice;
        

        }
        public static void main(String[] args) {
        int userFoodSelection,currentPrice=0;

        while (true){
            System.out.println("Items Available:\n1) Pizza \n2) Dosa \n3) Burger \n4) Biryani \n5) Idli \n6) Exit");
            System.out.print("Enter your choice : ");
            userFoodSelection=scanner.nextInt();
            if (userFoodSelection==6){
                System.out.println("Purchase Completed");
                break;
            }
            if(userFoodSelection<0 || userFoodSelection >7){
                System.out.println("Invalid option");
            }
            else{
                currentPrice=getOrderList(currentPrice,userFoodSelection);
                System.out.print("Your current order price is "+String.valueOf(currentPrice)+"\n");
            }
        }
    }
}
