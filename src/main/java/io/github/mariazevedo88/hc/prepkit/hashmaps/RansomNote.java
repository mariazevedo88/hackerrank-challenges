package io.github.mariazevedo88.hc.prepkit.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Mariana Azevedo
 * @since 17/11/2019
 *
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
