package io.github.mariazevedo88.hc.prepkit.trees;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Greg has a tree of nodes containing integer data. He wants to insert a node with some non-zero integer 
 * value somewhere into the tree. His goal is to be able to cut two edges and have the values of each of 
 * the three new trees sum to the same amount. This is called a balanced forest. Being frugal, the data 
 * value he inserts should be minimal. Determine the minimal amount that a new node can have to allow 
 * creation of a balanced forest. If it's not possible to create a balanced forest, return -1.
 * 
 * For example, you are given node values c=[15,12,8,14,13] and edges=[[1,2],[1,3],[1,4],[4,5]]. It is the 
 * following tree:
 * 
 *        1,15 
 *      /   |  \
 *     /   3,8  \
 *    /          \
 *  2,12         4,14
 *                 |
 *                5,13
 * The blue node is root, the first number in a node is node number and the second is its value. Cuts can 
 * be made between nodes 1 and 3 and nodes 1 and 4 to have three trees with sums 27, 27 and 8. Adding a 
 * new node w of c[w]=19 to the third tree completes the solution.
 * 
 * Function Description
 * 
 * Complete the balancedForest function in the editor below. It must return an integer representing the minimum 
 * value of c[w] that can be added to allow creation of a balanced forest, or -1 if it is not possible.
 * 
 * balancedForest has the following parameter(s):
 * 
 * - c: an array of integers, the data values for each node
 * - edges: an array of 2 element arrays, the node pairs per edge
 * 
 * Input Format
 * 
 * The first line contains a single integer, q, the number of queries.
 * 
 * Each of the following q sets of lines is as follows:
 * 
 * - The first line contains an integer, n, the number of nodes in the tree.
 * - The second line contains n space-separated integers describing the respective values of c[1],c[2],...,c[n], 
 * where each c[i] denotes the value at node i.
 * - Each of the following n-1 lines contains two space-separated integers, x[j] and y[j], describing edge j 
 * connecting nodes x[j] and y[j].
 * 
 * Constraints
 * 
 * 1 <= q <= 5
 * 1 <= n <= 5 x 10^4
 * 1 <= c[i] <= 10^9
 * Each query forms a valid undirected tree.
 * 
 * Subtasks
 * 
 * For 30% of the maximum score:
 * 
 * 1 <= n <= 100
 * 1 <= c[i] <= 100
 * 
 * For 50% of the maximum score:
 * 
 * 1 <= n <= 2000
 * 1 <= c[i] <= 10^9
 * 
 * Output Format
 * 
 * For each query, return the minimum value of the integer c[w]. If no such value exists, return -1 instead.
 * 
 * Sample Input
 * 
 * 2
 * 5
 * 1 2 2 1 1
 * 1 2
 * 1 3
 * 3 5
 * 1 4
 * 3
 * 1 3 5
 * 1 3
 * 1 2
 * 
 * Sample Output
 * 
 * 2
 * -1
 * 
 * Explanation
 * 
 * We perform the following two queries:
 * 1. The tree initially looks like this:
 * 
 *         1,1
 *        / | \
 *       / 3,2 \
 *      /   |   \
 *    2,2   |   4,1
 *         5,1
 * 
 * Greg can add a new node w=6 with c[w]=2 and create a new edge connecting nodes 4 and 6. Then he cuts 
 * the edge connecting nodes 1 and 4 and the edge connecting nodes 1 and 3. We now have a three-tree 
 * balanced forest where each tree has a sum of 3.
 * 
 *         1,1 
 *        / | \
 *       / 3,2 \
 *      /   |   \
 *     2,2  |   4,1
 *         5,1   |
 *             w=6,2
 * 
 * In the second query, it's impossible to add a node in such a way that we can split the tree into a three-tree 
 * balanced forest so we return -1.
 * 
 * @author Mariana Azevedo
 * @since 10/05/2020
 */

class BalancedNode {

	int name;
    long weight;
    long subTreeWeight;
    BalancedNode parent;
    Set<BalancedNode> children;
    
    BalancedNode(int name, long weight){
        this.name = name;
        this.weight = weight;
        this.subTreeWeight = weight;
        children = new HashSet<>();
    }
    
    // sets n as a child of this
    void addNeighbor(BalancedNode n){
        this.children.add(n);
    }
   
    // removes n from the set of children
    boolean removeFromChildren(BalancedNode n){
        return this.children.remove(n);
    }
    
    int numChildren(){
        return this.children.size();
    }
}

public class BalancedForest {
	
	private static final Logger logger = LoggerFactory.getLogger(BalancedForest.class);

	/**
	 * Main method modified to avoid timeout on Test 4 and Test 5
	 * 
	 * public static void main(String[] args) throws IOException {
	 * 
	 *     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
	 *     StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
	 *     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
	 *     
	 *     int q = Integer.parseInt(st.nextToken());
	 *     for (int qItr = 0; qItr < q; qItr++) {
	 *     		int n = Integer.parseInt(bufferedReader.readLine())
	 *     
	 *     		int[] c = new int[n];
	 *     		String[] cItems = bufferedReader.readLine().split(" ");
	 *     		for (int i = 0; i < n; i++) {
	 *     			int cItem = Integer.parseInt(cItems[i]);
	 *     			c[i] = cItem;
	 *     		}
	 *     
	 *     		int[][] edges = new int[n - 1][2];
	 *     
	 *     		for (int i = 0; i < n - 1; i++) {
	 *     			String[] edgesRowItems = bufferedReader.readLine().split(" ");
	 *     			for (int j = 0; j < 2; j++) {
	 *     				int edgesItem = Integer.parseInt(edgesRowItems[j]);
	 *     				edges[i][j] = edgesItem;
	 *     			}
	 *     		}
	 *     
	 *     		long result = balancedForest(c, edges);
	 *     		bufferedWriter.write(String.valueOf(result));
	 *     		bufferedWriter.newLine();
	 *    }
	 *    
	 *    bufferedWriter.close();
	 *    bufferedReader.close();
	 * }
	 * 
	 * @author Mariana Azevedo
	 * @since 10/05/2020
	 * @param args
	 */
	public static void main(String[] args) {
		int[] c1 = {1,2,2,1,1};
		int[][] edges1 = {{1,2},{1,3},{3,5},{1,4}};
		logger.info(String.valueOf(balancedForest(c1, edges1)));
		
		int[] c2 = {1,3,5};
		int[][] edges2 = {{1,3},{1,2}};
		logger.info(String.valueOf(balancedForest(c2, edges2)));
		
		int[] c3 = {15,12,8,14,13};
		int[][] edges3 = {{1,2},{1,3},{1,4},{4,5}};
		logger.info(String.valueOf(balancedForest(c3, edges3)));
		
		int[] c4 = {12,10,8,12,14,12};
		int[][] edges4 = {{1,2},{1,3},{1,4},{2,5},{4,6}};
		logger.info(String.valueOf(balancedForest(c4, edges4)));
	}
	
	 // Complete the balancedForest function below.
    static long balancedForest(int[] c, int[][] edges) {
    	
    	BalancedNode[] nodes = new BalancedNode[c.length];
        for(int i = 0; i < c.length; i++){
            nodes[i] = new BalancedNode(i, (long)c[i]);
        }
        
        for(int j = 0; j < edges.length; j++){
            int vertice0 = edges[j][0] - 1;
            int vertice1 = edges[j][1] - 1;
            nodes[vertice0].addNeighbor(nodes[vertice1]);
            nodes[vertice1].addNeighbor(nodes[vertice0]);
        }
        
        BalancedNode root = nodes[0];
        long totalWeight = setSubTreeWeights(root);
        
        long minValue = tryBranches(root, root, totalWeight, totalWeight);
        if(minValue == totalWeight){
        	minValue = -1L;
        }

        return minValue;
    }
    
    static long setSubTreeWeights(BalancedNode root){
        
    	for(BalancedNode node : root.children){
            node.parent = root;
            node.removeFromChildren(root);
            long childrenSubWeight = setSubTreeWeights(node);
            root.subTreeWeight += childrenSubWeight;
        }
    	
        return root.subTreeWeight;
    }
    
    static long tryBranches(BalancedNode root, BalancedNode branch, long totalWeight, long minValue){
        
        // weight of the subtree rooted at branch
        long subWeight = branch.subTreeWeight;
        // weight of the subtree obtained by removing branch & its descendants from the tree
        long diffWeight = totalWeight - subWeight;
        
        if(subWeight == diffWeight){
            minValue = subWeight;
        } else{
        	BalancedNode smallRoot = branch;
            long smallWeight = subWeight;
            if (diffWeight < subWeight && diffWeight != 0L){
                smallRoot = root;
                smallWeight = diffWeight;
            }
            
            long bestWeight = 3*smallWeight - totalWeight;

            if(bestWeight >= 0 && bestWeight < minValue){
                // if the smaller subtree was rooted at branch, remove branch and its descendants
                // and then search for an edge in the resulting subtree
                if(smallRoot == branch){
                    branch.subTreeWeight = 0;
                    BalancedNode parent = branch.parent;
                    while(parent != null){
                    	parent.subTreeWeight -= subWeight;
                        parent = parent.parent;
                    }
                    
                    // search for the solution
                    if(findWeight(root, subWeight, diffWeight)){
                        minValue = bestWeight;
                    }
                    
                    // reset the tree weights we changed back to their original values.
                    branch.subTreeWeight = subWeight;
                    parent = branch.parent;
                    while(parent != null){
                    	parent.subTreeWeight += subWeight;
                        parent = parent.parent;
                    }   
                    
                }else{
                	// the smaller subtree was rooted at root, so check the subtree rooted at branch
                    if(findWeight(branch, diffWeight, subWeight)){
                        minValue = bestWeight;
                    }
                }  
            }
        }
        
        // recurse on children
        Iterator<BalancedNode> iterator = branch.children.iterator();
        while(iterator.hasNext()){
        	BalancedNode node = iterator.next();
            long bestWeight = tryBranches(root, node, totalWeight, minValue);
            if(bestWeight < minValue){
                minValue = bestWeight;
            }
        }

        return minValue;
    }
    
    static boolean findWeight(BalancedNode root, long weight, long totalWeight){
        boolean weightFound = false;
        long rootWeight = root.subTreeWeight;
        long remWeight = totalWeight - root.subTreeWeight;
        
        if(rootWeight == weight || remWeight == weight){
            return true;
        } else if (rootWeight > weight || remWeight < weight){
            Iterator<BalancedNode> childIter = root.children.iterator();
            while(childIter.hasNext() && !weightFound){
            	BalancedNode node = childIter.next();
                weightFound = weightFound || findWeight(node, weight, totalWeight);
            }
        } 
        
        return weightFound;
    }
}
