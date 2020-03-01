package io.github.mariazevedo88.hc.prepkit.dynamic;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Let's talk about binary numbers. We have an n-digit binary number, b, and we denote the digit at 
 * index i (zero-indexed from right to left) to be bi. We can find the decimal value of b using the 
 * following formula:
 * 
 * (b)2 -> bn-1 * 2^n-1 + ... + b2 * 2^2 + b1 * 2^1 + b0 + 2^0 = (?)10
 * 
 * For example, if binary number b = 10010, we compute its decimal value like so:
 * 
 * (10010)2 -> 1 * 2^4 + 0 * 2^3 + 0 * 2^2 + 1 * 2^1 + 0 * 2^0 = (18)10
 * 
 * Meanwhile, in our well-known decimal number system where each digit ranges from 0 to 9, the value 
 * of some decimal number, d, can be expanded in the same way:
 * 
 * d = dn-1 * 10^n-1 + ... + d2 * 10^2 + d1 * 10^1 + d0 * 10^0
 * 
 * Now that we've discussed both systems, let's combine decimal and binary numbers in a new system we 
 * call decibinary! In this number system, each digit ranges from 0 to 9 (like the decimal number system), 
 * but the place value of each digit corresponds to the one in the binary number system. For example, 
 * the decibinary number 2016 represents the decimal number 24 because:
 * 
 * (2016)decibinary -> 2 * 2^3 + 0 2^2 + 1 * 2^1 + 6 * 2^0 = (24)10
 * 
 * Pretty cool system, right? Unfortunately, there's a problem: two different decibinary numbers can evaluate 
 * to the same decimal value! For example, the decibinary number 2008 also evaluates to the decimal value 24:
 * 
 * This is a major problem because our new number system has no real applications beyond this challenge!
 * 
 * Consider an infinite list of non-negative decibinary numbers that is sorted according to the following rules:
 * 
 * - The decibinary numbers are sorted in increasing order of the decimal value that they evaluate to.
 * - Any two decibinary numbers that evaluate to the same decimal value are ordered by increasing decimal value, 
 * meaning the equivalent decibinary values are strictly interpreted and compared as decimal values and the smaller 
 * decimal value is ordered first. For example, (2)decibinary and (10)decibinary both evaluate to (2)10. We would 
 * order (2)decibinary before (10)decibinary because (2)10 < (10)10.
 * 
 * Here is a list of first few decibinary numbers properly ordered:
 * 
 * x   Decibinary  Decimal
 * 1       0          0
 * 2       1          1
 * 3       2          2
 * 4      10          2
 * 5       3          3
 * 6      11          3
 * 7       4          4
 * 8      12          4
 * 9      20          4
 * 10    100          4
 * .     ...        ...
 * 20    110          6
 * 
 * You will be given q queries in the form of an integer, x. For each x, find and print the the xth decibinary number 
 * in the list on a new line.
 * 
 * Function Description
 * 
 * Complete the decibinaryNumbers function in the editor below. For each query, it should return the decibinary number 
 * at that one-based index.
 * 
 * decibinaryNumbers has the following parameter(s):
 * 
 * - x: the index of the decibinary number to return
 * 
 * Input Format
 * 
 * The first line contains an integer, q, the number of queries.
 * Each of the next q lines contains an integer, x, describing a query.
 * 
 * Constraints
 * 
 * 1 <= q <= 10^5
 * 1 <= x <= 10^16
 * 
 * Subtasks
 * 
 * 1 <= x <= 50 for 10% of the maximum score
 * 1 <= x <= 9000 for 30% of the maximum score
 * 1 <= x <= 10^7 for 60% of the maximum score
 * 
 * Output Format
 * 
 * For each query, print a single integer denoting the the xth decibinary number in the list. Note that this must be the 
 * actual decibinary number and not its decimal value. Use 1-based indexing.
 * 
 * Sample Input 0
 * 
 * 5
 * 1
 * 2
 * 3
 * 4
 * 10
 * 
 * Sample Output 0
 * 
 * 0
 * 1
 * 2
 * 10
 * 100
 * 
 * Explanation 0
 * 
 * For each , we print the  decibinary number on a new line. See the figure in the problem statement.
 * 
 * Sample Input 1
 * 
 * 7
 * 8
 * 23
 * 19
 * 16
 * 26
 * 7
 * 6
 * 
 * Sample Output 1
 * 
 * 12
 * 23
 * 102
 * 14
 * 111
 * 4
 * 11
 * 
 * Sample Input 2
 * 
 * 10
 * 19
 * 25
 * 6
 * 8
 * 20
 * 10
 * 27
 * 24
 * 30
 * 11
 * 
 * Sample Output 2
 * 
 * 102
 * 103
 * 11
 * 12
 * 110
 * 100
 * 8
 * 31
 * 32
 * 5
 * 
 * @author Mariana Azevedo
 * @since 27/02/2020
 */
public class DecibinaryNumbers {
	
	private static final Logger logger = LoggerFactory.getLogger(DecibinaryNumbers.class);

	private static int maxDigits = 300000, digits = 10, pows = 20;

	private static long[][] duplicatesDigits = new long[maxDigits][pows];
	private static long[] duplicateOffset = new long[maxDigits];

	public static void main(String[] args) {
		
		preCompute();
		
		logger.info(String.valueOf(decibinaryNumbers(1))); //0
		logger.info(String.valueOf(decibinaryNumbers(2))); //1
		logger.info(String.valueOf(decibinaryNumbers(3))); //2
		logger.info(String.valueOf(decibinaryNumbers(4))); //10
		logger.info(String.valueOf(decibinaryNumbers(10))); //100
		
		logger.info(String.valueOf(decibinaryNumbers(8))); //12
		logger.info(String.valueOf(decibinaryNumbers(23))); //23
		logger.info(String.valueOf(decibinaryNumbers(19))); //102
		logger.info(String.valueOf(decibinaryNumbers(16))); //14
		logger.info(String.valueOf(decibinaryNumbers(26))); //111
		logger.info(String.valueOf(decibinaryNumbers(7))); //4
		logger.info(String.valueOf(decibinaryNumbers(6))); //11

	}
	
    private static void preCompute() {
        // Compute the number of duplicates for each value, number of digits.
        for (int i = 0; i < maxDigits; i++) {
            duplicatesDigits[i][0] = i < digits ? 1L : 0L;

            for (int j = 1; j < pows; j++) {
                // Duplicates is sum of all shorter numbers duplicates for each digit.
                for (int k = 0; k < digits; k++) {
                    int value = i - k * (1 << j);

                    // Exit if using digit creates number larger than target value.
                    if (value < 0) break;
                    duplicatesDigits[i][j] += duplicatesDigits[value][j - 1];
                }
            }
        }

        // Calculate the absolute offset for the first duplicate of each number.
        for (int i = 1; i < maxDigits; i++) {
            duplicateOffset[i] = duplicatesDigits[i - 1][pows - 1] + duplicateOffset[i - 1];
        }
    }
    
    // Complete the decibinaryNumbers function below.
    static long decibinaryNumbers(long x) {
    	
    	//Binary search makes the difference when we work with large numbers
        int length = Arrays.binarySearch(duplicateOffset, x - 1);
        long result = 0;
        
        if (length < 0) {
        	length = -length - 2;
        }
        
        int value = length;
        long offset = (x - 1) - duplicateOffset[length];

        // Find each digit.
        for (int i = pows - 1; i >= 1; i--) {
        	int power = 1 << i;

            // Find the digit which takes us closest to offset.
            for (int digit = 0; digit < digits; digit++) {
            	
                // Calculate value of remaining digits.
                int calculatedValue = value - digit * power;

                // If index is less than duplicates for remainder we have our digit.
                if (offset < duplicatesDigits[calculatedValue][i - 1]) {
                    result += digit;
                    value -= power * digit;
                    break;
                }

                // Subtract number of duplicates for this digit from offset.
                offset -= duplicatesDigits[calculatedValue][i - 1];
            }

            result *= 10;
        }

        // Whatever is left must be the last digit.
        result += value;

        return result;
    }

}
