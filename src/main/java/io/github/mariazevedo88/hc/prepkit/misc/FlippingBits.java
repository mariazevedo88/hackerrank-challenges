package io.github.mariazevedo88.hc.prepkit.misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You will be given a list of 32 bit unsigned integers. Flip all the bits (1 -> 0 and 0 -> 1) and print the result 
 * as an unsigned integer.
 * 
 * For example, your decimal input n=9 base 10 = 1001 base 2. We're working with 32 bits, so:
 * 0000000000000000000000000001001 base 2 = 9 base 10
 * 1111111111111111111111111110110 base 2 = 4294967286 base 10
 * 
 * Function Description
 * 
 * Complete the flippingBits function in the editor below. It should return the unsigned decimal integer result.
 * 
 * flippingBits has the following parameter(s):
 * - n: an integer
 * 
 * Input Format
 * 
 * The first line of the input contains q, the number of queries.
 * Each of the next q lines contain an integer, n, to process.
 * 
 * Constraints
 * 
 * 1<=q<=100
 * 0<=n<2^32
 * 
 * Output Format
 * 
 * Output one line per element from the list with the decimal value of the resulting unsigned integer.
 * 
 * Sample Input 0
 * 
 * 3
 * 2147483647
 * 1
 * 0
 * 
 * Sample Output 0
 * 
 * 2147483648
 * 4294967294
 * 4294967295
 * 
 * Sample Input 1
 * 
 * 2
 * 4
 * 123456
 * 
 * Sample Output 1
 * 
 * 4294967291
 * 4294843839
 * 
 * Sample Input 2
 * 
 * 3
 * 0
 * 802743475
 * 35601423
 * 
 * Sample Output 2
 * 
 * 4294967295
 * 3492223820
 * 4259365872
 * 
 * @author Mariana Azevedo
 * @since 11/12/2019
 */
public class FlippingBits {
	
	private static final Logger logger = LoggerFactory.getLogger(FlippingBits.class);

	public static void main(String[] args) {
		
		logger.info(String.valueOf(flippingBits(2147483647))); //2147483648
		logger.info(String.valueOf(flippingBits(1))); //4294967294
		logger.info(String.valueOf(flippingBits(0))); //4294967295
	}
	
	// Complete the flippingBits function below.
    static long flippingBits(long n) {
    	//Using ~ that is unary bitwise complement = just flip bits
        long unsignedNumber = ~n;
        //Using Bitwise AND 0xffffffffL to mask off those bits and 
        //convert signed int to unsigned 
        return unsignedNumber & 0xffffffffL;
    }

}
