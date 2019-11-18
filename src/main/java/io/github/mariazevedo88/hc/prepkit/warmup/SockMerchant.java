package io.github.mariazevedo88.hc.prepkit.warmup;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sock Merchant Challenge
 * 
 * John works at a clothing store. He has a large pile of socks that he must pair by color for sale. 
 * Given an array of integers representing the color of each sock, determine how many pairs of socks 
 * with matching colors there are. 
 * 
 * For example, there are n=7 socks with colors ar=[1,2,1,2,1,3,2]. There is one pair of color 1 and 
 * one of color 2. There are three odd socks left, one of each color. The number of pairs is 2.
 * 
 * Function Description
 * 
 * Complete the sockMerchant function in the editor below. It must return an integer representing the 
 * number of matching pairs of socks that are available.
 * 
 * sockMerchant has the following parameter(s):
 * n: the number of socks in the pile
 * ar: the colors of each sock
 * 
 * Input Format
 * 
 * The first line contains an integer n, the number of socks represented in ar.
 * The second line contains n space-separated integers describing the colors ar[i] of the socks in the pile.
 * 
 * Constraints
 * 
 * 1<=n<=100
 * 1<=ar[i]<=100 where 0<=i<=n 
 * 
 * Output Format
 * 
 * Return the total number of matching pairs of socks that John can sell.
 * 
 * Sample Input
 * 9
 * 10 20 20 10 10 30 50 10 20
 * 
 * Sample Output
 * 3
 * 
 * @author Mariana Azevedo
 * @since 06/10/2019
 */
public class SockMerchant {
    
	private static final Logger logger = LoggerFactory.getLogger(SockMerchant.class);
	
	public static void main(String[] args){
    	int[] ar = {10,20,20,10,10,30,50,10,20};
    	Integer result = sockMerchant(9, ar);
    	logger.info(result.toString());
    }
    
    static int sockMerchant(int n, int[] ar) {
    	
    	int numPairs = 0;
    	if(ar.length == 0 || n == 0) return numPairs;
    	
    	Set<Integer> countPairs = new HashSet<>();
    	for(int i=0; i<ar.length;i++) {
    		if(!countPairs.contains(ar[i])) countPairs.add(ar[i]);
    		else {
    			numPairs++;
    			countPairs.remove(ar[i]);
    		}
    	}
    	
    	return numPairs;
    }
}
