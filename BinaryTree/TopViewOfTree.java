import java.util.*;

public class TopViewOfTree {
    public static class Node {
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Info{
        Node node;
        int hd; //horizontal distance from root

        Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void TopView(Node root){
        //level order traversal
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min=0, max = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){ // first time we are visiting this horizontal distance
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd -1));
                    min = Math.min(min, curr.hd -1);
                }

                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }

            
        }
        for(int i = min; i <= max; i++){
            System.out.print(map.get(i).data + " ");
        }
    }
    // iterative approach to find nodes at Kth level

    public static void KthLevelNodes(Node root, int k){
        if(root == null || k < 0){
            return;
        }
        if(k == 0){
            System.out.print(root.data + " ");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int level = 1;
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                if(q.isEmpty() || level == k){
                    break;
                }else{
                    q.add(null);
                    level++;
                }
            }
            else{
                if(level == k){
                    System.out.print(curr.data + " ");
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

        }

    }  
    public static void KthLevelNodesRecursive(Node root, int level, int k){
        if(root == null || k <0){
            return;
        }
        if(k==level){
            System.out.print(root.data + " ");
            return;
        }
        KthLevelNodesRecursive(root.left, level+1, k);
        KthLevelNodesRecursive(root.right, level+1, k);

    }
    public static boolean findPath(Node root, int a, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        if(root.data == a){
            path.add(root);
            return true;
        }
        path.add(root);
        if(!findPath(root.left, a, path)){
            if(findPath(root.right, a, path)){
                return true;
            }else{
                path.remove(root);
                return false;
            }
        }
        return true;
    
       
    }
    public static int lca(Node root, int a, int b){
        ArrayList<Node> pathA = new ArrayList<>();
        ArrayList<Node> pathB = new ArrayList<>();

        if(!findPath(root, a, pathA) || !findPath(root, b, pathB)){
            return -1; // one of the nodes is not present in the tree
        }

        findPath(root,a, pathA);
        findPath(root,b, pathB);
        int i;
        for( i=0; i<Math.min(pathA.size(), pathB.size()); i++){
            if(pathA.get(i) != pathB.get(i)){
                break;
            }
        }
        return pathA.get(i-1).data; // return the last common node
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        //root.right.left = new Node(6);
        //root.right.right = new Node(7);

        System.out.println("Top view of the binary tree:");
        TopView(root);

        System.out.println("\nNodes at level 3:");
        KthLevelNodes(root, 3);
        System.out.println("\nNodes at level 2 (recursive):");
        KthLevelNodesRecursive(root, 1, 3);

        System.out.println("\nLowest Common Ancestor of 9 and 7:");
        int lcaValue = lca(root, 9, 7);
        if(lcaValue != -1) {
            System.out.println("LCA: " + lcaValue);
        } else {
            System.out.println("One of the nodes is not present in the tree.");
        }

    }

}
