package io.github.mariazevedo88.hc.prepkit.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You can perform the following operations on the string, a:
 * 1. Capitalize zero or more of a's lowercase letters.
 * 2. Delete all of the remaining lowercase letters in a.
 * 
 * Given two strings, a and b, determine if it's possible to make a equal to b as described. If so, 
 * print YES on a new line. Otherwise, print NO.
 * 
 * For example, given a=AbcDE and b=ABDE, in a we can convert b and delete c to match b. If a=AbcDE 
 * and b=AFDE, matching is not possible because letters may only be capitalized or discarded, not changed.
 * 
 * Function Description
 * 
 * Complete the function abbreviation in the editor below. It must return either YES or NO.
 * 
 * abbreviation has the following parameter(s):
 * - a: the string to modify
 * - b: the string to match
 * 
 * Input Format
 * 
 * The first line contains a single integer q, the number of queries.
 * 
 * Each of the next q pairs of lines is as follows:
 * - The first line of each query contains a single string, a.
 * - The second line of each query contains a single string, b.
 * 
 * Constraints
 * 
 * 1 <= q <= 10
 * 1 <= |a|,|b| <= 1000
 * String a consists only of uppercase and lowercase English letters, ascii[A-Za-z].
 * String b consists only of uppercase English letters, ascii[A-Z].
 * 
 * Output Format
 * 
 * For each query, print YES on a new line if it's possible to make string a equal to string b. Otherwise, 
 * print NO.
 * 
 * Sample Input
 * 
 * 1
 * daBcd
 * ABC
 * 
 * Sample Output
 * 
 * YES
 * 
 * Explanation
 * 
 * daBcd -> dABCd -> ABC
 * 
 * We have a=daBcd and b=ABC. We perform the following operation:
 * 1. Capitalize the letters a and c in a so that a=dABCd.
 * 2. Delete all the remaining lowercase letters in a so that a=ABC.
 * 
 * Because we were able to successfully convert a to b, we print YES on a new line.
 * 
 * @author Mariana Azevedo
 * @since 24/02/2020
 */
public class Abbreviation {
	
	private static final Logger logger = LoggerFactory.getLogger(Abbreviation.class);

	public static void main(String[] args) {
		//Test case 1
		logger.info(abbreviation("daBcd", "ABC"));
		
		//Test case 2
		logger.info(abbreviation("Pi", "P"));
		logger.info(abbreviation("AfPZN", "APZNC"));
		logger.info(abbreviation("LDJAN", "LJJM"));
		logger.info(abbreviation("UMKFW", "UMKFW"));
		logger.info(abbreviation("KXzQ", "K"));
		logger.info(abbreviation("LIT", "LIT"));
		logger.info(abbreviation("QYCH", "QYCH"));
		logger.info(abbreviation("DFIQG", "DFIQG"));
		logger.info(abbreviation("sYOCa", "YOCN"));
		logger.info(abbreviation("JHMWY", "HUVPW"));
		
		//Test case 3
		logger.info(abbreviation("AbCdE", "AFE"));
		logger.info(abbreviation("beFgH", "EFG"));
		logger.info(abbreviation("beFgH", "EFH"));
	}
	
	 // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

    	if (a.equals(b)) return "YES";
    	
        String aUppercase = a.toUpperCase();
        int[][] maxLength = new int[a.length() + 1][b.length() + 1];
        
        int i = 1;
        for (char aChar : aUppercase.toCharArray()) {
            int j = 1;
            for (char bChar : b.toCharArray()) {
            	
            	if(a.charAt(i - 1) == aChar) {
            		if(aChar == bChar) {
            			maxLength[i][j] = maxLength[i - 1][j - 1] + 1;
            		}else {
            			maxLength[i][j] = 0;
            		}
            	}else {
            		if(aChar == bChar) {
            			maxLength[i][j] = Math.max(maxLength[i - 1][j - 1] + 1, maxLength[i - 1][j]);
            		}else {
            			maxLength[i][j] = maxLength[i - 1][j];
            		}
            	}
            	
                ++j;
            }
            ++i;
        }
        
        return (maxLength[a.length()][b.length()] != b.length()) ? "NO" : "YES";
    }

}
