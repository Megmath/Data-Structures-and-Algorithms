import java.util.Arrays;
/**
 * @author Meghna Mathur
 */

public class MinHeap {

    /*
    Implementation of a binary tree that satisfies the following:
    1. Each node stores an element.
    2. Priority of Parent >= Priority of Child (i.e, value of parent <= value of child).
       Root has maximum priority (minimum value).
    3. Nodes (leaves) at the last level are at far left as possible.
     */
    private int capacity;
    private int size=0;
    int[] nodes;

    public MinHeap(int cap){
        capacity = cap;
        nodes = new int [capacity];
    }

    /*
    Retrieves the index of the left child, right child or parent of a node with given index.
     */
    private int getLeftChild(int parentIndex){
        return 2*parentIndex+1;
    }
    private int getRightChild(int parentIndex){
        return 2*parentIndex+2;
    }
    private int getParent(int childIndex){
        return (childIndex-1)/2;
    }

    /*
    Checks if node at a given index has left child, right child or parent.
     */
    private boolean hasLeftChild(int index){
        return getLeftChild(index)<size;
    }
    private boolean hasRightChild(int index){
        return getRightChild(index)<size;
    }
    private boolean hasParent(int index){
        return getParent(index)>=0;
    }

    /*
    Retrieves the element of the left child, right child or parent of a node with given index.
     */
    private int leftChild(int index){
        return nodes[getLeftChild(index)];
    }
    private int rightChild(int index){
        return nodes[getRightChild(index)];
    }
    private int parent(int index){
        return nodes[getParent(index)];
    }

    public void swapElements(int indexOne, int indexTwo){
        int temp = nodes[indexOne];
        nodes[indexOne] = nodes[indexTwo];
        nodes[indexTwo] = temp;
    }

    /*
    Increases the capacity of the tree if it reaches full capacity.
     */
    private void checkCapacity(){
        if(size == capacity){
            nodes = Arrays.copyOf(nodes, capacity*2);
            capacity = capacity*2;
        }
    }

    /*
    Retrieves the minimum element of the tree (maximum priority)
     */
    public int peek(){
        if(size == 0) throw new IllegalStateException();
        return nodes[0];
    }

    /*
    Removes the minimum element (root) and adjusts the tree according to the min heap constraints.
    Replaces the root with the far left node of the last level of the tree.
    */
    public int remove(){
        if(size == 0) throw new IllegalStateException();
        int element = nodes[0];
        nodes[0] = nodes[size-1];
        size--;
        percolateDown();
        return element;
    }

    /*
    Adds a new element to the far left location and adjusts the tree according to the min heap constraints.
     */
    public void add(int element){
        checkCapacity();
        nodes[size] = element;
        size++;
        percolateUp();
    }

    /*
    Starts from the root of the tree and moves down the tree, swapping the parent node with the smaller child.
     */
    public void percolateDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = leftChild(index);
            if(hasRightChild(index) && rightChild(index)<leftChild(index)){
                smallerChildIndex = getRightChild(index);
            }
            if(nodes[index]< nodes[smallerChildIndex])
                break;
            else
                swapElements(index,smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    /*
    Starts from the last node and moves up swapping parent node with the child node.
     */
    public void percolateUp(){
        int index = size - 1;
        while(hasParent(index) && parent(index)> nodes[index]) {
            swapElements(getParent(index), index);
            index = getParent(index);
        }
    }

    /*
    Prints the elements in order of their location in the heap.
     */
    public void printHeap(){
        for(int index=0; index<size; index++){
            System.out.print(nodes[index] + " ");
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(5);
        heap.add(6);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(7);
        heap.printHeap();
        System.out.println();
        System.out.println(heap.peek());
        System.out.println(heap.remove());
        heap.printHeap();
    }
}
