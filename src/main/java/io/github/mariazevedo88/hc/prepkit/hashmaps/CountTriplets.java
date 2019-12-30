package io.github.mariazevedo88.hc.prepkit.hashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You are given an array and you need to find number of tripets of indices (i,j,k) such that the elements at those indices 
 * are in geometric progression for a given common ratio r and i<j<k.
 * 
 * For example, arr = [1,4,16,64]. If r = 4, we have [1,4,16] and [4,16,64] at indices (0,1,2) and (1,2,3).
 * 
 * Function Description
 * 
 * Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric 
 * progression for a given r as an integer.
 * 
 * countTriplets has the following parameter(s):
 * 
 * - arr: an array of integers
 * - r: an integer, the common ratio
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers n and r, the size of arr and the common ratio.
 * The next line contains n space-seperated integers arr[i].
 * 
 * Constraints
 * 
 * 1<=n<=10^5
 * 1<=r<=10^9
 * 1<=arr[i]<=10^9
 * 
 * Output Format
 * 
 * Return the count of triplets that form a geometric progression.
 * 
 * Sample Input 0
 * 4 2
 * 1 2 2 4
 * 
 * Sample Output 0
 * 2
 * 
 * Explanation 0
 * 
 * There are 2 triplets in satisfying our criteria, whose indices are (0,1,3) and (0,2,3) 
 * 
 * Sample Input 1
 * 6 3
 * 1 3 9 9 27 81
 * 
 * Sample Output 1
 * 6
 * 
 * Explanation 1
 * 
 * The triplets satisfying are index (0,1,2), (0,1,3), (1,2,4), (1,3,4), (2,4,5) and (3,4,5).
 * 
 * Sample Input 2
 * 5 5
 * 1 5 5 25 125
 * 
 * Sample Output 2
 * 4
 * 
 * Explanation 2
 * The triplets satisfying are index (0,1,3), (0,2,3), (1,3,4), (2,3,4).
 * 
 * @author Mariana Azevedo
 * @since 30/12/2019
 */
public class CountTriplets {
	
	private static final Logger logger = LoggerFactory.getLogger(CountTriplets.class);

	public static void main(String[] args) {
		long[] input1 = {1,2,2,4};
		List<Long> arr1 = Arrays.stream(input1).boxed().collect(Collectors.toList());
		logger.info(String.valueOf(countTriplets(arr1, 2)));
		
		long[] input2 = {1,3,9,9,27,81};
		List<Long> arr2 = Arrays.stream(input2).boxed().collect(Collectors.toList());
		logger.info(String.valueOf(countTriplets(arr2, 3)));
	}
	
	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	
    	long total = 0;
        Map<Long, Long> count = new HashMap<>(); // count of ints
        Map<Long, Long> triplets = new HashMap<>(); // map 2nd -> count of links
        
        for (int i = 0; i < arr.size(); ++i) {
            long value = arr.get(i);
            // incrementing total
            if (value % r == 0 && triplets.containsKey(value / r)) {
                total += triplets.get(value / r);
            }
            // create links/triplets
            if (triplets.containsKey(value)) {
                triplets.put(value, triplets.get(value) + count.get(value/r));
            } else if (value % r == 0 && count.containsKey(value / r)) {
                triplets.put(value, count.get(value / r));
            }

            // incrementing the counter
            if (count.containsKey(value))
                count.put(value, count.get(value)+1);
            else
                count.put(value, 1L);
        }

        return total;
    }
}
