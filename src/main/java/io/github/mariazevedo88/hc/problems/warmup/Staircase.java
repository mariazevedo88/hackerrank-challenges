package io.github.mariazevedo88.hc.problems.warmup;

import java.util.stream.IntStream;

/**
 * Consider a staircase of size n=4:
 *     #
 *    ##
 *   ###
 *  ####
 *  
 * Observe that its base and height are both equal to n, and the image is drawn 
 * using # symbols and spaces. The last line is not preceded by any spaces.
 *  
 * Write a program that prints a staircase of size n.
 *  
 * Function Description
 *  
 * Complete the staircase function in the editor below. It should print a staircase 
 * as described above.
 *  
 * staircase has the following parameter(s):
 *  
 * - n: an integer
 *  
 * Input Format
 *  
 * A single integer, n, denoting the size of the staircase.
 * 
 * Constraints
 * 
 * 0<n<=100.
 * 
 * Output Format
 * 
 * Print a staircase of size n using # symbols and spaces.
 * Note: The last line must have 0 spaces in it.
 * 
 * Sample Input
 * 6 
 * 
 * Sample Output
 * 
 *      #
 *     ##
 *    ###
 *   ####
 *  #####
 * ######
 * 
 * Explanation
 * 
 * The staircase is right-aligned, composed of # symbols and spaces, and has a height and width of n=6.
 * 
 * @author Mariana Azevedo
 * @since 29/12/2019
 */
public class Staircase {

	public static void main(String[] args) {
		staircase(4);
		staircase(6);
	}
	
	// Complete the staircase function below.
    static void staircase(int n) {
    	
    	StringBuilder stair = new StringBuilder("");
        
    	//Builds the a basic stair with no hashes
    	int i=0, j= 1;
    	IntStream.range(i, n).forEach(k -> stair.append(" "));
        
    	//Filling the stairs with the hashes
        IntStream.range(j, n+1).forEach(k -> {
        	stair.setCharAt(n-k,'#');
        	k++;
        	System.out.println(stair);
        });
    }

}
