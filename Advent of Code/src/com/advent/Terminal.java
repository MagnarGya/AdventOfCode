package com.advent;
import java.util.Scanner;

public class Terminal {
	static String[] choices = {"Day 1: Inverse Captcha","Day 2: Corruption Checksum"};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < choices.length; i++) {
			System.out.println(choices[i]);
		}
		
		System.out.println("Please enter the day you want run");
		int choice = input.nextInt();
		switch(choice) {
		case 1 : new InverseCaptcha().run();
		case 2 : new Checksum().run();
		}
	}

}
