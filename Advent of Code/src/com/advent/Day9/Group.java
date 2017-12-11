package com.advent.Day9;

public class Group extends StreamObject{
	StreamObject[] content;
	
	Group(){
		content = new StreamObject[0];
	}
	
	String content(String input) {
		if(input.length()>0) {
			if(input.charAt(0)=='}') {
				return input.substring(1);
			}else if(input.charAt(0)=='<') {
				Garbage g = new Garbage();
				addContent(g);
				return content(g.content(input.substring(1), "<"));
			}else if(input.charAt(0)==',') {
				return content(input.substring(1));
			}else if(input.charAt(0)=='{'){
				Group g = new Group();
				addContent(g);
				return content(g.content(input.substring(1)));
			}else {
				System.err.println("This character was parsed in the wrong place: " + input.charAt(0));
				return content(input.substring(1));
			}
		}else {
			return "";
		}
	}
	
	void addContent(StreamObject e) {
		StreamObject[] newContent = new StreamObject[content.length+1];
		for(int i = 0; i < content.length; i++) {
			newContent[i] = content[i];
		}
		newContent[content.length] = e;
		content = newContent;
	}
	
	public String toText() {
		String output = "{";
		for(int i = 0; i < content.length; i++) {
			output += content[i].toText();
		}
		output = output.substring(0, output.length()-1) + "}\n";
		return output;
	}
	
	public int eval(int multiplier) {
		int sum = 0;
		for(int i = 0; i < content.length; i++) {
			sum = sum + content[i].eval(multiplier+1);
		}
		return (sum + multiplier);
	}
	
	public int garbageValue() {
		int sum = 0;
		for(int i = 0; i < content.length; i++) {
			sum = sum + content[i].garbageValue();
		}
		return sum;
	}
}
