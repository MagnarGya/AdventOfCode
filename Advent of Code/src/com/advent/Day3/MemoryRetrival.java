package com.advent.Day3;

public class MemoryRetrival {
	int input = 347991;
	
	public void run() {
		int layers = 0;
		int highest = 0;
		for(int i = 0; highest > input; i++) {
			highest = 1 + (layers*8);
			layers = i;
		}
		System.out.println(layers);
	}
}
