/**
 *             Assignment3, COMP272
 * Class:      MergeSort.java
 * Purpose:    Represent a merge sort algorithm.
 *
 * @author:    Valli Subasri
 * Student ID: 3286510
 * Date:       August 30, 2016
 * Version     1.0
 *
 */

public class MergeSort {
    
	/**
	 * Sorts the array in non-descending order. Does this by splitting the array
	 * in half and sorting each half. The two sorted halves are merged together 
	 * overwriting the original array. 
	 * @param list - array to be sorted
	 * @return list - sorted array
	 */
    public static int[] mergeSort(int [] list) {
        if (list.length <= 1) {
            return list;
        }
        
        // Split the array in half
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        
        // Sort each half
        
        for (int s = 0; s <first.length; s++) {
        	System.out.print(first[s] + " ");
        }
        System.out.println();
        for (int j = 0; j <second.length; j++) {
        	System.out.print(second[j] + " ");
        }
        System.out.println();

        mergeSort(first);
        mergeSort(second);
        
        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }
    
    /**
	  * Merges both halves into the resulting array while placing them in non descending order. 
	  * @param first - first array to be merged
	  * @param second - second array to be merged
	  * @param result - resultant merged array
	  */
    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;
        
        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
                } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        
        for (int s = 0; s <first.length; s++) {
        	System.out.print(first[s] + " ");
        }
        System.out.println();
        for (int r = 0; r <second.length; r++) {
        	System.out.print(second[r] + " ");
        }
        System.out.println();

        
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
    
 
}