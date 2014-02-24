/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sorts;

/**
 *
 * @author cebueso
 */
import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class RadixSort {

    public static void radixSort(int[] data) {
        int z = 0  ;
        boolean flag = true;
        int divisor = 1;
        Queue[] buckets = new Queue[100];
        for (int i = 0; i < 10; i++)
            buckets[i] = new LinkedList();

        while (flag) {
            flag = false;
            // first copy the values into buckets
            for (int i = 0; i < data.length; i++) {
                int hashIndex = (data[i] / divisor) % 10;
                if (hashIndex > 0)
                    flag = true;
                ((LinkedList) buckets[hashIndex]).addLast(new Integer(data[i]));
            }
            // then copy the values back into vector
            divisor *= 10;
            int i = 0;

            for (int j = 0; j < 10; j++) {
                while (!buckets[j].isEmpty()) {
                    Integer ival = (Integer) ((LinkedList) buckets[j])
                            .getFirst();
                    ((LinkedList) buckets[j]).removeFirst();
                    data[i++] = ival.intValue();
                }
            }
            z=z+1 ;

            System.out.print("Durchlauf " + z + " : ");
            for (int m  = 0; m < data.length; m++){

                System.out.print(data[m] + " ");


            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int i;
        int[] arr = new int[1000000];
        System.out.print("original: ");
        for (i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1024);
            System.out.print(arr[i] + " ");

        }
        System.out.println();
        System.out.println();
        radixSort(arr);


    }
}
