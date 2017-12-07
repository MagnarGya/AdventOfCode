package com.advent.Day7;

public class Program {
	String name;
	int weight;
	Program parent;
	Program[] children;
	
	Program(String name, int weight){
		this.name = name;
		this.weight = weight;
		this.parent = null;
		this.children = new Program[0];
	}
	
	Program(String name, Program parent) {
		this.name = name;
		this.weight = 0;
		this.parent = parent;
		this.children = new Program[0];
	}
	
	void addWeight(int weight) {
		this.weight = weight;
	}
	
	void addChild(Program addee) {
		Program[] newChildren = new Program[children.length+1];
		for(int i = 0; i < children.length; i++) {
			newChildren[i] = children[i];
		}
		newChildren[children.length] = addee;
		children = newChildren;
	}
	
	void addParent(Program parent) {
		this.parent = parent;
	}
	
	int checkWeight() {
		if(children.length==0) {
			return weight;
		}else {
			int[] weights = new int[children.length];
			for(int i = 0; i < weights.length; i++) {
				weights[i] = children[i].checkWeight();
			}
			for(int i = 1; i < weights.length; i++) {
				if(weights[i-1]!=weights[i]) {
					if(i==1&&weights[i]!=weights[i+1]) {
						return weights[i];
					}else {
						return weights[i-1];
					}
				}
			}
			return weight + (weights[0]*weights.length);
		}
	}
	
}
