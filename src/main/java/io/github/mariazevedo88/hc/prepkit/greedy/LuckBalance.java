package io.github.mariazevedo88.hc.prepkit.greedy;

import java.util.Arrays;
import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lena is preparing for an important coding competition that is preceded by a number of sequential preliminary contests. Initially, 
 * her luck balance is 0. She believes in "saving luck", and wants to check her theory. Each contest is described by two integers, 
 * L[i] and T[i]:
 * 
 * - L[i] is the amount of luck associated with a contest. If Lena wins the contest, her luck balance will decrease by L[i]; if she 
 * loses it, her luck balance will increase by L[i].
 * - T[i] denotes the contest's importance rating. It's equal to 1 if the contest is important, and it's equal to 0 if it's unimportant.
 * 
 * If Lena loses no more than k important contests, what is the maximum amount of luck she can have after competing in all the preliminary 
 * contests? This value may be negative.
 * 
 * For example, k=2 and:
 * 
 * Contest		L[i]	T[i]
 *    1		     5	     1
 *    2		     1	     1
 *    3		     4	     0
 *    
 * If Lena loses all of the contests, her will be 5+1+4=10. Since she is allowed to lose 2 important contests, and there are only 2 important 
 * contests. She can lose all three contests to maximize her luck at 10. If k=1, she has to win at least 1 of the 2 important contests. She 
 * would choose to win the lowest value important contest worth 1. Her final luck will be 5+4-1=8.
 * 
 * Function Description
 * 
 * Complete the luckBalance function in the editor below. It should return an integer that represents the maximum luck balance achievable.
 * 
 * luckBalance has the following parameter(s):
 * 
 * - k: the number of important contests Lena can lose 
 * - contests: a 2D array of integers where each contests[i] contains two integers that represent the luck balance and importance of the ith 
 * contest.
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers n and k, the number of preliminary contests and the maximum number of important contests 
 * Lena can lose.
 * 
 * Each of the next n lines contains two space-separated integers, L[i] and T[i], the contest's luck balance and its importance rating.
 * 
 * Constraints
 * 
 * 1<=n<=100
 * 0<=k<=N
 * 1<=L[i]<=10^4
 * T[i] E {0,1}
 * 
 * Output Format
 * 
 * Print a single integer denoting the maximum amount of luck Lena can have after all the contests.
 * 
 * Sample Input
 * 
 * 6 3
 * 5 1
 * 2 1
 * 1 1
 * 8 1
 * 10 0
 * 5 0
 * 
 * Sample Output
 * 
 * 29
 * 
 * Explanation
 * 
 * There are n=6 contests. Of these contests, 4 are important and she cannot lose more than k=3 of them. Lena maximizes her luck if she wins the 
 * 3rd important contest (where L[i]=1) and loses all of the other five contests for a total luck balance of 5+2+8+10+5-1=29.
 * 
 * @author Mariana Azevedo
 * @since 09/12/2019
 */
public class LuckBalance {
	
	private static final Logger logger = LoggerFactory.getLogger(LuckBalance.class);

	public static void main(String[] args) {
		int[][] contests = {{5,1}, {2,1}, {1,1}, {8,1}, {10,0}, {5,0}};
		logger.info(String.valueOf(luckBalance(3, contests)));
	}
	
	// Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
    	int luckBalance = 0;
    	
    	Arrays.sort(contests, new Comparator<int[]>() {
    		public int compare(int a[], int b[]) {
    			//Decreasing order
				return -1 * Integer.compare(a[0], b[0]);
			}
    	});
    	
    	for(int i=0; i< contests.length; i++) {
    		int luck = contests[i][0];
    		int importance = contests[i][1];
    		
    		if(importance == 1 && k > 0) {
    			k--;
    			luckBalance += luck;
    		}else if (importance == 1 && k == 0){
    			luckBalance -= luck;
    		}
    		
    		if(importance == 0) luckBalance += luck;
    	}
    	
    	return luckBalance;
    }

}
