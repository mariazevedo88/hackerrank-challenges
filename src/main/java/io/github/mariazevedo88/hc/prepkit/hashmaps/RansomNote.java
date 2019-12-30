package io.github.mariazevedo88.hc.prepkit.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back 
 * to him through his handwriting. He found a magazine and wants to know if he can cut out whole 
 * words from it and use them to create an untraceable replica of his ransom note. The words in 
 * his note are case-sensitive and he must use only whole words available in the magazine. He 
 * cannot use substrings or concatenation to create the words he needs.
 * 
 * Given the words in the magazine and the words in the ransom note, print Yes if he can replicate 
 * his ransom note exactly using whole words from the magazine; otherwise, print No.
 * 
 * For example, the note is "Attack at dawn". The magazine contains only "attack at dawn". 
 * The magazine has all the right words, but there's a case mismatch. The answer is No.
 * 
 * Function Description
 * 
 * Complete the checkMagazine function in the editor below. It must print Yes if the note can be 
 * formed using the magazine, or No.
 * 
 * checkMagazine has the following parameters:
 * 
 * - magazine: an array of strings, each a word in the magazine
 * - note: an array of strings, each a word in the ransom note
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers, m and n, the numbers of words in the 
 * magazine and the note..
 * The second line contains m space-separated strings, each magazine[i].
 * The third line contains n space-separated strings, each note[i].
 * 
 * Constraints
 * 
 * 1<=m,n<=30000
 * 1<=|magazine[i]|,|note[i]|<=5.
 * Each word consists of English alphabetic letters (i.e., a to z and A to Z).
 * 
 * Output Format
 * 
 * Print Yes if he can use the magazine to create an untraceable replica of his ransom note. 
 * Otherwise, print No.
 * 
 * Sample Input 0
 * 
 * 6 4
 * give me one grand today night
 * give one grand today
 * 
 * Sample Output 0
 * 
 * Yes
 * 
 * Sample Input 1
 * 
 * 6 5
 * two times three is not four
 * two times two is four
 * 
 * Sample Output 1
 * 
 * No
 * 
 * Explanation 1
 * 
 * 'two' only occurs once in the magazine.
 * 
 * Sample Input 2
 * 
 * 7 4
 * ive got a lovely bunch of coconuts
 * ive got some coconuts
 * 
 * Sample Output 2
 * 
 * No
 * 
 * Explanation 2
 * 
 * Harold's magazine is missing the word some.
 * 
 * @author Mariana Azevedo
 * @since 17/11/2019
 */
public class RansomNote {
	
	private static final Logger logger = LoggerFactory.getLogger(RansomNote.class);
	
	private static final String YES = "Yes";
	private static final String NO = "No";

	public static void main(String[] args) {
		
		String[] magazine1 = {"give", "me", "one", "grand", "today", "night"};
		String[] note1 = {"give", "one", "grand", "today", "night"};
		checkMagazine(magazine1, note1);
		
		String[] magazine2 = {"two", "times", "three", "is", "not", "four"};
		String[] note2 = {"two", "times", "two", "is", "four"};
		checkMagazine(magazine2, note2);
		
		String[] magazine3 = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
		String[] note3 = {"ive", "got", "some", "coconuts"};
		checkMagazine(magazine3, note3);
		
		String[] magazine4 = {"h", "ghq", "g", "xxy", "wdnr", "anjst", "xxy", "wdnr", "h", "h", "anjst", "wdnr"};
		String[] note4 = {"h", "ghq"};
		checkMagazine(magazine4, note4);
	}
	
	static void checkMagazine(String[] magazine, String[] note) {

		Map<String, Integer> magazineHash = new HashMap<>();
		Map<String, Integer> noteHash = new HashMap<>();
		
		for(String m : magazine) {
			magazineHash.put(m, magazineHash.getOrDefault(m, 0) + 1);
		}
		
		for(String n : note) {
			noteHash.put(n, noteHash.getOrDefault(n, 0) + 1);
		}
		
		//Note has more words than magazine
		if(magazineHash.size() < noteHash.size()) {
			logger.info(NO);
		}else {
			//Check if note contains all words from magazine
			Optional<Integer> answer = noteHash.entrySet().stream()
					.map(w -> magazineHash.getOrDefault(w.getKey(), 0) - w.getValue())
					.filter(w -> w < 0)
					.findFirst();
			logger.info(answer.isPresent() ? NO : YES);
		}
    }
}
