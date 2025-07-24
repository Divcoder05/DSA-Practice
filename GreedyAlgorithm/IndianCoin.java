import java.util.*;
public class IndianCoin {
    public static int indianCoin(Integer coins[], int amount ){
        int count = 0;
        Arrays.sort(coins, Comparator.reverseOrder());
        ArrayList<Integer> coinList = new ArrayList<>();

        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= amount){
                while(coins[i] <= amount){
                    amount -= coins[i];
                    coinList.add(coins[i]);
                    System.out.print(coins[i]+" ");
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String args[]){
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to be converted into coins:");
        int amount = sc.nextInt();

        System.out.println("\nThe coins required to make the amount " + amount + " are:"+ indianCoin(coins, amount));
    }
}
