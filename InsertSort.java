import java.util.Scanner;
/**
 * @author Meghna Mathur
 */

public class InsertSort {

    public void sort(int[] a) {
        int key, i;

        for (int j = 0; j < a.length; j++)
            System.out.print(a[j] + " ");
        System.out.println();

        for (int j = 1; j < a.length; j++) {
            key = a[j];
            i = j - 1;
            while (i > -1 && a[i] > key) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }

        for (int j = 0; j < a.length; j++)
            System.out.print(a[j] + " ");
    }
    public static void main (String[]args){

        int a[] = new int[12];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<12;i++){
            a[i] = sc.nextInt();
        }
        InsertSort i = new InsertSort();
        i.sort(a);
    }

}
