package io.github.mariazevedo88.hc.prepkit.recursion;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Fibonacci sequence appears in nature all around us, in the arrangement of seeds in a sunflower and the 
 * spiral of a nautilus for example.
 * 
 * The Fibonacci sequence begins with fibonacci(0) and fibonacci(1) as its first and second terms. After these 
 * first two elements, each subsequent element is equal to the sum of the previous two elements.
 * 
 * Programmatically:
 * 
 * - fibonacci(0) = 0
 * - fibonacci(1) = 1
 * - fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
 * 
 * Given n, return the nth number in the sequence.
 * 
 * As an example, n = 5. The Fibonacci sequence to 6 is fs=[0,1,1,2,3,5,8]. With zero-based indexing, fs[5]=5.
 * 
 * Function Description
 * 
 * Complete the recursive function fibonacci in the editor below. It must return the nth element in the Fibonacci sequence.
 * 
 * fibonacci has the following parameter(s):
 * - n: the integer index of the sequence to return
 * 
 * Input Format
 * 
 * The input line contains a single integer, n.
 * 
 * Constraints
 * 
 * 0<=n<=30
 * 
 * Output Format
 * 
 * Locked stub code in the editor prints the integer value returned by the fibonacci function.
 * 
 * Sample Input
 * 3  
 * 
 * Sample Output
 * 2
 * 
 * Explanation
 * 
 * The Fibonacci sequence begins as follows:
 * 
 * - fibonacci(0) = 0
 * - fibonacci(1) = 1
 * - fibonacci(2) = (0+1) = 1
 * - fibonacci(3) = (1+1) = 2
 * - fibonacci(4) = (1+2) = 3
 * - fibonacci(5) = (2+3) = 5
 * - fibonacci(6) = (3+5) = 8
 * ...
 * 
 * We want to know the value of fibonacci(3). In the sequence above, fibonacci(3) evaluates to 2.
 * 
 * @author Mariana Azevedo
 * @since 12/12/2019
 */
public class FibonacciNumbers {
	
	private static final Logger logger = LoggerFactory.getLogger(FibonacciNumbers.class);

	public static void main(String[] args) {
		
		logger.info(String.valueOf(fibonacci(0)));
		logger.info(String.valueOf(fibonacci(1)));
		logger.info(String.valueOf(fibonacci(2)));
		logger.info(String.valueOf(fibonacci(3)));
		logger.info(String.valueOf(fibonacci(4)));
		logger.info(String.valueOf(fibonacci(5)));
		logger.info(String.valueOf(fibonacci(6)));
		
	}
	
	// Complete the function.
	public static int fibonacci(int n) {
		return Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
				.limit(n)
				.map(t -> t[1])
				.reduce((a, b) -> b).orElse(0);
    }

}
