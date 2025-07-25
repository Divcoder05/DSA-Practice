import java.util.*;
public class BuildPreOrder {
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
    static class BinaryTree {
        static int idx = -1;
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        public void printPreOrder(Node root){
            if(root == null){
                //System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
        public void printInorder(Node root){
            if(root == null){
                return;
            }
            printInorder(root.left);
            System.out.print(root.data+" ");
            printInorder(root.right);
        }
        public void printPostOrder(Node root){
            if(root == null){
                return;
            }
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data+" ");
        }
        public void levelOrderTraversal(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }


        }
    }
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        //System.out.println("Binary Tree built from PreOrder traversal with root node:"+ " "+ root.data);
        System.out.print("PreOrder Traversal of the Binary Tree: ");
        tree.printPreOrder(root);
        System.out.println();
        System.out.print("InOrder Traversal of the Binary Tree: ");
        tree.printInorder(root);
        System.out.println();
        System.out.print("PostOrder Traversal of the Binary Tree: ");
        tree.printPostOrder(root);
        System.out.println();
        System.out.println("Level Order Traversal of the Binary Tree: ");
        tree.levelOrderTraversal(root);
        System.out.println();
    }
}
