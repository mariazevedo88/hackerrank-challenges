package io.github.mariazevedo88.hc.prepkit.stacks;

import java.util.Arrays;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Skyline Real Estate Developers is planning to demolish a number of old, unoccupied buildings and construct a shopping mall 
 * in their place. Your task is to find the largest solid area in which the mall can be constructed.
 * 
 * There are a number of buildings in a certain two-dimensional landscape. Each building has a height, given by h[i] where i E [1,n]. 
 * If you join k adjacent buildings, they will form a solid rectangle of area k X min(h[i],h[i+1],...,h[i+k-1].
 * 
 * For example, the heights array h=[3,2,3]. A rectangle of height h=2 and length k=3 can be constructed within the boundaries. The 
 * area formed is h*k = 2*3 = 6.
 * 
 * Function Description
 * 
 * Complete the function largestRectangle int the editor below. It should return an integer representing the largest rectangle that 
 * can be formed within the bounds of consecutive buildings.
 * 
 * largestRectangle has the following parameter(s):
 * 
 * h: an array of integers representing building heights
 * 
 * Input Format
 * 
 * The first line contains n, the number of buildings.
 * The second line contains n space-separated integers, each representing the height of a building.
 * 
 * Constraints
 * 
 * 1 <= n <= 10^5
 * 1 <= h[i] <= 10^6
 * 
 * Output Format
 * 
 * Print a long integer representing the maximum area of rectangle formed.
 * 
 * Sample Input
 * 
 * 5
 * 1 2 3 4 5
 * 
 * Sample Output
 * 
 * 9
 * 
 * Explanation
 * 
 * An illustration of the test case follows.
 * 
 * @author Mariana Azevedo
 * @since 05/02/2020
 */
public class LargestRectangle {
	
	private static final Logger logger = LoggerFactory.getLogger(LargestRectangle.class);

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		logger.info(String.valueOf(largestRectangle(arr1)));
	}
	
	// Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {

    	//Creating stack of span = [i, j]
        Stack<int[]> stack = new Stack<>();
        
        int j, max = 0, numBuildings = h.length;
        //Adding the numBuilding control value
        h = Arrays.copyOf(h, numBuildings + 1);
        
        for(int i = 0; i <= numBuildings; i++) {
        	for(j = i; !stack.isEmpty() && h[stack.peek()[0]] >= h[i];) {
                int[] result = stack.pop();
                j = result[1];
                max = Math.max(max, h[result[0]] * (i - j));
            }
            
            stack.push(new int[]{i, j});
        }

        return max;
    }

}
