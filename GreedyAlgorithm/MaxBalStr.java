public class MaxBalStr {
    public static void main(String args[]){
        String s = "LRRRRLLRLLRLLR";
        int lr = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'L'){
                lr++;
            }else if(s.charAt(i) == 'R'){
                lr--;
            }

            if(lr == 0){
                count++;
            }
        }
        System.out.println("Maximum number of balanced substrings: " + count);
    }
    
}
