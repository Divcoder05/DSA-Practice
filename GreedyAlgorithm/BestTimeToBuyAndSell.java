public class BestTimeToBuyAndSell {
    public static void main(String args[]){
        int prices[] = {7,6,4,3,1};


        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0 ; i<prices.length ; i++){
            if(prices[i]< minPrice){
                minPrice = prices[i]; 
            }
            maxProfit = Math.max((prices[i] - minPrice),maxProfit);
            
        }
        System.out.println("Maximum profit from buying and selling the stock is: " + maxProfit);
    }
    
}
