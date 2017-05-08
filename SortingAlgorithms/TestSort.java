/**
 *             Assignment3, COMP272
 * Class:      TestSort.java
 * Purpose:    Tests the MergeSort and QuickSort classes.
 *
 * @author:    Valli Subasri
 * Student ID: 3286510
 * Date:       August 30, 2016
 * Version     1.0
 *
 */

public class TestSort {

	   public static void main(String args[]) {
		   
		    //shows the sorting progression of a merge sort call
	        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
            System.out.println("Merge Sort: ");
	        MergeSort.mergeSort(array);	        
	      
	        //shows the sorting progression of a quick sort call
            System.out.println("\nQuick Sort: ");	        
	        int[] array2 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};	            
	        QuickSort.quickSort(array2);
	    }
}
