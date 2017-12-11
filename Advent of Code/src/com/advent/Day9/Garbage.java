package com.advent.Day9;

public class Garbage extends StreamObject{
	String characters;
	
	String content(String input, String chars) {
		if(input.charAt(0)=='>') {
			chars = chars + '>';
			input = input.substring(1);
			characters = chars;
			return input;
		}else if(input.charAt(0)=='!') {
			chars = chars + input.substring(0, 2);
			input = input.substring(2);
		}else {
			chars = chars + input.charAt(0);
			input = input.substring(1);
		}
		return content(input, chars);
		
	}
	
	public String toText() {
		return characters;
	}
	
	public int garbageValue() {
		int sum = 0;
		String content = characters.substring(1, characters.length()-1);
		for(int i = 0; i < content.length(); i++) {
			if(content.charAt(i)=='!') {
				i++;
			}else {
				sum++;
			}
		}
		return sum;
	}
}
