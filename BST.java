/**
 * @author Meghna Mathur
 */
 
public class BST {

    /*
    BST consists of nodes each having a left child and a right child which are also BSTs.
     */
    BST left, right;
    int data;
    //Constructor initializes the value of the root node.
    public BST(int d) {
        data = d;
    }

    /*
    Inserts a new node after the existing node if it has no left or right child node.
    Else, traverses down the tree and inserts the new node at a suitable location.
     */
    public void insert(int d){
        if(d<data){
            if(left == null)
                left = new BST(d);
            else
                left.insert(d);
            }
         else{
             if(right == null)
                 right = new BST(d);
             else
                 right.insert(d);
         }
    }

    /*
    Checks if the tree contains the given node.
     */
    public boolean contains(int d){
        if(d==data)
            return true;
        else if (d<data){
            if(left == null)
                return false;
            else
                return left.contains(d);
        }
        else {
            if (right == null)
                return false;
            else
                return right.contains(d);
        }
    }

    /*
    Prints the nodes of the tree using In-Order traversal.
    I.e, it first prints the left child, then the parent and then the right child.
     */
    public void printInOrder(){
        if(left!=null)
            left.printInOrder();
        System.out.print(data + " ");
        if(right!=null)
            right.printInOrder();
    }

    public static void main(String[] args) {
        BST bst = new BST(5);
        bst.insert(8);
        bst.insert(4);
        bst.insert(9);
        bst.insert(11);
        bst.insert(2);
        bst.insert(3);
        bst.insert(7);
        bst.printInOrder();
        System.out.println();
        System.out.println("Contains 2:" + bst.contains(2));
        System.out.println("Contains 1:" + bst.contains(1));
    }
}
