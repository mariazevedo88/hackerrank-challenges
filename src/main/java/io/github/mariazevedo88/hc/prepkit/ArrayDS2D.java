package io.github.mariazevedo88.hc.prepkit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Given a 6x6 2D Array, arr:
 * 
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 
 * We define an hourglass in A to be a subset of values with indices falling in this pattern in arr's 
 * graphical representation:
 * 
 * a b c
 *   d
 * e f g
 * 
 * There are 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values. 
 * Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.
 * 
 * For example, given the 2D array:
 * 
 * -9 -9 -9  1 1 1 
 *  0 -9  0  4 3 2
 * -9 -9 -9  1 2 3
 *  0  0  8  6 6 0
 *  0  0  0 -2 0 0
 *  0  0  1  2 4 0
 *  
 *  We calculate the following 16 hourglass values:
 *  
 *  -63, -34, -9, 12, 
 *  -10, 0, 28, 23, 
 *  -27, -11, -2, 10, 
 *    9, 17, 25, 18
 *    
 * Our highest hourglass value is 28 from the hourglass:
 * 
 * 0 4 3
 *   1
 * 8 6 6
 * 
 * Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip 
 * this challenge.
 * 
 * Function Description
 * 
 * Complete the function hourglassSum in the editor below. It should return an integer, the maximum 
 * hourglass sum in the array.
 * 
 * hourglassSum has the following parameter(s):
 *    arr: an array of integers
 *    
 * Input Format
 * 
 * Each of the 6 lines of inputs arr[i] contains 6 space-separated integers arr[i][j].
 * 
 * Constraints
 * 
 * -9 <= arr[i][j] <= 9
 *  0 <= i,j <= 5
 *  
 * Output Format
 * 
 * Print the largest (maximum) hourglass sum found in arr.
 * 
 * Sample Input
 * 
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * 
 * Sample Output
 * 
 * 19
 * 
 * @author Mariana Azevedo
 * @since 06/10/2019
 */
public class ArrayDS2D {
	
	private static final Logger logger = LoggerFactory.getLogger(ArrayDS2D.class);
	
	public static void main(String[] args) {
		int[][]arr = new int [][] {{1,1,1,0,0,0}, {0,1,0,0,0,0}, {1,1,1,0,0,0}, {0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}};
		Integer result = hourglassSum(arr);
		logger.info(result.toString());
		
		int[][]arr2 = new int [][] {{-9,-9,-9,1,1,1}, {0,-9,0,4,3,2}, {-9,-9,-9,1,2,3}, {0,0,8,6,6,0},{0,0,0,-2,0,0},{0,0,1,2,4,0}};
		result = hourglassSum(arr2);
		logger.info(result.toString());
	}
	
	static int hourglassSum(int[][] arr) {
		int rows = arr.length;
		int columns = arr[0].length;
		
		//The minimum value of an array element is -9. So the minimum is -9x7 = 63
		int maxHourglassSum = -63;
		
		//The hourglass has 7 elements. So we only check 3 elements for rows and columns
		for(int i=0; i<rows-2;i++) {
			for(int j=0; j<columns-2;j++) {
				int currentSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] +
						arr[i+2][j+1] + arr[i+2][j+2];
				maxHourglassSum = Math.max(maxHourglassSum, currentSum);
			}
		}
		return maxHourglassSum;
	}
}
