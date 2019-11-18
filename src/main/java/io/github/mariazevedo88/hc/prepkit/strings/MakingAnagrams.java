package io.github.mariazevedo88.hc.prepkit.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings 
 * to be anagrams of each other if the first string's letters can be rearranged to form the second string. 
 * In other words, both strings must contain the same exact letters in the same exact frequency For example, 
 * bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 * 
 * Alice decides on an encryption scheme involving two large strings where encryption is dependent on the 
 * minimum number of character deletions required to make the two strings anagrams. Can you help her find 
 * this number?
 * 
 * Given two strings, a and b, that may or may not be of the same length, determine the minimum number of 
 * character deletions required to make a and b anagrams. Any characters can be deleted from either of the 
 * strings.
 * 
 * For example, if a=cde and b=dcf, we can delete e from string a and f from string b so that both remaining 
 * strings are cd and dc which are anagrams.
 * 
 * Function Description
 * 
 * Complete the makeAnagram function in the editor below. It must return an integer representing the minimum 
 * total characters that must be deleted to make the strings anagrams.
 * 
 * makeAnagram has the following parameter(s):
 * 
 * - a: a string
 * - b: a string
 * 
 * Input Format
 * 
 * The first line contains a single string, a.
 * The second line contains a single string, b.
 * 
 * Constraints
 * 
 * - 1<=|a|,|b|<=10^4
 * - The strings a and b consist of lowercase English alphabetic letters ascii[a-z].
 * 
 * Output Format
 * 
 * Print a single integer denoting the number of characters you must delete to make the two strings anagrams 
 * of each other.
 * 
 * Sample Input
 * cde
 * abc
 * 
 * Sample Output
 * 4
 * 
 * Explanation
 * 
 * We delete the following characters from our two strings to turn them into anagrams of each other:
 * 
 * 1) Remove d and e from cde to get c.
 * 2) Remove a and b from abc to get c.
 * 
 * We must delete 4 characters to make both strings anagrams, so we print 4 on a new line.
 * 
 * @author Mariana Azevedo
 * @since 18/11/2019
 */
public class MakingAnagrams {
	
	private static final Logger logger = LoggerFactory.getLogger(MakingAnagrams.class);

	public static void main(String[] args) {
		logger.info(String.valueOf(makeAnagram("cde", "abc")));
		logger.info(String.valueOf(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke")));
		logger.info(String.valueOf(makeAnagram("showman", "woman")));
		logger.info(String.valueOf(makeAnagram("am", "ma")));
	}
	
	// Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    	
    	int wordsRemoved = 0;
    	int[] aFrequency = new int[26];
    	int[] bFrequency = new int[26];
    	
    	if(a.equals(b)) return wordsRemoved;
    	
    	for(int i=0; i<a.length(); i++) {
    		char currentChar = a.charAt(i);
    		int charToInt = (int) currentChar;
    		int position = charToInt - (int)'a';
    		aFrequency[position]++;
    	}
    	
    	for(int i=0; i<b.length(); i++) {
    		char currentChar = b.charAt(i);
    		int charToInt = (int) currentChar;
    		int position = charToInt - (int)'a';
    		bFrequency[position]++;
    	}
    	
    	for(int i=0; i<26; i++) {
    		int diff = Math.abs(aFrequency[i] - bFrequency[i]);
    		wordsRemoved += diff;
    	}
    	
    	return wordsRemoved;
    }
}
