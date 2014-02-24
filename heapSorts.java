package sorts;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/*@author cebueso */
public class heapSorts   
{   
    public static void main(String[] args){   
        int n=100000;
        List<Integer> list=new ArrayList();
        for(int i=0 ; i<=n;i++){list.add(i);}        
        long seed = System.nanoTime();
        Collections.shuffle(list,new Random(seed));
        
        System.out.println("Ejecutando "+"heapSorts"); 
        System.out.println("La lista con "+n+" datos antes del sort es: \n"+list);
                
        int[] ret = new int[list.size()];       
        Iterator<Integer> nombreIterator = list.iterator();
        //Iterator<Integer> iter = list.iterator();        
        int ll=0;
        while(nombreIterator.hasNext()){            
            Integer elemento = nombreIterator.next();           
            ret[ll] = elemento;//iter.next(); 
            ll++;
        }   
        int A[] = ret;
        //System.out.println(Arrays.toString(A));
        HEAP_SORT(A);
        
        System.out.println("La Lista despues del sort es:");
        System.out.println(Arrays.toString(A));
//        Iterator<Integer> nombreIterator2 = list.iterator();
//        int l=0;
//        while(nombreIterator2.hasNext()){
//            l++;Integer elemento = nombreIterator2.next();           
//            if((n / (n/100)) == l){l=0;System.out.print(elemento+"\n ");
//            }else {System.out.print(elemento+"- ");}            
//        }       
    }   
    //Bloque de HEAP_SORT
    
    public static int heapSize;
    public static int LEFT(int i) {
        //returns left index of a zero index based array
        return 2*i+1;
    }

    public static int RIGHT(int i) {
        //returns right index of a zero based array
        return 2*i+2;
    }

    public static void BUILD_MAX_HEAP(int A[]) {
        heapSize = A.length;//heap size initialised
        for(int i=A.length/2; i>=0;i--)//since n/2, n/2+1 ... are leaves we can start from n/2 step downwards
        {
            //call MAX_HEAPIFY on each root node starting from n/2
            MAX_HEAPIFY(A, i);
        }
    }

    public static void MAX_HEAPIFY(int A[],int i) {
        int l=LEFT(i);//the left element's index which is 2*i+1 (for zero based indexed array)
        int r=RIGHT(i);//right index = 2*i+2;
        int largestElementIndex = -1;//index can't be negative so initialise largest index , it will be used later
        //heapSize is the current size of the heap being worked upon
        //check if left index lies within the heap.
        //if element at left index is greater than root(A[i]) element, max heap property is violated
        //copy the index of violated element in largestElementIndex
        if(l<heapSize && A[l]>A[i]){
            largestElementIndex = l;
        }
        else //if max heap property is not violated copy the root's index in largestElementIndex
        {
            largestElementIndex=i;
        }
        //check to see the right sub tree for max heap property violation
        //here the largestElementIndex is calculated from previous step
        if(r<heapSize && A[r]>A[largestElementIndex])
        {
            largestElementIndex = r;
        }
        //if root doesn't has the largest index then swap the largest element with root element

        if(largestElementIndex!=i)
        {
            int temp = A[i];
            A[i]=A[largestElementIndex];
            A[largestElementIndex]=temp;
            //after swap, recursively call the MAX_HEAPIFY on the largest index(root element)
            MAX_HEAPIFY(A, largestElementIndex);
        }

    }

    public static void HEAP_SORT(int A[]) {
        //max heap is built with heapSize initialised
        BUILD_MAX_HEAP(A);
        //starting from end loop through entire array
        for(int i=A.length-1;i>=0;i--)
        {
            //since heap is already heapified and maintains max heap property
            //the first element of the array is root of max heap
            //swap it with the extreme element of the array i.e. setting the largest element to the end of array
            int temp = A[0];
            A[0]=A[i];
            A[i]=temp;
            //reduce the heap window by 1
            heapSize  = heapSize-1;
            //call max heapify on the reduced heap
            MAX_HEAPIFY(A,0);
        }
    }

    //END Bloque de HEAP_SORT


}  
