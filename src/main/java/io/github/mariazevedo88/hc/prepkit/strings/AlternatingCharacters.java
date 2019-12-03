package io.github.mariazevedo88.hc.prepkit.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You are given a string containing characters  and  only. Your task is to change it into a string such 
 * that there are no matching adjacent characters. To do this, you are allowed to delete zero or more 
 * characters in the string.
 * 
 * Your task is to find the minimum number of required deletions.
 * 
 * For example, given the string s=AABAAB, remove an A at positions 0 and 3 to make s=ABAB in 2 deletions.
 * 
 * Function Description
 * 
 * Complete the alternatingCharacters function in the editor below. It must return an integer representing 
 * the minimum number of deletions to make the alternating string.
 * 
 * alternatingCharacters has the following parameter(s):
 * 
 * - s: a string
 * 
 * Input Format
 * 
 * The first line contains an integer q, the number of queries.
 * The next q lines each contain a string s.
 * 
 * Constraints
 * 
 * - 1<=q<=10
 * - 1<=|s|<10^5
 * - Each string s will consist only of characters A and B
 *  
 * Output Format
 * 
 * For each query, print the minimum number of deletions required on a new line.
 * 
 * Sample Input
 * 
 * 5
 * AAAA
 * BBBBB
 * ABABABAB
 * BABABA
 * AAABBB
 * 
 * Sample Output
 * 
 * 3
 * 4
 * 0
 * 0
 * 4
 * 
 * Explanation
 * 
 * The characters marked red are the ones that can be deleted so that the string doesn't have matching 
 * consecutive characters.
 * 
 * @author Mariana Azevedo
 * @since 02/12/2019
 */
public class AlternatingCharacters {
	
	private static final Logger logger = LoggerFactory.getLogger(AlternatingCharacters.class);

	public static void main(String[] args) {
		
		logger.info(String.valueOf(alternatingCharacters("AAAA")));
		logger.info(String.valueOf(alternatingCharacters("BBBBB")));
		logger.info(String.valueOf(alternatingCharacters("ABABABAB")));
		logger.info(String.valueOf(alternatingCharacters("BABABA")));
		logger.info(String.valueOf(alternatingCharacters("AAABBB")));

	}
	
	// Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
    	int minDeletion = 0;
    	
    	for(int i=0; i<s.length()-1; i++) {
    		if(s.charAt(i) == s.charAt(i+1)) {
    			minDeletion++;
    		}
    	}
    	
    	return minDeletion;
    }

}
