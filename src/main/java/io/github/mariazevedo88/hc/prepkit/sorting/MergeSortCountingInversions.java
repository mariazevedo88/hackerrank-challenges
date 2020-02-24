package io.github.mariazevedo88.hc.prepkit.sorting;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * In an array, arr, the elements at indices i and j (where i<j) form an inversion if arr[i] > arr[j]. In other words, inverted elements arr[i] 
 * and arr[j] are considered to be "out of order". To correct an inversion, we can swap adjacent elements.
 * 
 * For example, consider the dataset arr = [2,4,1]. It has two inversions: (4,1) and (2,1). To sort the array, we must perform the following two 
 * swaps to correct the inversions:
 * 
 * Given d datasets, print the number of inversions that must be swapped to sort each dataset on a new line.
 * 
 * Function Description
 * 
 * Complete the function countInversions in the editor below. It must return an integer representing the number of inversions required to sort 
 * the array.
 * 
 * countInversions has the following parameter(s):
 * - arr: an array of integers to sort.
 * 
 * Input Format
 * 
 * The first line contains an integer, d, the number of datasets. Each of the next d pairs of lines is as follows:
 * 
 * 1. The first line contains an integer, n, the number of elements in arr.
 * 2. The second line contains n space-separated integers, arr[i].
 * 
 * Constraints
 * 
 * 1 <= d <= 15
 * 1 <= n <= 10^5
 * 1 <= arr[i] <= 10^7
 * 
 * Output Format
 * 
 * For each of the d datasets, return the number of inversions that must be swapped to sort the dataset.
 * 
 * Sample Input
 * 
 * 2  
 * 5  
 * 1 1 1 2 2  
 * 5  
 * 2 1 3 1 2
 * 
 * Sample Output
 * 
 * 0  
 * 4   
 * 
 * Explanation
 * 
 * We sort the following d=2 datasets:
 * 
 * 1. arr = [1,1,1,2,2] is already sorted, so there are no inversions for us to correct. Thus, we print 0 on a new line.
 * 2. arr = [2,1,3,1,2] -> [1,2,3,1,2] -> [1,1,2,3,2] -> [1,1,2,2,3]. We performed a total of 1 + 2 + 1 = 4 swaps to correct 
 * inversions.
 * 
 * @author Mariana Azevedo
 * @since 24/02/2020
 */
public class MergeSortCountingInversions {
	
	private static final Logger logger = LoggerFactory.getLogger(MergeSortCountingInversions.class);
	
	public static void main(String[] args) {

		int[] arr1 = {1,1,1,2,2};
		logger.info(String.valueOf(countInversions(arr1)));
		
		int[] arr2 = {2,1,3,1,2};
		logger.info(String.valueOf(countInversions(arr2)));
		
		int[] arr3 = {1,5,3,7};
		logger.info(String.valueOf(countInversions(arr3)));
		
		int[] arr4 = {7,5,3,1};
		logger.info(String.valueOf(countInversions(arr4)));
	}
	
	// Complete the countInversions function below.
    static long countInversions(int[] arr) {
    	
    	int n = arr.length;
        
        // Base Case
        if(n <= 1) return 0;
        
        // Recursive Case
        int mid = n >> 1;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        long inversions = countInversions(left) + countInversions(right);
        
        int range = n - mid;
        int leftIndex = 0, rightIndex = 0;
        
        for(int i = 0; i < n; i++) {
            if(leftIndex < mid && (rightIndex >= range || left[leftIndex] <= right[rightIndex])){
            	arr[i] = left[leftIndex++];
                inversions += rightIndex;
            } else if(rightIndex < range) {
            	arr[i] = right[rightIndex++];
            }
        }
        
        return inversions;
    }
}
