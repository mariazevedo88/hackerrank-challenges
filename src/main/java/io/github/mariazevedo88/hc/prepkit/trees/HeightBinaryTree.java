package io.github.mariazevedo88.hc.prepkit.trees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The height of a binary tree is the number of edges between the tree's root and its furthest leaf. 
 * For example, the following binary tree is of height 2:
 * 
 *       4
 *     /   \
 *    2     6
 *   / \   / \
 *  1   3 5   7
 *  
 * Function Description
 *  
 * Complete the getHeight or height function in the editor. It must return the height of a binary 
 * tree as an integer.
 *  
 * getHeight or height has the following parameter(s):
 * - root: a reference to the root of a binary tree.
 *  
 * Note -The Height of binary tree with single node is taken as zero.
 *  
 * Input Format
 *  
 * The first line contains an integer n, the number of nodes in the tree.
 * Next line contains n space separated integer where ith integer denotes node[i].data.
 *  
 * Note: Node values are inserted into a binary search tree before a reference to the tree's root 
 * node is passed to your function. In a binary search tree, all nodes on the left branch of a node 
 * are less than the node value. All values on the right branch are greater than the node value.
 *  
 * Constraints
 *  
 * 1<=node.data[i]<=20
 * 1<=n<=20
 * 
 * Output Format
 * 
 * Your function should return a single integer denoting the height of the binary tree.
 * 
 * Sample Input
 *       3
 *     /   \
 *    2     5
 *   /     / \
 *  1     4   6
 *             \
 *              7
 * 
 * Sample Output
 * 3
 * 
 * Explanation
 * 
 * The longest root-to-leaf path is shown below:
 * 3-5-6-7
 * 
 * There are 4 nodes in this path that are connected by 3 edges, meaning our binary tree's height=3.
 * 
 * @author Mariana Azevedo
 * @since 02/01/2020
 */
public class HeightBinaryTree {
	
	private static final Logger logger = LoggerFactory.getLogger(HeightBinaryTree.class);

	public static void main(String[] args) {

		Node root = new Node(3);  
	    root.left = new Node(2);  
	    root.right = new Node(5); 
	    root.left.left = new Node(1);  
	    root.right.left = new Node(4);
	    root.right.right = new Node(6);
	    root.right.right.right = new Node(7);
	    
	    logger.info(String.valueOf(height(root)));
	}
	
	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
		
		if (root == null) return -1;
		return 1 + Math.max(height(root.left), height(root.right));
    }
}
