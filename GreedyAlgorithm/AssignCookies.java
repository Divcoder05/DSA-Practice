/*Leetcode 455
 * link: https://leetcode.com/problems/assign-cookies
 */

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++;
            }
            cookie++;
        }

        return child;
    }
    public static void main(String[] args) {
        AssignCookies ac = new AssignCookies();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(ac.findContentChildren(g, s)); // Output: 1
    }
}