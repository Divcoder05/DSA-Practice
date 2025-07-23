public class activitySelection {
    public static int helper(int[] start, int[] end) {
        int ans = 1;
        int n = start.length;
        int prevEnd = end[0];
        for(int i =1 ; i < n; i++){
            if(start[i] >=prevEnd){
                ans++;
                prevEnd = end[i];
            }
        }
        return ans;

    }
    public static void main (String[] args){
        int start[] = {10,12,30};
        int end[] = {20,25,40};
        System.out.println(helper(start, end));

    }
}