package io.github.mariazevedo88.hc.prepkit.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Consider an undirected graph consisting of n nodes where each node is labeled from 1 to n and the edge between 
 * any two nodes is always of length 6. We define node s to be the starting position for a BFS. Given a graph, determine 
 * the distances from the start node to each of its descendants and return the list in node number order, ascending. 
 * If a node is disconnected, it's distance should be -1.
 * 
 * For example, there are n=6 nodes in the graph with a starting node s=1. The list of edges=[[1,2],[2,3],[3,4],[1,5]], 
 * and each has a weight of 6.
 * 
 *     2----3----4 
 *    /
 *   1----5 
 * start
 * 
 * Starting from node 1 and creating a list of distances, for nodes 2 through 6 we have distances=[6,12,18,6,-1].
 * 
 * Function Description
 * 
 * Define a Graph class with the required methods to return a list of distances.
 * 
 * Input Format
 * 
 * The first line contains an integer, q, the number of queries.
 * 
 * Each of the following q sets of lines is as follows:
 * - The first line contains two space-separated integers, n and m, the number of nodes and the number of edges.
 * - Each of the next m lines contains two space-separated integers, u and v, describing an edge connecting node u 
 * to node v.
 * The last line contains a single integer, s, the index of the starting node.
 * 
 * Constraints
 * 
 * 1 <= q <= 10
 * 2 <= n <= 1000
 * 1 <= m <= n(n-1)/2
 * 1 <= u,v,s <= n
 * 
 * Output Format
 * 
 * For each of the q queries, print a single line of n-1 space-separated integers denoting the shortest distances to 
 * each of the n-1 other nodes from starting position s. These distances should be listed sequentially by node number 
 * (i.e., 1, 2,..., n), but should not include node s. If some node is unreachable from s, print -1 as the distance to 
 * that node.
 * 
 * Sample Input
 * 
 * 2
 * 4 2
 * 1 2
 * 1 3
 * 1
 * 3 1
 * 2 3
 * 2
 * 
 * Sample Output
 * 6 6 -1
 * -1 6
 * 
 * Explanation
 * 
 * We perform the following two queries:
 * 
 * 1. The given graph can be represented as:
 * 
 *              1         4
 *            start
 *          /       \
 *         /         \
 *        2           3
 *        
 * where our start node, s, is node 1. The shortest distances from s to the other nodes are one edge to node 2, one edge 
 * to node 3, and there is no connection to node 4.
 * 
 * 2. The given graph can be represented as:
 * 
 *      1       2
 *            start
 *              |
 *              |6
 *              |
 *              3
 * where our start node, s, is node 1. There is only one edge here, so node 1 is unreachable from node 2 and node 3 has one 
 * edge connecting it to node 2. We then print node 2's distance to nodes 1 and 3 (respectively) as a single line of space-
 * separated integers: -1 6.
 * 
 * Note: Recall that the actual length of each edge is 6, and we print -1 as the distance to any node that's unreachable 
 * from s.
 * 
 * @author Mariana Azevedo
 * @since 10/05/2020
 */
public class BFSShortestReachGraph {
	
    List<HashSet<Integer>> adjMatrix;
    int size;
    
    BFSShortestReachGraph (int size) {
        
    	this.adjMatrix = new ArrayList<>(size+1);
        for (int i = 0; i <= size; i++) {
            adjMatrix.add(new HashSet<>());
        }
        
        this.size = size;
    }
    
    void addEdge(int edge, int vertice) {
        adjMatrix.get(edge).add(vertice);
        adjMatrix.get(vertice).add(edge);
    }
    
    void shortestReach(int startId) {
        
    	int[] distances = new int [size + 1];
        boolean[] visited = new boolean [size + 1];
        
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startId] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startId);
        
        while (!queue.isEmpty()) {
            
        	int currentNode = queue.poll();
            visited[currentNode] = true;
            
            for (int neighbor : adjMatrix.get(currentNode)) {
                distances[neighbor] = Math.min(distances[neighbor], distances[currentNode] + 1);
                if (!visited[neighbor])
                    queue.offer(neighbor);
            }
        }
        
        for (int i = 1; i < size+1; i++) {
            int distance = distances[i];
            if (distance != 0) {
                int result = 6 * distance;
                
                if (distance == Integer.MAX_VALUE) {
                    result = -1;
                }
                
                System.out.printf("%d ", result);
            }
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        
    	Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        
        while (q-- > 0) {
            int n = in.nextInt(); // each node has value between 1 and n (inclusive)
            int m = in.nextInt(); 
            
            BFSShortestReachGraph graph = new BFSShortestReachGraph(n);
            
            while (m-- > 0) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph.addEdge(u,v);
            }
            
            int s = in.nextInt();
            graph.shortestReach(s);
        }
        
        in.close();
    }
}
