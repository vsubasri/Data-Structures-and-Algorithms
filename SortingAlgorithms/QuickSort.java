/**
 *             Assignment3, COMP272
 * Class:      QuickSort.java
 * Purpose:    Represent a quick sort algorithm.
 *
 * @author:    Valli Subasri
 * Student ID: 3286510
 * Date:       August 30, 2016
 * Version     1.0
 *
 */

public class QuickSort {
    
    /**
     * Sorts an array's elements in non-descending order. 
     * @param array - array to be sorted 
     */
	public static void quickSort(int[] array) {
         
        if (array == null || array.length == 0) {
            return;
        }
        
        quickSort(array, 0, array.length - 1);
    }
 
     /**
      * Recursively sorts array's elements. Begins by calculating the pivot number 
      * as the median of the elements at the lowerIndex, higherIndex and middle of the
      * array. In each iteration, we will identify a number from left side which
      * is greater then the pivot value, and also we will identify a number
      * from right side which is less then the pivot value. Once the search
      * is done, then we exchange both numbers.Call quicksort method recursively. 
      */
    public static void quickSort(int[] array, int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
          
        int pivot = medianOf3(array, lowerIndex, higherIndex);
        
        System.out.println("Pivot: " + pivot);
        
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        
        for (int s = 0; s <array.length; s++) {
        	System.out.print(array[s] + " ");
        }
        System.out.println();
        
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array, lowerIndex, j);
        if (i < higherIndex)
            quickSort(array, i, higherIndex);
    }
    
    /**
     * Swap elements at two specified positions of the array. 
     * @param array - array where elements lie
     * @param i - index of first element
     * @param j - index of second element
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * Takes the median of 3 elements in the array and swaps it with the last index in the array.
     * @param intArray - array
     * @param lowerIndex - starting index of array
     * @param higherIndex - ending index of array
     * @return intArray[higherIndex] - median element of the 3 elements
     */
    public static int medianOf3(int[] intArray, int lowerIndex, int higherIndex) {
        int center = (lowerIndex + (higherIndex-lowerIndex)) / 2;

        if ((intArray[lowerIndex] > intArray[center] && intArray[center] > intArray[higherIndex]) 
        || (intArray[lowerIndex] < intArray[center] && intArray[center] < intArray[higherIndex]))
        	swap(intArray, higherIndex, center);
 
        else if ((intArray[higherIndex] > intArray[lowerIndex] && intArray[lowerIndex] > intArray[center])
        || (intArray[higherIndex] < intArray[lowerIndex] && intArray[lowerIndex] < intArray[center]))
        	swap(intArray, lowerIndex, higherIndex-1);
               
        return intArray[higherIndex];

      }
}