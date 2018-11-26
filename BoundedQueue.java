import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Meghna Mathur
 */

public class BoundedQueue {

    int size, capacity;
    int front, rear;
    int[] bqueue;

    public BoundedQueue(int capacity){
        this.capacity = capacity;
        front = rear = -1;
        bqueue = new int[this.capacity];
        size=0;
    }

    public boolean offer(int x){
        if(size==capacity)
            return false;
        else if(isEmpty()) {
            front = rear = 0;
            bqueue[rear] = x;
            size++;
            return true;
        }
        else{
            rear = (rear+1)%capacity;
            bqueue[rear]=x;
            size++;
            return true;
        }
    }

    public int peek(){
        if(isEmpty())
            return 0;
        else
            return(bqueue[front]);
    }

    public int poll(){
        if(isEmpty())
            return 0;
        else{
            int temp = bqueue[front];
            if(size==1)
                front = rear = -1;
            else
                front = (front + 1) % capacity;
            size--;
            return temp;
            }
    }

    boolean isEmpty() {
        return (size == 0);
    }

    public void printBQueue(){
        int counter = size;
        int frontCounter = front;
        if(size==0)
            System.out.println("The Queue is Empty");
        else{
            counter = rear;
            while(counter>=0) {
                System.out.print(bqueue[frontCounter] + " ");
                frontCounter = (frontCounter+1)%capacity;
                counter--;
            }
        }
    }

    public static void main(String[] args) {
        BoundedQueue bq = new BoundedQueue(5);
        bq.offer(5);
        bq.offer(6);
        bq.offer(10);
        bq.offer(1);
        bq.offer(2);
        bq.printBQueue();
        System.out.println();
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.peek());
    }
}
