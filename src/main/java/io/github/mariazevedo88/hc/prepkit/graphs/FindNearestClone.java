package io.github.mariazevedo88.hc.prepkit.graphs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * In this challenge, there is a connected undirected graph where each of the nodes is a color. Given a color, find the shortest path connecting 
 * any two nodes of that color. Each edge has a weight of 1. If there is not a pair or if the color is not found, print -1.
 * 
 * For example, given graph_nodes=5, and 4 edges g_form=[1,2,2,3] and g_to=[2,3,4,5] and colors for each node are arr=[1,2,3,1,2] we can draw the 
 * following graph:
 * 
 *              3/3 --- 5/3
 *             /
 * 1/1 ---- 2/2
 * 			   \
 *              4/1
 * 
 * Each of the nodes is labeled [node]/[color] and is colored appropriately. If we want the shortest path between color 3, blue, we see there is a 
 * direct path between nodes 3 and 5. For green, color 1, we see the path length 2 from 1 -> 2 -> 4. There is no pair for node 4 having color 2, red.
 * 
 * Function Description
 * 
 * Complete the findShortest function in the editor below. It should return an integer representing the length of the shortest path between two nodes 
 * of the same color, or -1 if it is not possible.
 * 
 * findShortest has the following parameter(s):
 * 
 * - g_nodes: an integer, the number of nodes
 * - g_from: an array of integers, the start nodes for each edge
 * - g_to: an array of integers, the end nodes for each edge
 * - ids: an array of integers, the color id per node
 * - val: an integer, the id of the color to match
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers n and m, the number of nodes and edges in the graph.
 * Each of the next m lines contains two space-separated integers g_from[i] and g_to[i], the nodes connected by an edge.
 * The next line contains n space-seperated integers, ids[i], representing the color id of each node from 1 to n.
 * The last line contains the id of the color to analyze.
 * 
 * Note: The nodes are indexed from 1 to n.
 * 
 * Constraints
 * 
 * 1 <= n <= 10^6
 * 1 <= m <= 10^6
 * 1<= ids[i] <= 10^8
 * 
 * Output Format
 * 
 * Print the single integer representing the smallest path length or -1.
 * 
 * Sample Input 0
 * 
 * 4 3
 * 1 2
 * 1 3
 * 4 2
 * 1 2 1 1 
 * 1
 * 
 * Sample Output 0
 * 
 * 1 
 * 
 * Explanation 0
 * 
 *     2/2 ----- 4/1
 *    /
 * 1/1
 *    \
 *     3/1 
 *     
 * In the above image the distance between the closest nodes having color label 1 is 1.
 * 
 * Sample Input 1
 * 
 * 4 3
 * 1 2
 * 1 3
 * 4 2
 * 1 2 3 4
 * 2
 * 
 * Sample Output 1
 * 
 * -1 
 * 
 * Explanation 1
 * 
 *     2/2 ----- 4/4 
 *    /
 * 1/1
 *    \
 *     3/3
 *     
 * Sample Input 2
 * 
 * 5 4
 * 1 2
 * 1 3
 * 2 4
 * 3 5
 * 1 2 3 3 2
 * 2
 * 
 * Sample Output 2
 * 
 * 3
 * 
 * Explanation 2
 * 
 *     2/2 ----- 4/3 
 *    /
 * 1/1
 *    \
 *     3/3 ----- 5/2
 * 
 * @author Mariana Azevedo
 * @since 03/05/2020
 */
public class FindNearestClone {
	
	private static final Logger logger = LoggerFactory.getLogger(FindNearestClone.class);
	
	private static List<Integer>[] edges;
	private static boolean[] visited;

	public static void main(String[] args) {
		
		int[] graphFrom1 = {1,1,4};
		int[] graphTo1 = {2,3,2};
		long[] ids1 = {1,2,1,1};
		logger.info(String.valueOf(findShortest(4, graphFrom1, graphTo1, ids1, 1)));
		
		int[] graphFrom2 = {1,1,4};
		int[] graphTo2 = {2,3,2};
		long[] ids2 = {1,2,3,4};
		logger.info(String.valueOf(findShortest(4, graphFrom2, graphTo2, ids2, 2)));
		
		int[] graphFrom3 = {1,1,2,3};
		int[] graphTo3 = {2,3,4,5};
		long[] ids3 = {1,2,3,3,2};
		logger.info(String.valueOf(findShortest(5, graphFrom3, graphTo3, ids3, 2)));

	}
	
	// Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    @SuppressWarnings("unchecked")
	static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {

        edges = new ArrayList[(graphNodes + 1)];
        edges[0] = new ArrayList<>();

        visited = new boolean[graphNodes + 1];

        //initialize all the array lists within the edges array and check to see if we
        //have at least 2 pairs
        int numColors = 0;
        for(int i = 1; i <= graphNodes; i++){
        	edges[i] = new ArrayList<>();
        	//this will check to see if we have a valid number of pairs
        	if(ids[i-1] == val){
        		numColors++;
        	}
        }

        //checks for the case that there aren't any possible pair combos
        if(numColors < 2){
        	return -1;
        }

        //add the adjacencies for our graph
        for(int i = 0; i < graphFrom.length; i++){
        	int node1 = graphFrom[i];
        	int node2 = graphTo[i];
        	edges[node1].add(node2);
        	edges[node2].add(node1);
        }     
        
        //initially, we set shortestPath to longest path possible, which is # of graphNodes
        int shortestPath = graphNodes;
        for(int i = 1; i < edges.length; i++){
        	long currentColor = ids[i - 1];
        	int currentPath = 0;

        	//if this node's color isn't the one we're looking for, skip it
        	if(currentColor != val){
        		continue;
        	}
          
        	//find the shortest path length for this node to another of a matching color
        	currentPath += findPathLength(i, val, ids);
        	shortestPath = Math.min(shortestPath, currentPath);
        }

        return shortestPath;
    }
    
    static int findPathLength(int currentNode, long color, long[] ids){
    	visited[currentNode] = true;
    	List<Integer> currentEdge = edges[currentNode];
    	int minPath = ids.length;

    	for(int i = 0; i < currentEdge.size(); i++){
    		int currentNeighbor = currentEdge.get(i);
    		int currentPath = 1;

    		//if this neighbor has already been visited, skip it
    		if(visited[currentNeighbor]){
    			continue;
    		}
        
    		//if this neighbor has the matching pair, then 1 is the shortest path
    		if(ids[currentNeighbor - 1] == color){
    			return currentPath;
    		}
        
    		//if this neighbor doesn't meet any of the if conditions, then we must recurse
    		currentPath += findPathLength(currentNeighbor, color, ids);
    		minPath = Math.min(minPath, currentPath);
      }
      
      return minPath;
    }

}
