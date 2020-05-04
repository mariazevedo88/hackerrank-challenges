package io.github.mariazevedo88.hc.prepkit.trees.model;

public class HuffNode {

	public int frequency; // the frequency of this tree
	public char data;
	public HuffNode left, right;
	
	public HuffNode() {}
	
	public HuffNode(int frequency) {
		this.frequency = frequency;
	}
	
	public HuffNode(char data, int frequency) {
		this.data = data;
		this.frequency = frequency;
	}
}
