package io.github.mariazevedo88.hc.prepkit.hashmaps;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Given two strings, determine if they share a common substring. A substring may be as small 
 * as one character. For example, the words "a", "and", "art" share the common substring a. 
 * The words "be" and "cat" do not share a substring.
 * 
 * Function Description
 * 
 * Complete the function twoStrings in the editor below. It should return a string, either 
 * YES or NO based on whether the strings share a common substring.
 * 
 * twoStrings has the following parameter(s):
 * - s1, s2: two strings to analyze.
 * 
 * Input Format
 * 
 * The first line contains a single integer p, the number of test cases.
 * The following p pairs of lines are as follows:
 * 
 * - The first line contains string .
 * - The second line contains string .
 * 
 * Constraints
 * 
 * - s1 and s2 consist of characters in the range ascii[a-z].
 * - 1<=p<=10
 * - 1<=|s1|,|s2|<=10^5
 * 
 * Output Format
 * 
 * For each pair of strings, return YES or NO.
 * 
 * Sample Input
 * 
 * 2
 * hello
 * world
 * hi
 * world
 * 
 * Sample Output
 * 
 * YES
 * NO
 * 
 * Explanation
 * 
 * We have p=2 pairs to check:
 * 
 * 1) s1="hello", s2="world". The substrings "o" and "1" are common to both strings.
 * 2) a="hi", b="world". s1 and s2 share no common substrings.
 * 
 * @author Mariana Azevedo
 * @since 02/12/2019
 */
public class TwoStrings {
	
	private static final Logger logger = LoggerFactory.getLogger(TwoStrings.class);

	public static void main(String[] args) {
		logger.info(twoStrings("hello", "world"));
		logger.info(twoStrings("hi", "world"));
	}
	
	// Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	
    	Set<Character> firstString = new HashSet<>();
    	for(char c : s1.toCharArray()) {
    		firstString.add(c);
    	}
    	
    	Set<Character> secondString = new HashSet<>();
    	for(char c : s2.toCharArray()) {
    		secondString.add(c);
    	}
    	
    	firstString.retainAll(secondString);
    	
    	return firstString.isEmpty() ? "NO" : "YES";
    }

}
