package com.advent.Day7;

import java.util.HashMap;
import com.advent.*;

public class MemoryTower {
	public void run() {
		FileReader fr = new FileReader("input/Day7");
		HashMap<String, Program> tower = new HashMap<String, Program>();
		
		while(fr.hasNext()) {
			String line = fr.getLine();
			Program current;
			String[] input = line.split(" ");
			String name = input[0];
			int weight = Integer.parseInt(input[1].substring(1, input[1].length()-1));
			if(tower.containsKey(name)) {
				tower.get(name).addWeight(weight);
				current = tower.get(name);
			}else {
				current = new Program(name, weight);
				tower.put(name, current);
			}
			
			if(input.length>2) {
				for(int i = 3; i < input.length; i++) {
					input[i] = input[i].replaceAll(",", "");
					String childName = input[i];
					if(tower.containsKey(childName)) {
						Program child = tower.get(childName);
						current.addChild(child);
						child.addParent(current);
					}else {
						Program child = new Program(childName, current);
						tower.put(childName, child);
						current.addChild(child);
					}
				}
			}
		}
		
		Program top=null;
		for(Program p : tower.values()) {
			if(p.parent==null) {
				top = p;
			}
		}
		System.out.println("Part 1: "+top.name);
		top.checkWeight();
		
	}
}
