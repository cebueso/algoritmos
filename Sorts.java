package sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/*@author cebueso */
public class Sorts   
{   
    public static void main(String[] args){   
        int n=1000000;
        List<Integer> list=new ArrayList();
        for(int i=0 ; i<=n;i++){list.add(i);}        
        long seed = System.nanoTime();
        Collections.shuffle(list,new Random(seed));
        System.out.println("Ejecutando "+"bubbleSort"); 
        System.out.println("La lista con "+n+" datos antes del sort es: \n"+list); 
        System.out.println("La Lista despues del sort es: ");        
        
        bubbleSort(list);
        //insertionSort(list);
        //selectionSort(list);
      
      
//        Iterator<Integer> nombreIterator = list.iterator();
//        int l=0;
//        while(nombreIterator.hasNext() || l==10000){
//            l++;Integer elemento = nombreIterator.next(); 
//            
//            if((n/(n/100)) == l ){l=0;System.out.print(" "+elemento+"\n");
//            }else {System.out.print(elemento+" ");}            
//        }       
    }   
        
    public static void bubbleSort(List<Integer> list) {
      boolean swapped = true;
      int j = 0;
      int tmp;
      while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < list.size() - j; i++) {                                       
                  if (list.get(i) > list.get(i + 1)) {                          
                        tmp = list.get(i);
                        list.set(i, list.get(i+1));
                        //arr[i] = arr[i + 1];
                        list.set(i+1, tmp);
                        //arr[i + 1] = tmp;
                        swapped = true;
                  }
            }                
      }
    }
    
    public static void insertionSort(List<Integer> list) {
      int i, j, newValue;
      for (i = 1; i < list.size(); i++) {
            newValue = list.get(i);
            j = i;
            while (j > 0 && list.get(j - 1) > newValue) {
                    list.set(j, list.get(j - 1));
                    //arr[j] = arr[j - 1];
                  j--;
            }
            list.set(j, newValue);
            //arr[j] = newValue;
      }
    }
    
    public static void selectionSort(List<Integer> list) {
      int i, j, minIndex, tmp;
      int n = list.size();
      for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++)
                  if (list.get(j) < list.get(minIndex))
                        minIndex = j;
            if (minIndex != i) {
                  tmp = list.get(i);
                  list.set(i, list.get(minIndex));
                  //arr[i] = arr[minIndex];
                  list.set(minIndex, tmp);
                  //arr[minIndex] = tmp;
            }
      }
    }

}  
