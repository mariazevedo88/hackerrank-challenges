package io.github.mariazevedo88.hc.prepkit.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Ruler of HackerLand believes that every citizen of the country should have access to a library. Unfortunately, HackerLand 
 * was hit by a tornado that destroyed all of its libraries and obstructed its roads! As you are the greatest programmer of 
 * HackerLand, the ruler wants your help to repair the roads and build some new libraries efficiently.
 * 
 * HackerLand has n cities numbered from 1 to n. The cities are connected by m bidirectional roads. A citizen has access to a 
 * library if:
 * 
 * - Their city contains a library.
 * - They can travel by road from their city to a city containing a library.
 * 
 * The following figure is a sample map of HackerLand where the dotted lines denote obstructed roads:
 * 
 *           2         5
 *          /|          \
 *         / |           \
 * 7------1  |            6
 *         \ |           /
 *          \|          /
 *           3         8
 *
 * The cost of repairing any road is c_road dollars, and the cost to build a library in any city is c_lib dollars. If in the above 
 * example c_road = 2 and c_lib = 3, we would build 5 roads at a cost of 5 x 2 = 10 and 2 libraries for a cost of 6. We don't need 
 * to rebuild one of the roads in the cycle 1 -> 2 -> 3 -> 1.
 * 
 * You are given q queries, where each query consists of a map of HackerLand and value of c_lib and c_road. For each query, find the 
 * minimum cost of making libraries accessible to all the citizens and print it on a new line.
 * 
 * Function Description
 * 
 * Complete the function roadsAndLibraries in the editor below. It must return the minimal cost of providing libraries to all, as an 
 * integer.
 * 
 * roadsAndLibraries has the following parameters:
 * - n: integer, the number of cities
 * - c_lib: integer, the cost to build a library
 * - c_road: integer, the cost to repair a road
 * - cities: 2D array of integers where each cities[i] contains two integers that represent cities connected by an obstructed road.
 * 
 * Input Format
 * 
 * The first line contains a single integer q, that denotes the number of queries.
 * 
 * The subsequent lines describe each query in the following format:
 * 
 * - The first line contains four space-separated integers that describe the respective values of n, m, c_lib and c_road, the number of 
 * cities, number of roads, cost of a library and cost of a road.
 * - Each of the next m lines contains two space-separated integers, u[i] and v[i], that describe a bidirectional road that connects 
 * cities u[i] and v[i].
 * 
 * Constraints
 * 
 * 1 <= q <= 10
 * 1 <= n <= 10^5
 * 0 <= m <= min(10^5, n(n-1)/2)
 * 1 <= c_road, c_lib <= 10^5
 * 1 <= u[i], v[i] <= n
 * Each road connects two distinct cities.
 * 
 * Output Format
 * 
 * For each query, print an integer that denotes the minimum cost to make libraries accessible to all the citizens on a new line.
 * 
 * Sample Input
 * 
 * 2
 * 3 3 2 1
 * 1 2
 * 3 1
 * 2 3
 * 6 6 2 5
 * 1 3
 * 3 4
 * 2 4
 * 1 2
 * 2 3
 * 5 6
 * 
 * Sample Output
 * 
 * 4
 * 12
 * 
 * Explanation
 * 
 * Perform the following 2 queries:
 * 
 * 1. HackerLand contains n=3 cities connected by m=3 bidirectional roads. The price of building a library is c_lib = 2 and the 
 * price for repairing a road is c_road=1.
 * 
 *     1 (library)
 *    / \
 *   /   \
 *  /     \
 * 3-------2
 * 
 * The cheapest way to make libraries accessible to all is to:
 * 
 * - Build a library in city 1 at a cost of x=2.
 * - Repair the road between cities 1 and 2 at a cost of y=1.
 * - Repair the road between cities 2 and 3 at a cost of y=1.
 * 
 * This gives a total cost of 2 + 1 + 1 = 4. Note that the road between cities 3 and 1 does not need to be repaired each is 
 * connected to city 2.
 * 
 * 2. In this scenario it is optimal to build a library in each city because the cost of building a library (c_lib = 2) is less 
 * than the cost of repairing a road (c_road = 5).
 * 
 *               1 (library)                  5 (library)
 *              / \                            \
 *             /   \                            \
 *            /     \                            \
 * (library) 3       2 (library)                  6 (library)
 *            \       \
 *             \       \
 *              \_ _ _ _4 (library)
 * 
 * There are 6 cities, so the total cost is 6 x 2 = 12.
 * 
 * @author Mariana Azevedo
 * @since 04/05/2020
 */
public class RoadsAndLibraries {
	
	private static final Logger logger = LoggerFactory.getLogger(RoadsAndLibraries.class);

	public static void main(String[] args) {
		
		int[][] cities1 = {{1,2},{3,1},{2,3}};
		logger.info(String.valueOf(roadsAndLibraries(3, 2, 1, cities1)));
		
		int[][] cities2 = {{1,3},{3,4},{2,4},{1,2},{2,3},{5,6}};
		logger.info(String.valueOf(roadsAndLibraries(6, 2, 5, cities2)));
		
		int[][] cities3 = {{1,2},{1,3},{4,5},{4,6}};
		logger.info(String.valueOf(roadsAndLibraries(6, 2, 3, cities3)));
		
		int[][] cities4 = {{1,2},{1,3},{1,4}};
		logger.info(String.valueOf(roadsAndLibraries(5, 6, 1, cities4)));
	}
	
	// Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
    	
    	if (c_lib < c_road) {
    		long cost = n;
            cost *= c_lib;
            return cost;
        }
    	
        City[] city = new City[n];
        
        for (int i = 0; i < n; i++) {
            city[i] = new City(i);
        }
        
        for (int i = 0; i < cities.length; i++) {
            int a = cities[i][0] - 1, b = cities[i][1] - 1;
            city[a].neighbors.add(b);
            city[b].neighbors.add(a);
        }
        
        int numLibs = 0;
        LinkedList<Integer> citiesList = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (city[i].visited == 0) {
                citiesList.add(i);
                numLibs++;
                city[i].visited = numLibs;
                while (!citiesList.isEmpty()) {
                    int currentLib = citiesList.poll();
                    updateCitiesVisited(city, numLibs, citiesList, currentLib);
                }
            }
        }
        
        return calculateMinCost(n, c_lib, c_road, numLibs);
    }

	private static void updateCitiesVisited(City[] city, int numLibs, LinkedList<Integer> citiesList, int currentLib) {
		for (int id : city[currentLib].neighbors) {
		    if (city[id].visited == 0) {
		        citiesList.add(id);
		        city[id].visited = numLibs;
		    }
		}
	}

	private static long calculateMinCost(int n, int c_lib, int c_road, int numLibs) {
		
		int libs = numLibs;
        long costLibs = libs;
        long costRoads = (n - libs);
        costLibs *= c_lib;
        costRoads *= c_road;
        
        return costLibs + costRoads;
	}

    static class City {

        List<Integer> neighbors;
        int id;
        int visited;

        public City(int id) {
            this.neighbors = new ArrayList<>();
            this.id = id;
            this.visited = 0;
        }
    }
}
