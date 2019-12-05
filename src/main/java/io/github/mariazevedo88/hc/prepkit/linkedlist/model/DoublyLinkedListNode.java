package io.github.mariazevedo88.hc.prepkit.linkedlist.model;

public class DoublyLinkedListNode {
	
	private int data;
	private DoublyLinkedListNode next;
	private DoublyLinkedListNode prev;
	
	public DoublyLinkedListNode(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}

	public DoublyLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode next) {
		this.next = next;
	}

	public DoublyLinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedListNode prev) {
		this.prev = prev;
	}

	public int getData() {
		return data;
	}

}
