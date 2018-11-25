import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Meghna Mathur
 */
public class QuickSortComparison {

    public static int numTrials = 100;

    public int[] missing(int[] arr){
        int n = arr.length;
        int last = arr[arr.length-1];
        int k = last - n;
        int[] missingList = new int[k];

        int i=0;
        int count = 0, curr = 1;
        while (count < k && i < n) {
            if (arr[i] != curr) {
                missingList[count] = curr;
                count++;
            }
            else
                i++;
            curr++;
        }
        return missingList;
    }

    public int randomizedPartition(int[]arr, int p, int r){
        Random ran = new Random();
        int i = ran.nextInt((r - p) + 1) + p;
        int temp;
        temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return partition(arr, p, r);
    }

    public int randomizedPartition2(int[]arr, int p, int r){
        Random ran = new Random();
        int i = ran.nextInt((r - p) + 1) + p;
        int temp;
        temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return partition2(arr, p, r);
    }

    public int partition(int[]arr, int p, int r){

        int temp;
        int i;
        i=p-1;
        int x = arr[r];
        for(int j=p; j<r;j++){
            if(arr[j]<=x){
                i=i+1;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;

        return i+1;
    }

    public int partition2(int[]arr, int p, int r){
        int temp;
        int x = arr[r];
        int i = p-1;
        int j = r+1;
        while(true){
            do{
                i++;
            } while(arr[i]<x);
            do{
                j--;
            } while(arr[j]>x);
            if(i>=j){
                return j;
            }
            temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }

    public void quickSort(int[]arr, int p, int r){
        if (p<r){
            int q = randomizedPartition(arr,p,r);
            quickSort(arr,p,q-1);
            quickSort(arr,q+1,r);
        }
    }

    public void quickSort2(int[]arr, int p, int r){
        if (p<r){
            int q = randomizedPartition2(arr,p,r);
            quickSort2(arr,p,q);
            quickSort2(arr,q+1,r);
        }
    }

    public void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    public void quickSort2(int[] arr){
        quickSort2(arr,0,arr.length-1);
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[]){
        QuickSortComparison qs = new QuickSortComparison();

        Random random = new Random();

        int n = 50000000;
        System.out.println("Enter Choice:");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (args.length > 0)
        {
            n = Integer.parseInt(args[0]);
        }
        if (args.length > 1)
        {
            choice = Integer.parseInt(args[1]);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = i;
        }

        Timer timer = new Timer();
        switch (choice)
        {
            case 1:
                    Shuffle.shuffle(arr);
                    qs.quickSort(arr);

                break;
            case 2:
                    Shuffle.shuffle(arr);
                    qs.quickSort2(arr);

                break;
            case 3:
                int[] a = {1,4,6,8,12,14,16,17,18,20,25,28,29};
                int[] missing = sp.missing(a);
                System.out.println("Missing elements:");
                for(int i:missing)
                    System.out.print(i + " ");
                System.out.println();
                break;

        }
        timer.end();
        timer.scale(numTrials);
       // sp.quickSort(arr);


        System.out.println("Choice: " + choice + "\n" + timer);
    }

    public static class Timer
    {
        long startTime, endTime, elapsedTime, memAvailable, memUsed;
        boolean ready;

        public Timer()
        {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public void start()
        {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public Timer end()
        {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            memAvailable = Runtime.getRuntime().totalMemory();
            memUsed = memAvailable - Runtime.getRuntime().freeMemory();
            ready = true;
            return this;
        }

        public long duration()
        {
            if (!ready)
            {
                end();
            }
            return elapsedTime;
        }

        public long memory()
        {
            if (!ready)
            {
                end();
            }
            return memUsed;
        }

        public void scale(int num)
        {
            elapsedTime /= num;
        }

        public String toString()
        {
            if (!ready)
            {
                end();
            }
            return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed / 1048576) + " MB / " + (memAvailable / 1048576) + " MB.";
        }
    }

    public static class Shuffle
    {

        public static void shuffle(int[] arr)
        {
            shuffle(arr, 0, arr.length - 1);
        }

        public static <T> void shuffle(T[] arr)
        {
            shuffle(arr, 0, arr.length - 1);
        }

        public static void shuffle(int[] arr, int from, int to)
        {
            Random random = new Random();
            int n = to - from + 1;
            for (int i = 1; i < n; i++)
            {
                int j = random.nextInt(i);
                swap(arr, i + from, j + from);
            }
        }

        public static <T> void shuffle(T[] arr, int from, int to)
        {
            int n = to - from + 1;
            Random random = new Random();
            for (int i = 1; i < n; i++)
            {
                int j = random.nextInt(i);
                swap(arr, i + from, j + from);
            }
        }

        static void swap(int[] arr, int x, int y)
        {
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }

        static <T> void swap(T[] arr, int x, int y)
        {
            T tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }

        public static <T> void printArray(T[] arr, String message)
        {
            printArray(arr, 0, arr.length - 1, message);
        }

        public static <T> void printArray(T[] arr, int from, int to, String message)
        {
            System.out.print(message);
            for (int i = from; i <= to; i++)
            {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }


}
