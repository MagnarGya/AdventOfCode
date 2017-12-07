package com.advent.Day1;

import com.advent.FileReader;

public class InverseCaptcha {
	
	
	public void run() {
		FileReader fr = new FileReader("input/Day1");
		String input = fr.getLine();
		
		int sum = 0;
		
		for(int i = 0; i < input.length(); i++) {
			int first = Integer.parseInt(""+input.charAt(i));
			int second = Integer.parseInt(""+(input.charAt((i+1)%input.length())));
			if(first==second) {
				sum+=second;
			}
		}
		System.out.println("Part 1: "+ sum);
		
		sum = 0;
		for(int i = 0; i < input.length();i++) {
			int first = Integer.parseInt(""+input.charAt(i));
			int second = Integer.parseInt(""+(input.charAt((i+(input.length()/2))%input.length())));
			if(first==second) {
				sum+= second;
			}
		}
		
		System.out.println("Part 2: "+sum);
		fr.close();
	}
}
