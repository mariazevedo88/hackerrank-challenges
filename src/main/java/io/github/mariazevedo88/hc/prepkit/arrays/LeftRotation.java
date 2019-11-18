package io.github.mariazevedo88.hc.prepkit.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A left rotation operation on an array shifts each of the array's elements 1 unit to the left. For example, 
 * if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].
 * 
 * Given an array a of n integers and a number, d, perform d left rotations on the array. Return the updated 
 * array to be printed as a single line of space-separated integers.
 * 
 * Function Description
 * 
 * Complete the function rotLeft in the editor below. It should return the resulting array of integers.
 * 
 * rotLeft has the following parameter(s):
 * 
 * An array of integers a.
 * An integer d, the number of rotations.
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers n and d, the size of a and the number of left rotations you must perform.
 * The second line contains n space-separated integers a[i].
 * 
 * Constraints
 * 
 * 1<=n<10^5
 * 1<=d<=n
 * 1<=a[i]<10^6
 * 
 * Output Format
 * 
 * Print a single line of n space-separated integers denoting the final state of the array after performing  left rotations.
 * 
 * Sample Input
 * 
 * 5 4
 * 1 2 3 4 5
 * 
 * Sample Output
 * 
 * 5 1 2 3 4
 * 
 * Explanation
 * 
 * When we perform d=4 left rotations, the array undergoes the following sequence of changes:
 * 
 * [1,2,3,4,5] -> [2,3,4,5,1] -> [3,4,5,1,2] -> [4,5,1,2,3] -> [5,1,2,3,4]
 * 
 * @author Mariana
 * @since 10/11/2019
 */
public class LeftRotation {
	
	private static final Logger logger = LoggerFactory.getLogger(LeftRotation.class);

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5};
		int[] rotLeft = rotLeft(a, 4);

		for(int i : rotLeft) {
			logger.info(String.valueOf(i));
		}
	}
	
	 // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

    	int i = 0;
    	int size = a.length;
    	int rotatedIndex = d;
    	int[] rotatedArray = new int[size];
    	
    	while (rotatedIndex < size) {
    		rotatedArray[i] = a[rotatedIndex];
    		i++;
    		rotatedIndex++;
    	}
    	
    	rotatedIndex = 0;
    	
    	while (rotatedIndex < d) {
    		rotatedArray[i] = a[rotatedIndex];
    		i++;
    		rotatedIndex++;
    	}
    	
    	return rotatedArray;
    }
}
