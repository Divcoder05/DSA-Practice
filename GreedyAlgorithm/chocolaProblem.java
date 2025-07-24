import java.util.*;
public class chocolaProblem {
    public static void main(String args[]){
        int n = 4, m= 6;
        Integer costVer[] = {13,2,1,8,19,7};
        Integer costHor[] = {19,12,14,8};

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while(h < costHor.length && v <costVer.length){
            if(costVer[v] <= costHor[h]){
                cost += (costHor[h] * vp);
                h++;
                hp++;
            }else{
                cost += (costVer[v] * hp);
                v++;
                vp++;
            }
        }
        while(h<costHor.length){
            cost += (costHor[h] * vp);
            h++;
            hp++;
        }
        while(v<costVer.length){
            cost += (costVer[h] * hp);
            v++;
            vp++;
        }

        System.out.println("Minimum cost to break the chocolate: " + cost);
    }
}
