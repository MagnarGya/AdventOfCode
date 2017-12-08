package com.advent.Day8;

import java.util.HashMap;

import com.advent.FileReader;

public class RegisterMonitor {
	HashMap<String,Integer> Registers;
	public void run() {
		FileReader fr = new FileReader("input/Day8");
		Registers = new HashMap<String,Integer>();
		int highest2 = Integer.MIN_VALUE;
		while(fr.hasNext()) {
			String input = fr.getLine();
			String[] inputs = input.split(" ");
			
			if(inputs[5].contains("<=")) {
				int rv = retrieveRegister(inputs[4]);
				int val = Integer.parseInt(inputs[6]);
				if(rv <= val) {
					operation(inputs[0], inputs[1], inputs[2]);
				}
			}else if(inputs[5].contains("<")) {
				int rv = retrieveRegister(inputs[4]);
				int val = Integer.parseInt(inputs[6]);
				if(rv < val) {
					operation(inputs[0], inputs[1], inputs[2]);
				}
			}else if(inputs[5].contains("==")) {
				int rv = retrieveRegister(inputs[4]);
				int val = Integer.parseInt(inputs[6]);
				if(rv == val) {
					operation(inputs[0], inputs[1], inputs[2]);
				}
			}else if(inputs[5].contains(">=")) {
				int rv = retrieveRegister(inputs[4]);
				int val = Integer.parseInt(inputs[6]);
				if(rv >= val) {
					operation(inputs[0], inputs[1], inputs[2]);
				}
			}else if(inputs[5].contains("!=")) {
				int rv = retrieveRegister(inputs[4]);
				int val = Integer.parseInt(inputs[6]);
				if(rv != val) {
					operation(inputs[0], inputs[1], inputs[2]);
				}
			}else if(inputs[5].contains(">")) {
				int rv = retrieveRegister(inputs[4]);
				int val = Integer.parseInt(inputs[6]);
				if(rv > val) {
					operation(inputs[0], inputs[1], inputs[2]);
				}
			}else{
				System.out.println(input);
			}
			if(Registers.containsKey(inputs[0])) {
				if(Registers.get(inputs[0])>highest2) {
					highest2 = Registers.get(inputs[0]);
				}
			}
		}
		int highest1 = Integer.MIN_VALUE;
		for(int val : Registers.values()) {
			if(val>highest1) {
				highest1 = val;
			}
		}
		System.out.println("Part 1: "+highest1);
		System.out.println("Part 2: "+highest2);
		fr.close();
	}
	
	int retrieveRegister(String name) {
		if(Registers.containsKey(name)) {
			return Registers.get(name);
		}else {
			Registers.put(name, 0);
			return 0;
		}
	}
	
	void operation(String register, String op, String value) {
		int val = Integer.parseInt(value);
		if(op.contains("dec")) {
			val = -val;
		}
		if(Registers.containsKey(register)) {
			Registers.put(register, (Registers.get(register)+val));
		}else {
			Registers.put(register, val);
		}
	}
}
