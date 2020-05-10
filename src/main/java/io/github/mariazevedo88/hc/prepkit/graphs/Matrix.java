package io.github.mariazevedo88.hc.prepkit.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The kingdom of Zion has cities connected by bidirectional roads. There is a unique path between any pair of cities. 
 * Morpheus has found out that the machines are planning to destroy the whole kingdom. If two machines can join forces, 
 * they will attack. Neo has to destroy roads connecting cities with machines in order to stop them from joining forces. 
 * There must not be any path connecting two machines.
 * 
 * Each of the roads takes an amount of time to destroy, and only one can be worked on at a time. Given a list of edges 
 * and times, determine the minimum time to stop the attack.
 * 
 * For example, there are n=5 cities called 0 - 4. Three of them have machines and are colored red. The time to destroy is 
 * shown next to each road. If we cut the two green roads, there are no paths between any two machines. The time required 
 * is 3 + 2 = 5.
 * 
 *     2          Edge 0-4 = weight = 2
 *    /           Edge 0-1 = weight = 4
 *   1			  Edge 1-2 = weight = 3
 *  / \           Edge 1-3 = weight = 7
 * 0   3
 *  \
 *   4
 * 
 * Function Description
 * 
 * Complete the function minTime in the editor below. It must return an integer representing the minimum time to cut off 
 * access between the machines.
 * 
 * minTime has the following parameter(s):
 * 
 * - roads: a two-dimensional array of integers, each roads[i] = [city1, city2, time] where cities are connected by a road 
 * that takes time to destroy.
 * - machines: an array of integers representing cities with machines.
 * 
 * Input Format
 * 
 * The first line of the input contains two space-separated integers, n and k, the number of cities and the number of 
 * machines.
 * 
 * Each of the following n - 1 lines contains three space-separated integers, city1, city2, and time. There is a bidirectional 
 * road connecting city1 and city2, and to destroy this road it takes time units.
 * 
 * Each of the last k lines contains an integer, machine[i], the label of a city with a machine.
 * 
 * Constraints
 * 
 * 2 <= n <= 10^5
 * 2 <= k <= n
 * 1 <= time[i] < 10^6
 * 
 * Output Format
 * 
 * Return an integer representing the minimum time required to disrupt the connections among all machines.
 * 
 * Sample Input
 * 
 * 5 3
 * 2 1 8
 * 1 0 5
 * 2 4 5
 * 1 3 4
 * 2
 * 4
 * 0
 * 
 * Sample Output
 * 
 * 10
 * 
 * Explanation
 * 
 *     3           Edge 2-1 = weight = 8
 *    /            Edge 2-4 = weight = 5
 *   1             Edge 1-3 = weight = 4
 *  / \            Edge 1-0 = weight = 5
 * 2   0
 *  \
 *   4
 *   
 * The machines are located at the cities 0, 2 and 4. Neo can destroy the green roads resulting in a time of 5 + 5 = 10. 
 * Destroying the road between cities 2 and 1 instead of between 1 and 0 would work, but it's not minimal.
 * 
 * @author Mariana Azevedo
 * @since 10/05/2020
 */
public class Matrix {
	
	private static final Logger logger = LoggerFactory.getLogger(Matrix.class);

	public static void main(String[] args) {
		
		int[][] roads1 = {{2,1,8},{1,0,5},{2,4,5},{1,3,4}};
		int[] machines1 = {2,4,0};
		logger.info(String.valueOf(minTime(roads1, machines1)));
		
		int[][] roads2 = {{0,1,4},{1,2,3},{1,3,7},{0,4,2}};
		int[] machines2 = {2,3,4};
		logger.info(String.valueOf(minTime(roads2, machines2)));
	}
	
	// Complete the minTime function below.
    static int minTime(int[][] roads, int[] machines) {
    	
    	int numCities = roads.length + 1;
    	Arrays.sort(roads, (i, j) -> Integer.compare(j[2], i[2]));

    	Map<Integer,Integer> parent = new HashMap<>();
        boolean[] redFlag = new boolean[numCities];
        
        for (int machine: machines) {
        	redFlag[machine] = true;
        }

        // Find by Path Splitting
        IntFunction<Integer> find = i -> {
            while(i != parent.getOrDefault(i, i)) {
                i = parent.put(i, parent.get(i));
            }
            return i;
        };

        // Union by Size
        int[] size = new int[numCities];
        for(int i = 0; i < numCities; i++) {
        	size[i] = 1;
        }
        
        ToIntFunction<int[]> union = roadArray -> {
            
        	int rootU = find.apply(roadArray[0]);
            int rootV = find.apply(roadArray[1]);
            
            if(redFlag[rootU] && redFlag[rootV]) {
            	return roadArray[2];
            }

            if(rootU != rootV) {
                
            	if(size[rootU] > size[rootV]) {
                    int root = rootU;
                    rootU = rootV;
                    rootV = root;
                }
                
                parent.put(rootU, rootV);
                size[rootV] += size[rootU];
            }

            //bit-wise OR
            redFlag[rootU] |= redFlag[rootV];
            redFlag[rootV] |= redFlag[rootU];
            
            return 0;
        };

        return Arrays.stream(roads).map(union::applyAsInt).reduce(0, Integer::sum);
    }
}
