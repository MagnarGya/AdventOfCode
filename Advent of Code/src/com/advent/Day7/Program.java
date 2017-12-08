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
			int normal = weights[0];
			int index = 0;
			boolean LastWasEqual = true;
			boolean unEqual = false;
			for(int i = 1; i < weights.length+2; i++) {
				if(weights[i%weights.length]!=normal&&LastWasEqual) {
					LastWasEqual = false;
				}else if(weights[i%weights.length]!=normal&&!LastWasEqual) {
					normal = weights[i%weights.length];
					index = (i-1)%weights.length;
					unEqual = true;
				}
				
			}
			if(unEqual) {
				for(int i = 0; i < weights.length; i++) {
					System.out.println(weights[i]);
				}
				int difference = normal - weights[index];
				System.out.println("Part 2: " + (children[index].weight-difference) + " " + children[index+2].weight);
				return weight + (normal*weights.length);
			}else {
				return weight + (normal*weights.length);
			}
		}
	}
	
	
}
