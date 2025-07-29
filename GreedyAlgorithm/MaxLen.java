/*You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair(c, d) can come after pair (a,b) if b< c.
 * Find the longest chain which can be formed from a given set of pairs.
 */
import java.util.*;

public class MaxLen {
    public static int maxLength(int pairs[][]){
         Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int maxLength = 0;
        int lastNum = pairs[0][1];
        maxLength++;

        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0] > lastNum){
                maxLength++;
                lastNum = pairs[i][1];
            }
        }

        return maxLength;
    }
    public static void main (String args[]){
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

       
        System.out.println("Maximum number of pairs: " + maxLength(pairs));
    }
}
