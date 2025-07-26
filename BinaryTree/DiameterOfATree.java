//import java.util.*;
public class DiameterOfATree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(Math.max(ld,rd),lh+rh+1);
    }
    static class Info {
        int diam;
        int ht;
        Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameterFast(Node root){
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameterFast(root.left);
        Info rightInfo = diameterFast(root.right);
        int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam), leftInfo.ht + rightInfo.ht +1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Height of the Binary Tree: " + height(root));
        System.out.println("Diameter of the Binary Tree: " + diameterFast(root).diam);
    
    }   
}
