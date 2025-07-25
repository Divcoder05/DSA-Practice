//import java.util.*;

public class HeightOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
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
    public static int CountNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = CountNodes(root.left);
        int rightCount = CountNodes(root.right);
        return leftCount + rightCount + 1;
    }
    public static int SumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = SumOfNodes(root.left);
        int rightSum = SumOfNodes(root.right);
        return leftSum+rightSum+root.data;
    }
    public static void main (String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Height of the Binary Tree: " + height(root));
        
        System.out.println("Total number of nodes in the Binary Tree: " + CountNodes(root));
        
        System.out.println("Sum of all nodes in the Binary Tree: " + SumOfNodes(root));
    }
}
