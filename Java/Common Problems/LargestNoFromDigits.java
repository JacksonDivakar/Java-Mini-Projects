public class LargestNoFromDigits {
    public static void main(String[] args) {
        int num=896752;
        int temp_num=num;
        int lengthOfNumber=0,digit,digitCounter=0;

        while (temp_num!=0){
            lengthOfNumber+=1;
            temp_num/=10;
        }
        int arr[]=new int[lengthOfNumber];
        while(num!=0){
            digit=num%10;
            arr[digitCounter]=digit;
            digitCounter++;
            num/=10;
        }
        
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                    if(arr[j]<arr[j+1]){
                        int temp = arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                        }
                    }
                }
        int maxInteger=0,powerOfTen=1;
        for(int i=arr.length-1;i>=0;i--){
            maxInteger+=powerOfTen*arr[i];
            powerOfTen*=10;
            
                }
                System.out.print(maxInteger);
            
        
    }
}
