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

class Insertion {

    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
    public static Node insert(Node root,int data) {
        Node head = root;

        if (root == null) {
            head = new Node(data); return head;
        }

        while (root != null) {
            if (data < root.data) {
                if (root.left == null) {
                    root.left = new Node(data); break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right == null) {
                    root.right = new Node(data); break;
                } else {
                    root = root.right;
                }
            }
        }

        return head;

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