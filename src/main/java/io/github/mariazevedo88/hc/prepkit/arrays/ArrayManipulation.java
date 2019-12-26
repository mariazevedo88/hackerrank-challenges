package io.github.mariazevedo88.hc.prepkit.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to 
 * each of the array element between two given indices, inclusive. Once all operations have been performed, 
 * return the maximum value in your array.
 * 
 * For example, the length of your array of zeros n=10. Your list of queries is as follows:
 * 
 * a b k
 * 1 5 3
 * 4 8 7
 * 6 9 1
 * 
 * Add the values of k between the indices a and b inclusive:
 * 
 * index->	 1 2 3  4  5 6 7 8 9 10
 *          [0,0,0, 0, 0,0,0,0,0, 0]
 *          [3,3,3, 3, 3,0,0,0,0, 0]
 *          [3,3,3,10,10,7,7,7,0, 0]
 *          [3,3,3,10,10,8,8,8,1, 0]
 * 
 * The largest value is 10 after all operations are performed.
 * 
 * Function Description
 * 
 * Complete the function arrayManipulation in the editor below. It must return an integer, the maximum 
 * value in the resulting array.
 * 
 * arrayManipulation has the following parameters:
 * n - the number of elements in your array
 * queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers n and m, the size of the array and the number of 
 * operations. Each of the next m lines contains three space-separated integers a, b and k, the left index, 
 * right index and summand.
 * 
 * Constraints
 * 
 * 3<=n<=10^7
 * 1<=m<2*10^5
 * 1<=a<=b<=n
 * 0<=k<=10^9
 * 
 * Output Format
 * 
 * Return the integer maximum value in the finished array.
 * 
 * Sample Input
 * 
 * 5 3
 * 1 2 100
 * 2 5 100
 * 3 4 100
 * 
 * Sample Output
 * 
 * 200
 * 
 * Explanation
 * 
 * After the first update list will be 100 100 0 0 0.
 * After the second update list will be 100 200 100 100 100.
 * After the third update list will be 100 200 200 200 100.
 * The required answer will be 200.
 * 
 * @author Mariana Azevedo
 * @since 25/12/2019
 */
public class ArrayManipulation {
	
	private static final Logger logger = LoggerFactory.getLogger(ArrayManipulation.class);

	public static void main(String[] args) {
		int[][] arr = {{1,2,100}, {2,5,100}, {3,4,100}};
		logger.info(String.valueOf(arrayManipulation(5, arr)));
	}
	
	// Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

    	//initialize array with 0's of size n
    	long arr[] = new long[n];

    	//looping to check the query and subtract 1 from both a and b since 0 indexed array
    	for (int i = 0; i < queries.length; i++) {
	    	int a = queries[i][0] - 1;
	    	int b = queries[i][1] - 1;
	    	int k = queries[i][2];
	
	    	arr[a] += k;
	    	if (b+1 < n) arr[b+1] -= k;  
    	}

    	//get the max value
    	long max = Long.MIN_VALUE;
    	for (int i = 1; i < arr.length; i++) {
	    	arr[i] += arr[i-1];
	    	max = Math.max(arr[i], max);
    	}

    	return max;
    }
}
