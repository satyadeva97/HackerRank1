import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
   
    public static void preOrder( Node root ) {
      
        if( root == null)
            return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

    public static Node insert(Node root,int data) {
        Node ne = new Node(data);
        Node temp = find( root,  data);
        if (temp == null) return ne;
        if(temp.data > data){
            temp.left = ne;  
        }
        else{
            temp.right = ne;
        }
        return root;
    }
static Node prev = null;
    public static Node find(Node root, int data){
        
        while(root != null){
            if(root.data == data){
                return root;
            }
            else if( root.data > data){
                prev = root;
                return find(root.left, data);
            }
            else{
                prev = root;
                return find(root.right, data);
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }   
}