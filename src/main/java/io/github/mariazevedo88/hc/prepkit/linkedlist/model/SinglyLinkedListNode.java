package io.github.mariazevedo88.hc.prepkit.linkedlist.model;

public class SinglyLinkedListNode {

	int data;
    SinglyLinkedListNode next;
    
    public SinglyLinkedListNode(int data) {
    	this.data = data;
    }

	public int getData() {
		return data;
	}

	public SinglyLinkedListNode getNext() {
		return next;
	}
    
	@Override
    public String toString() {
    	return String.valueOf(data);
    }
}
