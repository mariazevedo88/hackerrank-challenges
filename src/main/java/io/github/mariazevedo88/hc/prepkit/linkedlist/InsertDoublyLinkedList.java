package io.github.mariazevedo88.hc.prepkit.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.mariazevedo88.hc.prepkit.linkedlist.model.DoublyLinkedListNode;

/**
 * Given a reference to the head of a doubly-linked list and an integer, data, create a new DoublyLinkedListNode object having 
 * data value data and insert it into a sorted linked list while maintaining the sort.
 * 
 * Function Description
 * 
 * Complete the sortedInsert function in the editor below. It must return a reference to the head of your modified DoublyLinkedList.
 * 
 * sortedInsert has two parameters:
 * 
 * 1. head: A reference to the head of a doubly-linked list of DoublyLinkedListNode objects.
 * 2. data: An integer denoting the value of the data field for the DoublyLinkedListNode you must insert into the list.
 * 
 * Note: Recall that an empty list (i.e., where head=null) and a list with one element are sorted lists.
 * 
 * Input Format
 * 
 * The first line contains an integer t, the number of test cases.
 * 
 * Each of the test case is in the following format:
 * - The first line contains an integer , the number of elements in the linked list.
 * - Each of the next  lines contains an integer, the data for each node of the linked list.
 * - The last line contains an integer  which needs to be inserted into the sorted doubly-linked list.
 * 
 * Constraints
 * 
 * 1<=t<=10
 * 1<=n<=1000
 * 1<=DoublyLinkedListNode.data<=1000
 * 
 * Output Format
 * 
 * Do not print anything to stdout. Your method must return a reference to the head of the same list that was passed to it as 
 * a parameter.
 * 
 * The output is handled by the code in the editor and is as follows:
 * For each test case, print the elements of the sorted doubly-linked list separated by spaces on a new line.
 * 
 * Sample Input
 * 
 * 1
 * 4
 * 1
 * 3
 * 4
 * 10
 * 5
 * 
 * Sample Output
 * 
 * 1 3 4 5 10
 * 
 * Explanation
 * 
 * The initial doubly linked list is: 1<->3<->4<->10-> NULL.
 * The doubly linked list after insertion is: 1<->3<->4<->5<->10-> NULL.
 * 
 * @author Mariana Azevedo
 * @since 04/12/2019
 */
public class InsertDoublyLinkedList {
	
	private static final Logger logger = LoggerFactory.getLogger(InsertDoublyLinkedList.class);

	public static void main(String[] args) {
		DoublyLinkedListNode head = new DoublyLinkedListNode(1);  
	    head.setNext(new DoublyLinkedListNode(3));  
	    head.getNext().setNext(new DoublyLinkedListNode(4));
	    head.getNext().getNext().setNext(new DoublyLinkedListNode(10));
	    
	    logger.info(String.valueOf(sortedInsert(head, 5)));

	}
	
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

    	if(head == null) return head;
    	
    	DoublyLinkedListNode current = head;
    	DoublyLinkedListNode previous = null;
    	DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
    	
    	while (current != null && current.getData() < data) {
    	    previous = current;
    	    current = current.getNext();
    	}

    	if (previous == null) {
    	    head = newNode;
    	} else {
    	    // re-link previous node
    	    previous.setNext(newNode);
    	    newNode.setPrev(previous);
    	}

    	if (current != null) {
    	    // re-link next node
    	    current.setPrev(newNode);
    	    newNode.setNext(current);
    	}
    	
    	return head;
    }
}

