import java.util.*;
public class fractionalKnapsack {
    public static int helper(int[] weights, int[] values, int capacity){
        double ratio[][] = new double[weights.length][2];

        for(int i = 0; i<weights.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = (double)values[i]/weights[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int totalValue = 0;

        for(int i = ratio.length -1 ; i>=0 ; i--){
            int idx = (int)ratio[i][0];
            if(weights[idx] <= capacity){
                capacity -= weights[idx];
                totalValue += values[idx];
            }
            else {
                totalValue += capacity * ratio[i][1];
                capacity = 0;
                break;
            }

        }
        return (int)totalValue;
    }
    public static void main (String args[]){
        int weights[] = {10,20,30};
        int values[] = {60,100,120};
        int capacity = 50;
        System.out.println(helper(weights, values, capacity));
    }
}
