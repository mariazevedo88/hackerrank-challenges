package io.github.mariazevedo88.hc.prepkit.greedy;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You will be given a list of integers, arr, and a single integer k. You must create an array of length k from elements 
 * of arr such that its unfairness is minimized. Call that array subarr. Unfairness of an array is calculated as
 * 
 * 								max(subarr) - min(subarr)
 * 
 * Where:
 * - max denotes the largest integer in subarr.
 * - min denotes the smallest integer in subarr.
 * 
 * As an example, consider the array [1,4,7,2] with a k of 2. Pick any two elements, test subarr = [4,7].
 * 
 * unfairness = max(4,7) - min(4,7) = 7-4 = 3
 * 
 * Testing for all pairs, the solution [1,2] provides the minimum unfairness.
 * 
 * Note: Integers in arr may not be unique.
 * 
 * Function Description
 * 
 * Complete the maxMin function in the editor below. It must return an integer that denotes the minimum possible 
 * value of unfairness.
 * 
 * maxMin has the following parameter(s):
 * 
 * k: an integer, the number of elements in the array to create
 * arr: an array of integers.
 * 
 * Input Format
 * 
 * The first line contains an integer n, the number of elements in array arr.
 * The second line contains an integer k.
 * Each of the next n lines contains an integer arr[i] where 0<=i<=n.
 * 
 * Constraints
 * 
 * 2<=n<=10^5
 * 2<=k<=n
 * 0<=arr[i]<=10^9
 * 
 * Output Format
 * 
 * An integer that denotes the minimum possible value of unfairness.
 * 
 * Sample Input 0
 * 
 * 7
 * 3
 * 10
 * 100
 * 300
 * 200
 * 1000
 * 20
 * 30
 * 
 * Sample Output 0
 * 
 * 20
 * 
 * Explanation 0
 * 
 * Here k=3; selecting the 3 integers 10,20,30, unfairness equals
 * 
 * max(10,20,30) - min(10,20,30) = 30 - 10 = 20
 * 
 * Sample Input 1
 * 
 * 10
 * 4
 * 1
 * 2
 * 3
 * 4
 * 10
 * 20
 * 30
 * 40
 * 100
 * 200
 * 
 * Sample Output 1
 * 
 * 3
 * 
 * Explanation 1
 * 
 * Here k=4; selecting the 4 integers 1,2,3,4, unfairness equals
 * 
 * max(1,2,3,4) - min(1,2,3,4) = 4 - 1 = 3
 * 
 * Sample Input 2
 * 
 * 5
 * 2
 * 1
 * 2
 * 1
 * 2
 * 1
 * 
 * Sample Output 2
 * 
 * 0
 * 
 * Explanation 2
 * 
 * Here k=2. subarr = [2,2] or subarr = [1,1] give the minimum unfairness of 0.
 * 
 * @author Mariana Azevedo
 * @since 06/01/2019
 */
public class MaxMin {

	private static final Logger logger = LoggerFactory.getLogger(MaxMin.class);
	
	public static void main(String[] args) {
		int[] arr1 = {10, 100, 300, 200, 1000, 20, 30};
		logger.info(String.valueOf(maxMin(3, arr1)));
		
		int[] arr2 = {1, 2, 3, 4, 10, 20, 30, 40, 100, 200};
		logger.info(String.valueOf(maxMin(4, arr2)));
		
		int[] arr3 = {1, 2, 1, 2, 1};
		logger.info(String.valueOf(maxMin(2, arr3)));
	}
	
	// Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
    	 
    	Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
         
        for(int i = 0; i <= arr.length - k; i++) {
        	min = Math.min(min, arr[k + i - 1] - arr[i]);
        }
         
        return min;
    }
}
