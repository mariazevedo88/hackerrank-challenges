package io.github.mariazevedo88.hc.prepkit.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Given an integer array of size n, find the maximum of the minimum(s) of every window size in 
 * the array. The window size varies from 1 to n.
 * 
 * For example, given arr = [6,3,5,1,12], consider window sizes of 1 through 5. Windows of size 1 
 * are (6),(3),(5),(1),(12). The maximum value of the minimum values of these windows is 12. Windows 
 * of size 2 are (6,3),(3,5),(5,1),(1,12) and their minima are (3,3,1,1). The maximum of these values 
 * is 3. Continue this process through window size 5 to finally consider the entire array. All of the 
 * answers are 12,3,3,1,1.
 * 
 * Function Description
 * 
 * Complete the riddle function in the editor below. It must return an array of integers representing 
 * the maximum minimum value for each window size from 1 to n.
 * 
 * riddle has the following parameter(s):
 * - arr: an array of integers
 * 
 * Input Format
 * 
 * The first line contains a single integer, n, the size of arr.
 * The second line contains n space-separated integers, each an arr[i].
 * 
 * Constraints
 * 
 * 1 <= n <= 10^6
 * 0 <= arr[i] <= 10^9
 * 
 * Output Format
 * 
 * Single line containing n space-separated integers denoting the output for each window size from 1 to n.
 * 
 * Sample Input 0
 * 
 * 4
 * 2 6 1 12
 * 
 * Sample Output 0
 * 
 * 12 2 1 1
 * 
 * Explanation 0
 * 
 * Here n=4 and arr = [2,6,1,12]
 * 
 * window size	window1	window2	window3	window4	maximum of all windows
 *      1	       2	   6	   1	  12	         12
 *      2	       2	   1	   1	                 2
 *      3	       1	   1			                 1
 *      4	       1				                     1
 *      
 * Sample Input 1
 * 
 * 7
 * 1 2 3 5 1 13 3
 * 
 * Sample Output 1
 * 
 * 13 3 2 1 1 1 1
 * 
 * Explanation 1
 * 
 * Here n=7 and arr = [1,2,3,5,1,13,3]
 * 
 * win size	w_1	w_2	w_3	w_4	w_5	w_6	w_7	maximum of all windows
 *    1	     1	 2	 3	 5	 1	13	 3	        13
 *    2	     1	 2	 3	 1	 1	3		        3
 *    3	     1	 2	 1	 1	 1			        2
 *    4	     1	 1	 1	 1				        1
 *    5	     1	 1	 1					        1
 *    6	     1	 1						        1
 *    7	     1							        1
 *    
 * Sample Input 2
 * 
 * 6
 * 3 5 4 7 6 2
 * 
 * Sample Output 2
 * 
 * 7 6 4 4 3 2
 * 
 * Explanation 2
 * 
 * Here n=6 and arr = [3,5,4,7,6,2]
 * 
 * win size	w_1	w_2	w_3	w_4	w_5	w_6	maximum of all windows
 *    1	     3	 5	 4	 7	 6	 2	         7
 *    2	     3	 4	 4	 6	 2		         6
 *    3	     3	 4	 4	 2			         4
 *    4	     3	 4	 2				         4
 *    5	     3	 2					         3
 *    6	     2						         2
 *    
 * @author Mariana Azevedo
 * @since 24/02/2020
 */
public class MinMaxRiddle {
	
	private static final Logger logger = LoggerFactory.getLogger(MinMaxRiddle.class);

	public static void main(String[] args) {
		
		long[] arr1 = {2,6,1,12};
		long[] result1 = riddle(arr1);
		logger.info(String.valueOf(Arrays.stream(result1).boxed().collect(Collectors.toList())));
		
		long[] arr2 = {1,2,3,5,1,13,3};
		long[] result2 = riddle(arr2);
		logger.info(String.valueOf(Arrays.stream(result2).boxed().collect(Collectors.toList())));

		long[] arr3 = {3,5,4,7,6,2};
		long[] result3 = riddle(arr3);
		logger.info(String.valueOf(Arrays.stream(result3).boxed().collect(Collectors.toList())));
	}
	
	// Complete the riddle function below.
    static long[] riddle(long[] arr) {
        
    	int size = arr.length;
        long[] result = new long[size];
        long[] windowSpan = new long[size];

        //Using Deque to add in the last more faster than Stack
        Deque<Long> dequeValues = new ArrayDeque<>();
        Deque<Long> dequeIndexes = new ArrayDeque<>();
        dequeIndexes.push(-1L);

        // count number of elements to the left
        for (int i = 0; i < size; i++) {
        	
        	while (!dequeValues.isEmpty() && dequeValues.peek() >= arr[i]) {
        		dequeValues.pop();
        		dequeIndexes.pop();
        	}
          
        	windowSpan[i] = i - dequeIndexes.peek() - 1;
        	dequeValues.push(arr[i]);
        	dequeIndexes.push((long) i);
        }

        dequeValues.clear();
        dequeIndexes.clear();
        
        dequeIndexes.push((long) size);
        
        //Traverse through all windows of current size i
        for (int i = size - 1; i >= 0; i--) {
          
        	while (!dequeValues.isEmpty() && dequeValues.peek() >= arr[i]) {
        		dequeValues.pop();
        		dequeIndexes.pop();
        	}
          
        	windowSpan[i] += dequeIndexes.peek() - i - 1;
        	dequeValues.push(arr[i]);
        	dequeIndexes.push((long) i);
        }

        //fill results
        for (int i = 0; i < size; i++) {
        	result[(int) windowSpan[i]] = Math.max(result[(int) windowSpan[i]], arr[i]);
        }

        //fill the gaps
        for (int i = size - 2; i >= 0; i--) {
        	result[i] = Math.max(result[i], result[i + 1]);
        }

        return result;
    }

}
