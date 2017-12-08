package com.advent;

import com.advent.Day1.InverseCaptcha;
import com.advent.Day2.Checksum;
import com.advent.Day3.MemoryRetrival;
import com.advent.Day7.MemoryTower;
import com.advent.Day8.RegisterMonitor;

import java.util.Scanner;

public class Terminal {
	static String[] choices = {"Day 1: Inverse Captcha","Day 2: Corruption Checksum","Day 3: Spiral Memory",
			"Day 7: Recursive Circus","Day 8: I Heard You Like Registers"};
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
		case 3 : new MemoryRetrival().run();
		case 7 : new MemoryTower().run();
		case 8 : new RegisterMonitor().run();
		}
		input.close();
	}

}
