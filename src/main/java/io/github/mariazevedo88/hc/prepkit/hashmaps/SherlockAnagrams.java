package io.github.mariazevedo88.hc.prepkit.hashmaps;

import java.util.Arrays;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, 
 * find the number of pairs of substrings of the string that are anagrams of each other.
 * 
 * For example s=mom, the list of all anagrammatic pairs is [m,m],[mo,om] at positions [[0],[2]], [[0,1],[1,1]] respectively.
 * 
 * Function Description
 * 
 * Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic 
 * pairs of substrings in s.
 * 
 * sherlockAndAnagrams has the following parameter(s):
 * 
 * s: a string.
 * 
 * Input Format
 * 
 * The first line contains an integer q, the number of queries.
 * Each of the next q lines contains a string s to analyze.
 * 
 * Constraints
 * 
 * 1<=q<=10
 * 2<=|s|<=100
 * 
 * String s contains only lowercase letters E ascii[a-z].
 * 
 * Output Format
 * 
 * For each query, return the number of unordered anagrammatic pairs.
 * 
 * Sample Input 0
 * 
 * 2
 * abba
 * abcd
 * 
 * Sample Output 0
 * 
 * 4
 * 0
 * 
 * Explanation 0
 * 
 * The list of all anagrammatic pairs is [a,a], [ab,ba], [b,b] and [abb,bba] at positions [[0],[3]], [[0,1],[2,3]], [[1],[2]] 
 * and [[0,1,2],[1,2,3]] respectively.
 * 
 * No anagrammatic pairs exist in the second query as no character repeats.
 * 
 * Sample Input 1
 * 
 * 2
 * ifailuhkqq
 * kkkk
 * 
 * Sample Output 1
 * 
 * 3
 * 10
 * 
 * Explanation 1
 * 
 * For the first query, we have anagram pairs [i,i],[q,q] and [ifa,fai] at positions [[0],[3]], [[8],[9]] and [[0,1,2], [1,2,3]] 
 * respectively.
 * 
 * For the second query:
 * There are 6 anagrams of the form [k,k] at positions [[0],[1],[[0],[2]], [[0],[3]], [[1],[2]], [[1],[3]] and [[2],[3]].
 * There are 3 anagrams of the form [kk,kk] at positions [[0,1],[1,2]], [[0,1],[2,3]] and [[1,2], [2,3]].
 * There is 1 anagram of the form [kkk,kkk] at position [[0,1,2],[1,2,3]].
 * 
 * Sample Input 2
 * 
 * 1
 * cdcd
 * 
 * Sample Output 2
 * 
 * 5
 * 
 * Explanation 2
 * 
 * There are two anagrammatic pairs of length 1: [c,c] and [d,d].
 * There are three anagrammatic pairs of length 2: [cd,dc], [cd,cd], [dc,cd] at positions
 * [[0,1],[[1,2]], [[0,1],[2,3]], [[1,2],[2,3]] respectively.
 * 
 * @author Mariana Azevedo
 * @since 28/12/2019
 */
public class SherlockAnagrams {
	
	private static final Logger logger = LoggerFactory.getLogger(SherlockAnagrams.class);

	public static void main(String[] args) {
		logger.info(String.valueOf(sherlockAndAnagrams("abba")));
		logger.info(String.valueOf(sherlockAndAnagrams("abcd")));
		logger.info(String.valueOf(sherlockAndAnagrams("ifailuhkqq")));
		logger.info(String.valueOf(sherlockAndAnagrams("kkkk")));
		logger.info(String.valueOf(sherlockAndAnagrams("cdcd")));
	}
	
	// Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

    	HashMap<String, Integer> map = new HashMap<>();
        int totalCount = 0;

        // Generate all substrings (N^2)
        for(int i = 0 ; i < s.length(); i++){
            for(int j=i+1 ; j <= s.length(); j++){
                
            	String currentSubString = s.substring(i,j);

                // Sort all strings
                char[] chars = currentSubString.toCharArray();
                Arrays.sort(chars);
                currentSubString = String.valueOf(chars);
                
                // If sorted substring has been seen before
                if(map.containsKey(currentSubString)) {
                    // Check how many times we've seen it and add that amount to the count
                	int value = map.getOrDefault(currentSubString, 0);
                    totalCount += value;
                    map.merge(currentSubString, 1, Integer::sum);
                } else {
                    // Never seen it before = insert and set to 1 to indicate we've now seen it
                    map.put(currentSubString, 1);
                }
            }
        }
        return totalCount;
    }
}
