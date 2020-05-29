import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    Node parent;
    int height;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }
}

class Height {

    /*
    class Node 
        int data;
        Node left;
        Node right;
    */
    static int max = 0;
    public static int height(Node root) {
        inorder(root);
        return max;
    }
    
    public static void inorder(Node root) {
        
        if(root != null) {
            if(root.left != null) {
                root.left.parent = root;
                root.left.height = root.height + 1;
                inorder(root.left);
            }
            max = Math.max(max, root.height);
            if(root.right != null) {
                root.right.parent = root;
                root.right.height = root.height+1;
            }
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        root.height = 0;
        root.parent = null;
        scan.close();
        int height = height(root);
        System.out.println(height);
    }   
}