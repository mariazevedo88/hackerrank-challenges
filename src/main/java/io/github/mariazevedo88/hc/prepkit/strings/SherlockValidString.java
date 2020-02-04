package io.github.mariazevedo88.hc.prepkit.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can 
 * remove just 1 character at 1 index in the string, and the remaining characters will occur the same number of times. Given a string s, 
 * determine if it is valid. If so, return YES, otherwise return NO.
 * 
 * For example, if s=abc, it is a valid string because frequencies are {a:1, b:1, c:1}. So is s = abcc because we can remove one c and 
 * have 1 of each character in the remaining string. If s = abccc however, the string is not valid as we can only remove 1 occurrence of c. 
 * That would leave character frequencies of {a:1, b:1, c:2}.
 * 
 * Function Description
 * 
 * Complete the isValid function in the editor below. It should return either the string YES or the string NO.
 * 
 * isValid has the following parameter(s):
 * - s: a string
 * 
 * Input Format
 * 
 * A single string s.
 * 
 * Constraints
 * 
 * 1 <= |s| <= 10^5 
 * Each character s[i] E ascii[a-z]
 * 
 * Output Format
 * 
 * Print YES if string s is valid, otherwise, print NO.
 * 
 * Sample Input 0
 * 
 * aabbcd
 * 
 * Sample Output 0
 * 
 * NO
 * 
 * Explanation 0
 * 
 * Given s="aabbcd", we would need to remove two characters, both c and d -> aabb or a and b -> abcd, to make it valid. 
 * We are limited to removing only one character, so s is invalid.
 * 
 * Sample Input 1
 * 
 * aabbccddeefghi
 * 
 * Sample Output 1
 * 
 * NO
 * 
 * Explanation 1
 * 
 * Frequency counts for the letters are as follows:
 * {'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}
 * 
 * There are two ways to make the valid string:
 * 
 * Remove 4 characters with a frequency of 1: {fghi}.
 * Remove 5 characters of frequency 2: {abcde}.
 * 
 * Neither of these is an option.
 * 
 * Sample Input 2
 * 
 * abcdefghhgfedecba
 * 
 * Sample Output 2
 * 
 * YES
 * 
 * Explanation 2
 * 
 * All characters occur twice except for e which occurs 3 times. We can delete one instance of e to have a valid string.
 * 
 * @author Mariana Azevedo
 * @since 04/02/2020
 */
public class SherlockValidString {
	
	private static final Logger logger = LoggerFactory.getLogger(SherlockValidString.class);
	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String[] args) {
		logger.info(isValid("aabbcd"));
		logger.info(isValid("aabbccddeefghi"));
		logger.info(isValid("abcdefghhgfedecba"));
	}
	
	// Complete the isValid function below.
    static String isValid(String s) {

        Map<Character,Long> charCountingMap = s.chars().mapToObj(value -> (char) value)
        		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                
        Map<Long,Long> frequencyMap = new ArrayList<>(charCountingMap.values()).stream()
        		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                
        long maxFrequency = Collections.max(frequencyMap.entrySet(), (e1, e2) -> 
        	(int) (e1.getValue() - e2.getValue())).getKey();
                
        long minFrequency = Collections.min(frequencyMap.entrySet(), (e1, e2) -> 
        	(int) (e1.getValue() - e2.getValue())).getKey();
        
        if(frequencyMap.size() == 1) return YES;
        
        if(frequencyMap.size() > 2 || frequencyMap.get(maxFrequency) != charCountingMap.size() - 1 ||
        		(minFrequency != 1 && minFrequency - maxFrequency != 1)){
            return NO;
        }

        return YES;
    }

}
