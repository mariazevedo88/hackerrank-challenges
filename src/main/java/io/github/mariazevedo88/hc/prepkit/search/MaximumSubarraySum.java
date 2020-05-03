package io.github.mariazevedo88.hc.prepkit.search;

import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * We define the following:
 * 
 * A subarray of array a of length n is a contiguous segment from a[i] through a[j] where 0 <= i <= j < n.
 * The sum of an array is the sum of its elements.
 * 
 * Given an n element array of integers, a, and an integer, m, determine the maximum value of the sum of any 
 * of its subarrays modulo m. For example, Assume a=[1,2,3] and m=2. The following table lists all subarrays 
 * and their modulo:
 * 
 * 		    sum	%2
 * [1]		1	1
 * [2]		2	0
 * [3]		3	1
 * [1,2]	3	1
 * [2,3]	5	1
 * [1,2,3]	6	0
 * 
 * The maximum modulus is 1.
 * 
 * Function Description
 * 
 * Complete the maximumSum function in the editor below. It should return a long integer that represents the 
 * maximum value of subarray sum % m.
 * 
 * maximumSum has the following parameter(s):
 * 
 * - a: an array of long integers, the array to analyze
 * - m: a long integer, the modulo divisor
 * 
 * Input Format
 * 
 * The first line contains an integer q, the number of queries to perform.
 * 
 * The next q pairs of lines are as follows:
 * 
 * - The first line contains two space-separated integers n and (long)m, the length of a and the modulo divisor.
 * - The second line contains n space-separated long integers a[i].
 * 
 * Constraints
 * 
 * 2 <= n <= 10^5
 * 1 <= m <= 10^4
 * 1 <= a[i] <= 10^18
 * 2 <= the sum of n over all test cases <= 5 x 10^5 
 * 
 * Output Format
 * 
 * For each query, return the maximum value of subarray sum % m as a long integer.
 * 
 * Sample Input
 * 
 * 1
 * 5 7
 * 3 3 9 9 5
 * 
 * Sample Output
 * 
 * 6
 * 
 * Explanation
 * 
 * The subarrays of array a=[3,3,9,9,5] and their respective sums modulo m=7 are ranked in order of length and 
 * sum in the following list:
 * 
 * 1. [9] -> 9%7=2 and [9] -> 9%7=2 
 *    [3] -> 3%7=3 and [3] -> 3%7=3
 *    [5] -> 5%7=5
 *    
 * 2. [9,5] -> 14%7=0
 *    [9,9] -> 18%7=4
 *    [3,9] -> 12%7=5
 *    [3,3] -> 6%7=6
 *    
 * 3. [3,9,9] -> 21%7=0
 *    [3,3,9] -> 15%7=1
 *    [9,9,5] -> 23%7=2
 *    
 * 4. [3,3,9,9] -> 24%7=3
 *    [3,9,9,5] -> 26%7=5
 *    
 * 5. [3,3,9,9,5] -> 29%7=1
 * 
 * The maximum value for subarray sum % 7 for any subarray is 6.
 * 
 * @author Mariana Azevedo
 * @since 03/05/2020
 */
public class MaximumSubarraySum {
	
	private static final Logger logger = LoggerFactory.getLogger(MaximumSubarraySum.class);

	public static void main(String[] args) {
		
		long[] arr1 = {3, 3, 9, 9, 5};
		logger.info(String.valueOf(maximumSum(arr1, 7)));
		
		long[] arr2 = {1, 2, 3};
		logger.info(String.valueOf(maximumSum(arr2, 2)));
		
		long[] arr3 = {1, 5, 9};
		logger.info(String.valueOf(maximumSum(arr3, 5)));
	}
	
	// Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {

    	long maxSum = 0;
        long[] prefix = new long[a.length+1];
        
        for (int i = 0; i < a.length; i++) {
            prefix[i+1] = (prefix[i] + a[i] % m) % m;
        }
        
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i = 1; i <= a.length; i++) {
            treeSet.add(prefix[i-1]);

            if (treeSet.ceiling(prefix[i]+1) != null) {
                maxSum = Math.max(maxSum, (prefix[i] - 
                		treeSet.ceiling(prefix[i]+1) + m) % m);
            } else {
                maxSum = Math.max(maxSum, prefix[i]);
            }
        }                                   
        
        return maxSum;
    }

}
