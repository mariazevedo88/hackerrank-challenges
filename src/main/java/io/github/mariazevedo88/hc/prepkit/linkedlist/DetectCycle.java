package io.github.mariazevedo88.hc.prepkit.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.mariazevedo88.hc.prepkit.linkedlist.model.Node;

/**
 * A linked list is said to contain a cycle if any node is visited more than once while traversing the list. 
 * For example, in the following graph there is a cycle formed when node 5 points back to node 3.
 * 
 * Function Description
 * 
 * Complete the function has_cycle in the editor below. It must return a boolean true if the graph contains 
 * a cycle, or false.
 * 
 * has_cycle has the following parameter(s):
 * 
 * head: a pointer to a Node object that points to the head of a linked list.
 * 
 * Note: If the list is empty, head will be null.
 * 
 * Input Format
 * 
 * There is no input for this challenge. A random linked list is generated at runtime and passed to your 
 * function.
 * 
 * Constraints
 * 
 * 0<=list size<=100
 * 
 * Output Format
 * 
 * If the list contains a cycle, your function must return true. If the list does not contain a cycle, it must 
 * return false. The binary integer corresponding to the boolean value returned by your function is printed to 
 * stdout by our hidden code checker.
 * 
 * Sample Input
 * 
 * The following linked lists are passed as arguments to your function:
 * 
 * 1 -> null
 * 1 -> 2 -> 3 -> 2 -> 3 [...]
 * 
 * Sample Output
 * 
 * 0
 * 1
 * 
 * Explanation
 * 
 * 1. The first list has no cycle, so we return false and the hidden code checker prints 0 to stdout.
 * 2. The second list has a cycle, so we return true and the hidden code checker prints 1 to stdout.
 * 
 * @author Mariana Azevedo
 * @since 09/12/2019
 */
public class DetectCycle {

	private static final Logger logger = LoggerFactory.getLogger(DetectCycle.class);
	
	public static void main(String[] args) {
		
		//Test first list - 1 -> null
		Node test = new Node(1);
		
		logger.info(String.valueOf(hasCycle(test)));
		
		//Test second list - 1 -> 2 -> 3 -> 2 -> 3 [...]
		Node head = new Node(1);
		Node next = new Node(2);
	    head.setNext(next);  
	    head.getNext().setNext(new Node(3));
	    head.getNext().getNext().setNext(next);
	    
	    logger.info(String.valueOf(hasCycle(head)));
	}
	
	/**
	 * Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
	 */
	static boolean hasCycle(Node head) {
		
		if(head == null) return false;
		
		//Using the concept of one pointer moving faster than another, since at some point both will meet 
		//at the same point and close a cycle (if any).
		Node slowPointerNode = head;
		Node fastPointerNode = head.getNext();
		
		while(fastPointerNode != null && fastPointerNode.getNext() != null) {
			if(slowPointerNode == fastPointerNode) {
				return true;
			}
			slowPointerNode = slowPointerNode.getNext();
			fastPointerNode = fastPointerNode.getNext().getNext();
		}
		
		return false;
	}
}
