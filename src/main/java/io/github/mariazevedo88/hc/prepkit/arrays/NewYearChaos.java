package io.github.mariazevedo88.hc.prepkit.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person 
 * wears a sticker indicating their initial position in the queue. Initial positions increment by 1 from 1 at the front of the line to n at 
 * the back.
 * 
 * Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the 
 * same sticker denoting their original places in line. One person can bribe at most two others. For example, if n=8 and Person 5 bribes Person 4, 
 * the queue will look like this: 1,2,3,5,4,6,7,8.
 * 
 * Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!
 * 
 * Function Description
 * 
 * Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of bribes necessary, or Too chaotic 
 * if the line configuration is not possible.
 * 
 * minimumBribes has the following parameter(s):
 * - q: an array of integers
 * 
 * Input Format
 * 
 * The first line contains an integer , the number of test cases.
 * 
 * Each of the next  pairs of lines are as follows:
 *  - The first line contains an integer , the number of people in the queue
 *  - The second line has  space-separated integers describing the final state of the queue.
 *  
 * Constraints
 * 
 * - 1<=t<=10
 * - 1<=n<=10^5
 * 
 * Subtasks
 * 
 * For 60% score 1<=n<=10³ 
 * For 100% score 1<=n<=10^5
 * 
 * Output Format
 * 
 * Print an integer denoting the minimum number of bribes needed to get the queue into its final state. Print Too chaotic if the state is invalid, i.e. 
 * it requires a person to have bribed more than 2 people.
 * 
 * Sample Input
 * 2
 * 5
 * 2 1 5 3 4
 * 5
 * 2 5 1 3 4
 * 
 * Sample Output
 * 3
 * Too chaotic
 * 
 * @author Mariana Azevedo
 * @since 15/11/2019
 */
public class NewYearChaos {
	
	private static final Logger logger = LoggerFactory.getLogger(NewYearChaos.class);

	public static void main(String[] args) {

		int[] queue1 = {2, 1, 5, 3, 4};
		minimumBribes(queue1);
		
		int[] queue2 = {5, 1, 2, 3, 7, 8, 6, 4};
		minimumBribes(queue2);
		
		int[] queue3 = {1, 2, 5, 3, 4, 7, 8, 6};
		minimumBribes(queue3);
		
		minimumBribes(null);
		
	}
	
	// Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

    	if(q == null) {
    		logger.info("Too chaotic");
    		return;
    	}

    	int swapCount = 0;
    	
    	//Swap on inverse order
    	for (int i=q.length -1; i>=0; i--) {
    		if(q[i] != i+1) {
    			if(((i -1) >=0) && q[i-1] == (i+1)) {
    				swapCount++;
    				swap(q, i, i-1);
    			}else if(((i-2) >=0) && q[i-2]==(i+1)) {
    				swapCount+=2;
    				swap(q, i-2, i-1);
    				swap(q, i-1, i);
    			}else {
    				logger.info("Too chaotic");
    				return;
    			}
    		}
    	}
    	
    	logger.info(String.valueOf(swapCount));
    }
    
    private static void swap(int[] queue, int i, int j) {
    	int temp = queue[i];
    	queue[i] = queue[j];
    	queue[j] = temp;
	}
}
