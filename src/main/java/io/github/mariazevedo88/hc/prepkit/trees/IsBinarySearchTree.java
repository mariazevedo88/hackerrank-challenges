package io.github.mariazevedo88.hc.prepkit.trees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For the purposes of this challenge, we define a binary search tree to be a binary tree with the following properties:
 * 
 * - The data value of every node in a node's left subtree is less than the data value of that node.
 * - The data value of every node in a node's right subtree is greater than the data value of that node.
 * - The data value of every node is distinct.
 * 
 * For example, the image on the left below is a valid BST. The one on the right fails on several counts:
 * - All of the numbers on the right branch from the root are not larger than the root.
 * - All of the numbers on the right branch from node 5 are not larger than 5.
 * - All of the numbers on the left branch from node 5 are not smaller than 5.
 * - The data value 1 is repeated.
 * 
 *        3                    3
 *       / \                  / \
 *      2   4                2   5
 *     /   / \              /   / \ 
 *    1    5  6            1   6   1
 *    
 * Given the root node of a binary tree, determine if it is a binary search tree.
 * 
 * Function Description
 * 
 * Complete the function checkBST in the editor below. It must return a boolean denoting whether or not the binary tree is 
 * a binary search tree.
 * 
 * checkBST has the following parameter(s):
 * - root: a reference to the root node of a tree to test
 * 
 * Input Format
 * 
 * You are not responsible for reading any input from stdin. Hidden code stubs will assemble a binary tree and pass its root 
 * node to your function as an argument.
 * 
 * Constraints
 * 
 * 0 <= data <= 10^4
 * 
 * Output Format
 * 
 * Your function must return a boolean true if the tree is a binary search tree. Otherwise, it must return false.
 * 
 * Sample Input
 * 
 *         4
 *        / \
 *       /   \
 *      2     6 
 *     / \   / \
 *    1  3  5   7
 *    
 * Sample Output
 * 
 * Yes
 * 
 * Explanation
 * 
 * The tree in the diagram satisfies the ordering property for a Binary Search Tree, so we print Yes.
 * 
 * @author Mariana Azevedo
 * @since 08/05/2020
 */
public class IsBinarySearchTree {
	
	private static final Logger logger = LoggerFactory.getLogger(IsBinarySearchTree.class);

	public static void main(String[] args) {
		Node root = new Node(4);  
	    root.left = new Node(2);  
	    root.right = new Node(6); 
	    root.left.left = new Node(1);  
	    root.left.right = new Node(3);
	    root.right.left = new Node(5);
	    root.right.right = new Node(7);
	    
	    if(checkBST(root)) {
	    	logger.info("YES");
	    }else {
	    	logger.info("NO");
	    }
	}
	
	static boolean checkBST(Node root) {
		if (root == null)
            return true;
        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkBSTHelper(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        
        if (root.data < min || root.data > max) {
            return false;
        }
        return checkBSTHelper(root.left, min, root.data - 1) && checkBSTHelper(root.right, root.data + 1, max);
    }

}
