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

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static sorts.BucketSort.printList;
import static sorts.BucketSort.sortList;


public class MergeSort {

    public static void main(String[] args) throws IOException{
        
        int n=100000;
        List<Integer> list=new ArrayList();
        for(int i=0 ; i<=n;i++){list.add(i);}        
        long seed = System.nanoTime();
        Collections.shuffle(list,new Random(seed));
        
        //System.out.println("La lista antes del sort es: \n"+list); 
                
        int[] ret = new int[list.size()];       
        Iterator<Integer> nombreIterator = list.iterator();
        //Iterator<Integer> iter = list.iterator();        
        int ll=0;
        while(nombreIterator.hasNext()){            
            Integer elemento = nombreIterator.next();           
            ret[ll] = elemento;//iter.next(); 
            ll++;
        }   
        //int A[] = ret;
        
        int[] list2 = ret;//{0,31,81,1,252,142,45,297,7,18};   
           
        System.out.println("La lista antes del sort es: ");   
        printList(list2);   
//        sortList(list2);   
//        System.out.println("La Lista despues del sort es: ");   
//        printList(list2);   
        
        
        
        
        
        
        
        
//        BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
//        int arraySize = Integer.parseInt(R.readLine());
//        int[] inputArray = new int[arraySize];
//        for (int i = 0; i < arraySize; i++) {
//            inputArray[i] = Integer.parseInt(R.readLine());
//        }
        mergeSort(list2);
        System.out.println("La Lista despues del sort es: " );
        printList(list2);   
//        //mergeSort(inputArray);
//        for (int j = 0; j < inputArray.length; j++) {
//            System.out.println(inputArray[j]);
//        }

    }
    
    public static void printList(int[] list)   
    {   
        for(int i=0;i<list.length;i++)   
            System.out.print(list[i] + " ");   
        System.out.println();   
    }   

    static void mergeSort(int[] A) {
        if (A.length > 1) {
            int q = A.length/2;

            int[] leftArray = Arrays.copyOfRange(A, 0, q);
            int[] rightArray = Arrays.copyOfRange(A,q,A.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(A,leftArray,rightArray);
        }
    }

    static void merge(int[] a, int[] l, int[] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        //return a;

    }

}
