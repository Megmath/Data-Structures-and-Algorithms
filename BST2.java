package mxm180022;
/**
 * @author Meghna Mathur
 */

import java.util.Comparator;
import java.util.Stack;

public class BST2<T extends Comparable<?super T>> {

    private class Node<T> {
        T element;
        Node<T> left, right; //Left and right child of the node

        //Initialize a new node
        public Node(T element, Node<T> left, Node<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    int size;
    Node<T> root;
    Stack<Node<T>> stack = new Stack<>();
    Stack<Node<T>> instack = new Stack<>();

    public BST2(){
        root = null;
        size = 0;
    }

    /*
        Adds a new node to the BST.
        Returns true if a new node is added to the tree.
     */
    public boolean add(T x){
        //If the tree is empty, the new node is the root node.
        if(size==0) {
            root = new Node<T>(x, null, null);
            size++;
            return true;
        }
        else{
            //If the node already exists, replace the current node with the new element.
            Node<T> node = find(x);
            if(x.compareTo(node.element)==0){
                node.element = x;
                return false;
            }
            else{
                /*Add a new node to the left or right of the node returned by find(),
                  i.e, to the last node of the tree.
                */
                if(x.compareTo(node.element)==-1){
                    node.left = new Node<T>(x, null, null);
                }
                else
                    node.right = new Node<T>(x, null, null);
            }
            size++;
            return true;
        }
    }

    public Node<T> find(T x){
        stack.push(null);
        return find(root, x);
    }

    private Node<T> find(Node<T> root, T x){
        if(x.compareTo(root.element)==0)
            return root;
        while(true){
            if(x.compareTo(root.element)==-1){
                if(root.left == null)
                    break;
                else{
                    stack.push(root);
                    root = root.left;
                }
            }
            else if(x.compareTo(root.element)==0)
                break;
            else{
                if(root.right == null)
                    break;
                else{
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return root;
    }

    public T remove(T x){
        if(root==null)
            return null;
        else{
            Node<T> node = find(x);
            if(x.compareTo(node.element)!=0)
                return null;
            else{
                if(node.left==null || node.right==null)
                    bypass(node);
                else{
                    stack.push(node);
                    Node<T> minimum = find(node.right, x);
                    minimum.element = node.element;
                    bypass(minimum);
                }
                size--;
            }
        }
        return x;
    }

    private void bypass(Node<T> node){
        Node<T> parent = stack.peek();
        Node<T> child;
        if(node.left==null)
            child = node.right;
        else
            child = node.left;
        if(parent==null)
            root = child;
        else if(parent.right == node)
            parent.right = child;
        else
            parent.left = child;
    }

    public T min() {
        if (size == 0)
            return null;
        else
            {
            Node<T> node = root;
            while (node.left != null) {
                node = node.left;
            }
            return node.element;
        }
    }

    public T max() {
        if (size == 0)
            return null;
        else {
            Node<T> node = root;
            while (node.right != null) {
                node = node.right;
            }
            return node.element;
        }
    }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<T> node = root;
        inorder(node, arr, -1);
        return arr;
    }

    public void inorder(Node<T> node, Object[] array, int i) {
        while (true) {
            if (node == null && instack.isEmpty()) {
                return;
            }
            while (node != null) {
                instack.push(node);
                node = node.left;
            }
            node = instack.pop();
            array[++i] = node.element;
            node = node.right;
        }
    }

    public void printBST(){
        printBST(root);
    }
    private void printBST(Node<T> node){
        if(node!=null) {
            printBST(node.left);
            System.out.print(node.element + " ");
            printBST(node.right);
        }
    }

    public static void main(String[] args) {
        BST2 bst = new BST2();
        bst.add(8);
        bst.add(5);
        bst.add(9);
        bst.add(4);
        bst.add(7);
        bst.add(3);
        bst.add(6);
        bst.add(11);
        bst.add(10);
        bst.add(15);
        bst.printBST();
        System.out.println();
        System.out.println("Minimum node: " + bst.min());
        System.out.println("Maximum node: " + bst.max());

        Object[] arr = bst.toArray();
        for (int i = 0; i < bst.size; i++) {
            System.out.print(arr[i] + " ");
        }
        bst.remove(11);
        bst.remove(6);
        System.out.println();
        bst.printBST();

    }
}
