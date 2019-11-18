package io.github.mariazevedo88.hc.prepkit.warmup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last 
 * hike he took exactly n steps. For every step he took, he noted if it was an uphill, U, or a downhill, D step. Gary's hikes start 
 * and end at sea level and each step up or down represents a 1 unit change in altitude. We define the following terms:
 * 
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down 
 * to sea level.
 * 
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to 
 * sea level.
 * 
 * Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through. For example, 
 * if Gary's path is s = [DDUUUUDD], he first enters a valley 2 units deep. Then he climbs out an up onto a mountain 2 units high. 
 * Finally, he returns to sea level and ends his hike.
 * 
 * Function Description
 * 
 * Complete the countingValleys function in the editor below. It must return an integer that denotes the number of valleys Gary traversed.
 * 
 * countingValleys has the following parameter(s):
 * 
 * n: the number of steps Gary takes
 * s: a string describing his path
 * 
 * Input Format
 * 
 * The first line contains an integer , the number of steps in Gary's hike.
 * The second line contains a single string , of  characters that describe his path.
 * 
 * Constraints
 * 
 * 2<=n<=10^6
 * s[i] E {UD}
 * 
 * Output Format
 * 
 * Print a single integer that denotes the number of valleys Gary walked through during his hike.
 * 
 * Sample Input
 * 
 * 8
 * UDDDUDUU
 * 
 * Sample Output
 * 1
 * 
 * Explanation
 * 
 * If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:
 *
 *_/\      _
 *   \    /
 *    \/\/
 * 
 * He enters and leaves one valley.
 * 
 * @author Mariana Azevedo
 * @since 15/11/2019
 *
 */
public class CountingValleys {
	
	private static final Logger logger = LoggerFactory.getLogger(CountingValleys.class);

	public static void main(String[] args) {
		
		logger.info(String.valueOf(countingValleys(8, "UDDDUDUU"))); //1
		logger.info(String.valueOf(countingValleys(12, "DDUUDDUDUUUD"))); //2
		logger.info(String.valueOf(countingValleys(10, "UDUUUDUDDD"))); //0
		logger.info(String.valueOf(countingValleys(10, "DUDDDUUDUU"))); //2
	}
	
	// Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    	
    	int numValleys = 0;
    	int seaLvl = 0;
    	
    	for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == 'D') {
            	seaLvl -= 1;
            } else {
            	seaLvl += 1;
            }
            if(seaLvl == 0 && c == 'U') numValleys += 1;
        }
    	
    	return numValleys;
    }

}
