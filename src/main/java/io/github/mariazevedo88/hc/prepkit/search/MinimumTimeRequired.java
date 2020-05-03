package io.github.mariazevedo88.hc.prepkit.search;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You are planning production for an order. You have a number of machines that each have a fixed number of 
 * days to produce an item. Given that all the machines operate simultaneously, determine the minimum number 
 * of days to produce the required order.
 * 
 * For example, you have to produce goal = 10 items. You have three machines that take machines=[2,3,2] days 
 * to produce an item. The following is a schedule of items produced:
 * 
 * Day Production  Count
 * 2   2               2
 * 3   1               3
 * 4   2               5
 * 6   3               8
 * 8   2              10
 * 
 * It takes 8 days to produce 10 items using these machines.
 * 
 * Function Description
 * 
 * Complete the minimumTime function in the editor below. It should return an integer representing the minimum 
 * number of days required to complete the order.
 * 
 * minimumTime has the following parameter(s):
 * - machines: an array of integers representing days to produce one item per machine
 * - goal: an integer, the number of items required to complete the order
 * 
 * Input Format
 * 
 * - The first line consist of two integers n and goal, the size of machines and the target production.
 * - The next line contains n space-separated integers, machines[i].
 * 
 * Constraints
 * 
 * 1 <= n <= 10^5
 * 1 <= goal <= 10^9
 * 1< = machines[i] < 10^9
 * 
 * Output Format
 * 
 * Return the minimum time required to produce goal items considering all machines work simultaneously.
 * 
 * Sample Input 0
 * 
 * 2 5
 * 2 3
 * 
 * Sample Output 0
 * 
 * 6
 * 
 * Explanation 0
 * 
 * In 6 days machine0 can produce 3 items and machine1 can produce 2 items. This totals up to 5.
 * 
 * Sample Input 1
 * 
 * 3 10
 * 1 3 4
 * 
 * Sample Output 1
 * 
 * 7
 * 
 * Explanation 1
 * 
 * In 7 minutes, machine0 can produce 7 items, machine1 can produce 2 items and machine2 can produce 1 item, which totals up to 10.
 * 
 * Sample Input 2
 * 
 * 3 12
 * 4 5 6
 * 
 * Sample Output 2
 * 
 * 20
 * 
 * Explanation 2
 * 
 * In 20 days machine[0] can produce 5 items, machine[1] can produce 4, and machine[2] can produce 3.
 * 
 * @author Mariana Azevedo
 * @since 03/05/2020
 */
public class MinimumTimeRequired {
	
	private static final Logger logger = LoggerFactory.getLogger(MinimumTimeRequired.class);

	public static void main(String[] args) {
		
		long[] machines1 = {2,3};
		logger.info(String.valueOf(minTime(machines1, 5)));
		
		long[] machines2 = {1,3,4};
		logger.info(String.valueOf(minTime(machines2, 10)));
		
		long[] machines3 = {4,5,6};
		logger.info(String.valueOf(minTime(machines3, 12)));
	}
	
	// Complete the minTime function below.
    static long minTime(long[] machines, long goal) {

    	Arrays.sort(machines);
    	
    	long minDays = 0;
        long maxDays = machines[0]*goal;
        long minTime = -1;
        
        while (minDays < maxDays) {
            long mid = (minDays + maxDays)/2;
            long unit = 0;
            
            for (long machine : machines) {
                unit += mid / machine;
            }
            
            if (unit < goal) {
                minDays = mid + 1;
            } else {
                minTime = mid;
                maxDays = mid;
            }
        }
        
        return minTime;
    }
}
