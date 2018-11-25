package LinkedListPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

    public Iterator<T> iterator() { return new SLLIterator(); }

    protected class SLLIterator implements Iterator<T> {
        Entry<T> cursor, prev;
        boolean ready;  // is item ready to be removed?

        SLLIterator() {
            cursor = head;
            prev = null;
            ready = false;
        }

        public boolean hasNext() {
            return cursor.next != null;
        }

        public T next() {
            prev = cursor;
            cursor = cursor.next;
            ready = true;
            return cursor.element;
        }

        // Removes the current element (retrieved by the most recent next())
        // Remove can be called only if next has been called and the element has not been removed
        public void remove() {
            if(!ready) {
                throw new NoSuchElementException();
            }
            prev.next = cursor.next;
            // Handle case when tail of a list is deleted
            if(cursor == tail) {
                tail = prev;
            }
            cursor = prev;
            ready = false;  // Calling remove again without calling next will result in exception thrown
            size--;
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
