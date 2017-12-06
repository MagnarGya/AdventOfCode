package com.advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	Scanner file;
	
	FileReader(String path){
		try {
			file = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	String getLine() {
		if(file.hasNextLine()) {
			return file.nextLine();
		}else {
			file.close();
			return "";
		}
	}
}
