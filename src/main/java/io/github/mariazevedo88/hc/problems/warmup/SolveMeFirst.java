package io.github.mariazevedo88.hc.problems.warmup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Complete the function solveMeFirst to compute the sum of two integers.
 * 
 * Function prototype:
 * 
 * int solveMeFirst(int a, int b);
 * 
 * where,
 * 
 * - a is the first integer input.
 * - b is the second integer input
 * 
 * Return values
 * 
 * - sum of the above two integers
 * 
 * Sample Input
 * a = 2
 * b = 3
 * 
 * Sample Output
 * 5
 * 
 * Explanation
 * 
 * The sum of the two integers a and b is computed as: 2+3=5.
 * 
 * @author Mariana Azevedo
 * @since 29/12/2019
 */
public class SolveMeFirst {
	
	private static final Logger logger = LoggerFactory.getLogger(SolveMeFirst.class);

	public static void main(String[] args) {
		logger.info(String.valueOf(solveMeFirst(2, 3)));
		logger.info(String.valueOf(solveMeFirst(100, 1000)));
	}
	
	static int solveMeFirst(int a, int b) {
		return a + b;
    }

}
