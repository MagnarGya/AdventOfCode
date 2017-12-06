package com.advent;

public class Checksum {
	
	void run() {
		FileReader fr = new FileReader("input/Day2");
		
		
		int checksum1 = 0;
		int checksum2 = 0;
		while(fr.hasNext()) {
			String line = fr.getLine();
			String[] numbers = line.split("	");
			int highest = Integer.MIN_VALUE;
			int lowest = Integer.MAX_VALUE;
			for(int i = 0; i < numbers.length; i++) {
				int number = Integer.parseInt(numbers[i]);
				if(number>highest) {
					highest = number;
				}
				if(number<lowest) {
					lowest = number;
				}
			}
			checksum1 += (highest-lowest);
			
			for(int i = 0; i < numbers.length; i++) {
				for (int j = 0; j < numbers.length; j++){
					int first = Integer.parseInt(numbers[i]);
					int second = Integer.parseInt(numbers[j]);
					if(i!=j) {
						if(first%second==0) {
							checksum2 += first/second;
						}
					}
				}
			}
		}
		
		System.out.println("Part 1: "+checksum1);
		System.out.println("Part 2: "+checksum2);
	}
}
