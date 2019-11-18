package io.github.mariazevedo88.hc.prepkit.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. 
 * There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain 
 * amount to spend, and he wants to maximize the number of toys he buys with this money.
 * 
 * Given a list of prices and an amount to spend, what is the maximum number of toys Mark can buy? For example, 
 * if prices=[1,2,3,4] and Mark has k=7 to spend, he can buy items [1,2,3] for 6, or [3,4] for 7 units of currency. 
 * He would choose the first group of 3 items.
 * 
 * Function Description
 * 
 * Complete the function maximumToys in the editor below. It should return an integer representing the maximum number 
 * of toys Mark can purchase.
 * 
 * maximumToys has the following parameter(s):
 * 
 * - prices: an array of integers representing toy prices
 * - k: an integer, Mark's budget
 * 
 * Input Format
 * 
 * The first line contains two integers, n and k, the number of priced toys and the amount Mark has to spend.
 * The next line contains n space-separated integers prices[i] 
 * 
 * Constraints
 * 
 * 1<=n<=10^5
 * 1<=k<=10^9
 * 1<=prices[i]<=10^9
 *  
 * A toy can't be bought multiple times.
 * 
 * Output Format
 * 
 * An integer that denotes the maximum number of toys Mark can buy for his son.
 * 
 * Sample Input
 * 7 50
 * 1 12 5 111 200 1000 10
 * 
 * Sample Output
 * 4
 * 
 * Explanation
 * 
 * He can buy only 4 toys at most. These toys have the following prices: 1,12,5,10.
 * 
 * @author Mariana Azevedo
 * @since 17/11/2019
 *
 */
public class MarkToys {
	
	private static final Logger logger = LoggerFactory.getLogger(MarkToys.class);

	public static void main(String[] args) {
		
		int[] prices1 = {1, 12, 5, 111, 200, 1000, 10};
		logger.info(String.valueOf(maximumToys(prices1, 50)));
		
		int[] prices2 = {1, 2, 3, 4};
		logger.info(String.valueOf(maximumToys(prices2, 7)));
		
		int[] prices3 = {3, 7, 2, 9, 4};
		logger.info(String.valueOf(maximumToys(prices3, 15)));
	}
	
	// Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
    	
    	int sumPrices = 0;
    	int maxToys = 0;

    	if(prices.length == 0 || k == 0) return maxToys;
    	
    	List<Integer> toysPrices = Arrays.stream(prices).boxed().sorted().collect(Collectors.toList());
    	
    	while(sumPrices < k) {
    		sumPrices = sumPrices + toysPrices.get(maxToys);
    		if(sumPrices < k) maxToys++;
    	}
    	
    	return maxToys;
    }

}
