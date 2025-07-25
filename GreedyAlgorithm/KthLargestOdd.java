import java.util.*;;
public class KthLargestOdd {
    public static void main(String args[]){
        int l = -3, r = 3 , k = 2;
        ArrayList<Integer> oddNum = new ArrayList<>();
        for(int i = l; i <= r; i++){
            if(i%2 == 1){
                oddNum.add(i);
            }
        }
        Collections.sort(oddNum, Collections.reverseOrder());
        if(k > oddNum.size()){
            System.out.println("There are not enough odd numbers in the range.");
        } else {
            System.out.println("The " + k + "th largest odd number is: " + oddNum.get(k - 1));
        }
    }
}
