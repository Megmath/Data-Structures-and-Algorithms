/**
 * @author Meghna Mathur
 */

public class ReverseLinkedList<T> {

    public class Entry<T>{
        T element;
        Entry<T> next;

        public Entry(){
            element = null;
            next = null;
        }

        public Entry(T e){
            element = e;
            next = null;
        }
    }

    Entry<T> head;
    Entry<T> tail;
    Entry<T> cursor;

    public ReverseLinkedList(){
        head = new Entry<>();
        tail = head;
        cursor = head;
    }

    public void add(T element){
        Entry<T> node = new Entry<>(element);
        cursor.next = node;
        cursor = node;
    }

    public void printlist(){
        cursor = head.next;
        while(cursor!=null) {
            System.out.print(cursor.element + " ");
            cursor = cursor.next;
        }
    }

    public void reverse(){
        Entry<T> revList = null;
        Entry<T> temp;
        cursor = head.next;
        while(cursor!=null) {
            temp = cursor.next;
            cursor.next = revList;
            revList = cursor;
            cursor = temp;
        }
        head.next = revList;
    }

    public static void main(String[] args) {
        ReverseLinkedList<Integer> rll = new ReverseLinkedList<>();
        rll.add(3);
        rll.add(8);
        rll.add(6);
        rll.add(5);
        rll.add(2);
        rll.add(4);
        rll.reverse();
        rll.printlist();
    }

}
