package io.github.mariazevedo88.hc.prepkit.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.mariazevedo88.hc.prepkit.linkedlist.model.DoublyLinkedListNode;

/**
 * You're given the pointer to the head node of a doubly linked list. Reverse the order of the nodes in the list. 
 * The head node might be NULL to indicate that the list is empty. Change the next and prev pointers of all the 
 * nodes so that the direction of the list is reversed. Return a reference to the head node of the reversed list.
 * 
 * Function Description
 * 
 * Complete the reverse function in the editor below. It should return a reference to the head of your reversed 
 * list.
 * 
 * reverse has the following parameter(s):
 * - head: a reference to the head of a DoublyLinkedList
 * 
 * Input Format
 * 
 * The first line contains an integer t, the number of test cases.
 * Each test case is of the following format:
 * 
 * - The first line contains an integer , the number of elements in the linked list.
 * - The next  lines contain an integer each denoting an element of the linked list.
 * 
 * Constraints
 * 
 * 1<=t<=10
 * 0<=n<=1000
 * 0<=DoublyLinkedListNode.data<=1000
 * 
 * Output Format
 * 
 * Return a reference to the head of your reversed list. The provided code will print the reverse array as a one 
 * line of space-separated integers for each test case.
 * 
 * Sample Input
 * 
 * 1
 * 4
 * 1
 * 2
 * 3
 * 4
 * 
 * Sample Output
 * 
 * 4 3 2 1 
 * 
 * Explanation
 * 
 * The initial doubly linked list is: 1<->2<->3<->4->NULL
 * The reversed doubly linked list is: 4<->3<->2<->1->NULL 
 * 
 * @author Mariana Azevedo
 * @since 03/12/2019
 */
public class ReverseDoublyLinkedList {

	private static final Logger logger = LoggerFactory.getLogger(ReverseDoublyLinkedList.class);
	
	public static void main(String[] args) {

		DoublyLinkedListNode head = new DoublyLinkedListNode(1);  
	    head.setNext(new DoublyLinkedListNode(2));  
	    head.getNext().setNext(new DoublyLinkedListNode(3));
	    head.getNext().getNext().setNext(new DoublyLinkedListNode(4));
	    
	    logger.info(String.valueOf(reverse(head)));
	}
	
	// Complete the reverse function below.
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    	
    	if(head == null) return head;
    	
    	DoublyLinkedListNode currentNode = head;
    	DoublyLinkedListNode newHead = head;
    	
    	while (currentNode != null) {
    		DoublyLinkedListNode prev = currentNode.getPrev();
    		currentNode.setPrev(currentNode.getNext());
    		currentNode.setNext(prev);
    		newHead = currentNode;
    		
    		//Because we are reversing the list
    		currentNode = currentNode.getPrev();
		}
    	
    	return newHead;
    }
}

