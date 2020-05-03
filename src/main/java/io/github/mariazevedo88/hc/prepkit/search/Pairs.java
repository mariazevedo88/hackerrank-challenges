package io.github.mariazevedo88.hc.prepkit.search;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You will be given an array of integers and a target value. Determine the number of pairs of array 
 * elements that have a difference equal to a target value.
 * 
 * For example, given an array of [1, 2, 3, 4] and a target value of 1, we have three values meeting 
 * the condition: 2-1=1, 3-2=1, and 4-3=1.
 * 
 * Function Description
 * 
 * Complete the pairs function below. It must return an integer representing the number of element pairs 
 * having the required difference.
 * 
 * pairs has the following parameter(s):
 * - k: an integer, the target difference
 * - arr: an array of integers
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers n and k, the size of arr and the target value.
 * The second line contains n space-separated integers of the array arr.
 * 
 * Constraints
 * 
 * 2<= n <= 10^5
 * 0 < k < 10^9
 * 0 < arr[i] < 2^31-1
 * each integer a[i] will be unique
 * 
 * Output Format
 * 
 * An integer representing the number of pairs of integers whose difference is k.
 * 
 * Sample Input
 * 
 * 5 2
 * 1 5 3 4 2
 * 
 * Sample Output
 * 
 * 3
 * 
 * Explanation
 * 
 * There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1].
 * 
 * @author Mariana Azevedo
 * @since 03/05/2020
 */
public class Pairs {
	
	private static final Logger logger = LoggerFactory.getLogger(Pairs.class);

	public static void main(String[] args) {
		
		int[] arr1 = {1,5,3,4,2};
		logger.info(String.valueOf(pairs(2, arr1)));
		
		int[] arr2 = {1,3,5,8,6,4,2};
		logger.info(String.valueOf(pairs(2, arr2)));
		
		int[] arr3 = {363374326, 364147530, 61825163, 1073065718, 1281246024, 
				1399469912, 428047635, 491595254, 879792181, 1069262793};
		logger.info(String.valueOf(pairs(1, arr3)));

	}
	
	// Complete the pairs function below.
    static int pairs(int k, int[] arr) {

    	Set<Integer> numbers = IntStream.of(arr).boxed().collect(Collectors.toSet());
		Long numPairs = numbers.stream()
		                         .filter(i -> numbers.contains(i - k))
		                         .count();
		
		return numPairs.intValue();
    }

}
