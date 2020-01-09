package io.github.mariazevedo88.hc.problems.warmup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Given an array of integers, find the sum of its elements.
 * 
 * For example, if the array ar=[1,2,3], 1+2+3 = 6, so return 6.
 * 
 * Function Description
 * 
 * Complete the simpleArraySum function in the editor below. It must return the 
 * sum of the array elements as an integer.
 * 
 * simpleArraySum has the following parameter(s):
 * - ar: an array of integers
 * 
 * Input Format
 * 
 * The first line contains an integer, n, denoting the size of the array.
 * The second line contains n space-separated integers representing the array's 
 * elements.
 * 
 * Constraints
 * 
 * 0<n,ar[i]<=1000
 * 
 * Output Format
 * 
 * Print the sum of the array's elements as a single integer.
 * 
 * Sample Input
 * 
 * 6
 * 1 2 3 4 10 11
 * 
 * Sample Output
 * 
 * 31
 * 
 * Explanation
 * 
 * We print the sum of the array's elements: 1 + 2 + 3 + 4 + 10 + 11 = 31.
 * 
 * @author Mariana Azevedo
 * @since 08/01/2020
 */
public class SimpleArraySum {

	private static final Logger logger = LoggerFactory.getLogger(SimpleArraySum.class);
	
	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,4,10,11};
		logger.info(String.valueOf(simpleArraySum(arr1))); //31
		
		int[] arr2 = {338, 65, 713, 595, 428, 610, 728, 573, 871, 868};
		logger.info(String.valueOf(simpleArraySum(arr2))); //5789
	}

	/*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        
        List<Integer> integers = Arrays.stream(ar).boxed().collect(Collectors.toList());
        Integer sum = integers.stream().reduce(0, Integer::sum);

        return sum;
    }
}
