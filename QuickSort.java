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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static sorts.MergeSort.printList;

public class QuickSort
{
  public QuickSort()
  {
      
        int n=1000000;
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
        
//    int array[] = { 2, 8, 7, 1, 3, 5, 6, 4 };
//    quickSort(array, 0, array.length - 1);
      quickSort(list2, 0, list2.length - 1);  
      
      System.out.println("La Lista despues del sort es: " );
      printList(list2); 

    //System.out.println(Arrays.toString(array));
  }

  
   public static void printList(int[] list)   
    {   
        for(int i=0;i<list.length;i++)   
            System.out.print(list[i] + " ");   
        System.out.println();   
    }   
   
  void quickSort(int[] array, int p, int r)
  {
    if (p < r)
    {
      int q = partition(array, p, r);
      quickSort(array, p, q - 1);
      quickSort(array, q + 1, r);
    }
  }

  int partition(int array[], int p, int r)
  {
    int x = array[r];
    int i = p - 1;

    for (int j = p; j < r; j++)
    {
      if (array[j] <= x)
      {
        i += 1;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    int temp = array[i + 1];
    array[i + 1] = array[r];
    array[r] = temp;

    return i + 1;
  }

  public static void main(String[] args)
  {
    new QuickSort();
  }
}
