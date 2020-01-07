package io.github.mariazevedo88.hc.prepkit.hashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You are given q queries. Each query is of the form two integers described below:
 * - 1x : Insert x in your data structure.
 * - 2y : Delete one occurence of y from your data structure, if present.
 * - 3z : Check if any integer is present whose frequency is exactly z. If yes, print 1 else 0.
 * 
 * The queries are given in the form of a 2-D array queries of size q where queries[i][0] contains 
 * the operation, and queries[i][1] contains the data element. For example, you are given array 
 * queries = [(1,1),(2,2),(3,2),(1,1),(2,1),(3,2)]. The results of each operation are:
 * 
 * Operation   Array   Output
 * (1,1)       [1]
 * (2,2)       [1]
 * (3,2)                   0
 * (1,1)       [1,1]
 * (1,1)       [1,1,1]
 * (2,1)       [1,1]
 * (3,2)                   1
 * 
 * Return an array with the output: [0,1].
 * 
 * Function Description
 * 
 * Complete the freqQuery function in the editor below. It must return an array of integers where 
 * each element is a 1 if there is at least one element value with the queried number of occurrences 
 * in the current array, or 0 if there is not.
 * 
 * freqQuery has the following parameter(s):
 * - queries: a 2-d array of integers
 * 
 * Input Format
 * 
 * The first line contains of an integer q, the number of queries.
 * Each of the next q lines contains two integers denoting the 2-d array queries.
 * 
 * Constraints
 * 
 * 1<=q<=10^6
 * 1<=x,y,z<=10^9
 * All queries[i][0]E{1,2,3}
 * 1<=queries[i][1]<=10^9
 *  
 * Output Format
 * 
 * Return an integer array consisting of all the outputs of queries of type 3.
 * 
 * Sample Input 0
 * 
 * 8
 * 1 5
 * 1 6
 * 3 2
 * 1 10
 * 1 10
 * 1 6
 * 2 5
 * 3 2
 * 
 * Sample Output 0
 * 
 * 0
 * 1
 * 
 * Explanation 0
 * 
 * For the first query of type 3, there is no integer whose frequency is 2 (array=[5,6]). 
 * So answer is 0. For the second query of type 3, there are two integers in array=[6,10,10,6] 
 * whose frequency is 2 (integers = 6 and 10). So, the answer is 1.
 * 
 * Sample Input 1
 * 
 * 4
 * 3 4
 * 2 1003
 * 1 16
 * 3 1
 * 
 * Sample Output 1
 * 
 * 0
 * 1
 * 
 * Explanation 1
 * 
 * For the first query of type 3, there is no integer of frequency 4. The answer is 0.
 * For the second query of type 3, there is one integer, 16 of frequency 1 so the answer is 1.
 * 
 * Sample Input 2
 * 
 * 10
 * 1 3
 * 2 3
 * 3 2
 * 1 4
 * 1 5
 * 1 5
 * 1 4
 * 3 2
 * 2 4
 * 3 2
 * 
 * Sample Output 2
 * 
 * 0
 * 1
 * 1
 * 
 * Explanation 2
 * 
 * When the first output query is run, the array is empty. We insert two 4's and two 5's before the second output query,
 * arr = [4,5,5,4] so there are two instances of elements occurring twice. We delete a 4 and run the same query. Now only 
 * the instances of 5 satisfy the query.
 * 
 * @author Mariana Azevedo
 * @since 06/01/2019
 */
public class FrequencyQueries {
	
	private static final Logger logger = LoggerFactory.getLogger(FrequencyQueries.class);

	public static void main(String[] args) {
		testFrequency1();
		testFrequency2();
	}

	// Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	
    	final Map<Integer, Integer> valuesMap = new HashMap<>();
	    final Map<Integer, Integer> occurrencesMap = new HashMap<>();
	    final List<Integer> frequencies = new ArrayList<>();

	    int key, value;
	    Integer oldFreq, newFreq, oldOccurrence, newOccurrence;
	    
	    for (List<Integer> query : queries) {
	        key = query.get(0);
	        value = query.get(1);
	        
	        if (key == 3) {
	            frequencies.add(occurrencesMap.get(value) == null ? 0 : 1);
	        }else{
	            oldFreq = valuesMap.get(value);
	            oldFreq = oldFreq == null ? 0 : oldFreq;
	            oldOccurrence = occurrencesMap.get(oldFreq);
	            oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;

	            if (key == 1) {
	                newFreq = oldFreq + 1;
	            }else{
	                newFreq = oldFreq - 1;
	            }
	        
	            newOccurrence = occurrencesMap.get(newFreq);
	            newOccurrence = newOccurrence == null ? 0 : newOccurrence;

	            if (newFreq < 1) {
	                valuesMap.remove(value);
	            }else{
	                valuesMap.put(value, newFreq);
	            }

	            if ((oldOccurrence - 1) < 1) {
	                occurrencesMap.remove(oldFreq);
	            }else{
	                occurrencesMap.put(oldFreq, oldOccurrence - 1);
	            }
	            
	            occurrencesMap.put(newFreq, newOccurrence + 1);
	        }
	    }
	    
	    return frequencies;
	}
    
    private static void testFrequency1() {
		
		List<Integer> list1 = Arrays.asList(3,4);
		List<Integer> list2 = Arrays.asList(2,1003);
		List<Integer> list3 = Arrays.asList(1,16);
		List<Integer> list4 = Arrays.asList(3,1);
		
		List<List<Integer>> listOfLists1 = new ArrayList<>();
		listOfLists1.add(list1);
		listOfLists1.add(list2);
		listOfLists1.add(list3);
		listOfLists1.add(list4);
		
		logger.info(String.valueOf(freqQuery(listOfLists1)));
	}
    
    private static void testFrequency2() {
		
		List<Integer> list5 = Arrays.asList(1,3);
		List<Integer> list6 = Arrays.asList(2,3);
		List<Integer> list7 = Arrays.asList(3,2);
		List<Integer> list8 = Arrays.asList(1,4);
		List<Integer> list9 = Arrays.asList(1,5);
		List<Integer> list10 = Arrays.asList(1,5);
		List<Integer> list11 = Arrays.asList(1,4);
		List<Integer> list12 = Arrays.asList(3,2);
		List<Integer> list13 = Arrays.asList(2,4);
		List<Integer> list14 = Arrays.asList(3,2);
		
		List<List<Integer>> listOfLists2 = new ArrayList<>();
		listOfLists2.add(list5);
		listOfLists2.add(list6);
		listOfLists2.add(list7);
		listOfLists2.add(list8);
		listOfLists2.add(list9);
		listOfLists2.add(list10);
		listOfLists2.add(list11);
		listOfLists2.add(list12);
		listOfLists2.add(list13);
		listOfLists2.add(list14);
		
		logger.info(String.valueOf(freqQuery(listOfLists2)));
	}
}
