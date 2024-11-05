import java.util.*;
public class MoveZerosAndSorting {
    public static void main(String[] args) {
        int arr[]={4,5,0,1,9,0,5,0};
        ArrayList<Integer> nonZeros=new ArrayList<>();
        int zeroCounts=0;
        for(int i=0;i<arr.length;i++){
            if (arr[i]==0){
                zeroCounts+=1;
            }
            else{
                nonZeros.add(arr[i]);
            }
        }
        Collections.sort(nonZeros);
        for(int i=0;i<zeroCounts;i++){
            nonZeros.add(0);
        }
        System.err.println(nonZeros);
    }
    
}
