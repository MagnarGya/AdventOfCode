package com.advent.Day9;

import com.advent.FileReader;

public class StreamAnalyser {
	public void run() {
		FileReader fr = new FileReader("input/Day9");
		String input = fr.getLine();
		Group g = new Group();
		g.content(input);
		System.out.println("Part 1: " + g.eval(0));
		System.out.println("Part 2: " + g.garbageValue());
	}
}
