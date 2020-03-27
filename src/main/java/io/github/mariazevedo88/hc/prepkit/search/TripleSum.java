package io.github.mariazevedo88.hc.prepkit.search;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Given 3 arrays a, b, c of different sizes, find the number of distinct triplets (p, q, r) where p 
 * is an element of a, written as p E a, q E b, and r E c, satisfying the criteria: p <= q and q >= r.
 * 
 * For example, given a=[3,5,7], b=[3,6] and c=[4,6,9], we find four distinct triplets: (3,6,4), (3,6,6),
 * (5,6,4), (5,6,6).
 * 
 * Function Description
 * 
 * Complete the triplets function in the editor below. It must return the number of distinct triplets that 
 * can be formed from the given arrays.
 * 
 * triplets has the following parameter(s):
 * - a, b, c: three arrays of integers.
 * 
 * Input Format
 * 
 * The first line contains 3 integers lena, lenb, and lenc the sizes of the three arrays.
 * The next 3 lines contain space-separated integers numbering lena, lenb, and lenc respectively.
 * 
 * Constraints
 * 
 * 1 <= lena, lenb, lenc <= 10^5
 * 1 <= all element in a,b,c < 10^8
 * 
 * Output Format
 * 
 * Print an integer representing the number of distinct triplets.
 * 
 * Sample Input 0
 * 
 * 3 2 3
 * 1 3 5
 * 2 3
 * 1 2 3
 * 
 * Sample Output 0
 * 
 * 8 
 * 
 * Explanation 0
 * 
 * The special triplets are (1,2,1),(1,2,2),(1,3,1),(1,3,2),(1,3,3),(3,3,1),(3,3,2),(3,3,3).
 * 
 * Sample Input 1
 * 
 * 3 3 3
 * 1 4 5
 * 2 3 3
 * 1 2 3
 * 
 * Sample Output 1
 * 
 * 5 
 * 
 * Explanation 1
 * 
 * The special triplets are (1,2,1),(1,2,2),(1,3,1),(1,3,2),(1,3,3).
 * 
 * Sample Input 2
 * 
 * 4 3 4
 * 1 3 5 7
 * 5 7 9
 * 7 9 11 13
 * 
 * Sample Output 2
 * 
 * 12
 * 
 * Explanation 2
 * 
 * The special triplets are (1,7,7),(1,9,7),(1,9,9),(3,7,7),(3,9,7),(3,9,9),(5,7,7),(5,9,7),
 * (5,9,9),(7,7,7),(7,9,7),(7,9,9).
 * 
 * @author Mariana Azevedo
 * @since 27/03/2020
 */
public class TripleSum {
	
	private static final Logger logger = LoggerFactory.getLogger(TripleSum.class);

	public static void main(String[] args) {
		int[] a1 = {1, 3, 5};
		int[] b1 = {2, 3};
		int[] c1 = {1, 2, 3};
		logger.info(String.valueOf(triplets(a1, b1, c1)));
		
		int[] a2 = {1, 4, 5};
		int[] b2 = {2, 3, 3};
		int[] c2 = {1, 2, 3};
		logger.info(String.valueOf(triplets(a2, b2, c2)));
		
		int[] a3 = {1, 3, 5, 7};
		int[] b3 = {5, 7, 9};
		int[] c3 = {7, 9, 11, 13};
		logger.info(String.valueOf(triplets(a3, b3, c3)));
	}
	
	// Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
    	
    	//First, get the distinct elements in all the arrays to make the sets.  
    	int[] arrayA = Arrays.stream(a).distinct().sorted().toArray();
        int[] arrayB = Arrays.stream(b).distinct().sorted().toArray();
        int[] arrayC = Arrays.stream(c).distinct().sorted().toArray();
        
        long tripletsSum = 0;
        
        //Then, find all elements in b and c less than or equal to each 
        //element of b, using binary search and get their product.
        for (int elementB : arrayB) {
            long sumA = Math.abs(Arrays.binarySearch(arrayA, elementB) + 1);
            long sumC = Math.abs(Arrays.binarySearch(arrayC, elementB) + 1);
            tripletsSum += sumA * sumC;
        }
        
        return tripletsSum;
    }

}
