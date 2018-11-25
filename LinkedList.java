package LinkedListPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Meghna Mathur
 */

public class LinkedList<T> {

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
    int size=0;

    public LinkedList(){
        head = new Entry<>();
        tail = head;
    }

    public void add(T element){
        Entry<T> node = new Entry<>(element);
        tail.next = node;
        tail = node;
        size++;
    }

    public void printlist(){
        cursor = head.next;
        while(cursor!=null) {
            System.out.print(cursor.element + " ");
            cursor = cursor.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(3);
        ll.add(8);
        ll.add(6);
        ll.add(5);
        ll.add(2);
        ll.add(4);
        ll.printlist();
    }

}
