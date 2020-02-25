package io.github.mariazevedo88.hc.prepkit.greedy;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A group of friends want to buy a bouquet of flowers. The florist wants to maximize his number of new customers 
 * and the money he makes. To do this, he decides he'll multiply the price of each flower by the number of that 
 * customer's previously purchased flowers plus 1. The first flower will be original price, (0+1) x original price, 
 * the next will be (1 + 1) x original price and so on.
 * 
 * Given the size of the group of friends, the number of flowers they want to purchase and the original prices of 
 * the flowers, determine the minimum cost to purchase all of the flowers.
 * 
 * For example, if there are k = 3 friends that want to buy n = 4 flowers that cost c = [1,2,3,4] each will buy one 
 * of the flowers priced [2,3,4] at the original price. Having each purchased x = 1 flower, the first flower in the 
 * list, c[0], will now cost (current purchase + previous purchases) x c[0] = (1 + 1) x 1 = 2. The total cost will 
 * be 2 + 3 + 4 + 2 = 11.
 * 
 * Function Description
 * 
 * Complete the getMinimumCost function in the editor below. It should return the minimum cost to purchase all of 
 * the flowers.
 * 
 * getMinimumCost has the following parameter(s):
 * - c: an array of integers representing the original price of each flower
 * - k: an integer, the number of friends
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers n and k, the number of flowers and the number of friends.
 * The second line contains n space-separated positive integers c[i], the original price of each flower.
 * 
 * Constraints
 * 
 * 1 <= n,k <= 100
 * 1 <= c[i] <= 10^6
 * answer < 2^31
 * 0 <= i <= n
 * 
 * Output Format
 * 
 * Print the minimum cost to buy all n flowers.
 * 
 * Sample Input 0
 * 
 * 3 3
 * 2 5 6
 * 
 * Sample Output 0
 * 
 * 13
 * 
 * Explanation 0
 * 
 * There are n = 3 flowers with costs c = [2,5,6] and k = 3 people in the group. If each person buys one flower, the 
 * total cost of prices paid is 2 + 5 + 6 = 13 dollars. Thus, we print 13 as our answer.
 * 
 * Sample Input 1
 * 
 * 3 2
 * 2 5 6
 * 
 * Sample Output 1
 * 
 * 15
 * 
 * Explanation 1
 * 
 * There are n = 3 flowers with costs c = [2,5,6] and k = 3 people in the group. We can minimize the total purchase 
 * cost like so:
 * 
 * 1. The first person purchases 2 flowers in order of decreasing price; this means they buy the more expensive flower 
 * (c1 = 5) first at price p1 = (0 + 1) x 5 = 5 dollars and the less expensive flower (c0 = 2) second at price 
 * p0 = (1 + 1) x 2 = 4 dollars.
 * 
 * 2. The second person buys the most expensive flower at price p2 = (0 + 1) x 6 = 6 dollars.
 * 
 * We then print the sum of these purchases, which is 5 + 4 + 6 = 15, as our answer.
 * 
 * Sample Input 2
 * 
 * 5 3
 * 1 3 5 7 9
 * 
 * Sample Output 2
 * 
 * 29
 * 
 * Explanation 2
 * 
 * The friends buy flowers for 9, 7 and 3, 5 and 1 for a cost of 9 + 7 + 3 * (1 + 1) + 5 + 1 * (1 + 1) = 29.
 * 
 * @author Mariana Azevedo
 * @since 25/02/2020
 */
public class GreedyFlorist {
	
	private static final Logger logger = LoggerFactory.getLogger(GreedyFlorist.class);

	public static void main(String[] args) {
		
		int[] arr1 = {2,5,6};
		logger.info(String.valueOf(getMinimumCost(3, arr1)));
		
		int[] arr2 = {2,5,6};
		logger.info(String.valueOf(getMinimumCost(2, arr2)));
		
		int[] arr3 = {1,3,5,7,9};
		logger.info(String.valueOf(getMinimumCost(3, arr3)));
	}
	
	// Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {

    	Arrays.sort(c);
		int result = 0, customer = 0, purchase = 0;
		
		for (int i = c.length - 1; i >= 0; i--) {
			result += c[i] * (purchase + 1);
			customer++;
			
			if (customer == k) {
				customer = 0;
				purchase++;
			}
		}
		
		return result;
    }
}
