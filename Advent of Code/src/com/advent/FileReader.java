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
	
	boolean hasNext() {
		return file.hasNext();
	}
	
	String getLine() {
		if(file.hasNextLine()) {
			return file.nextLine();
		}else {
			return "";
		}
	}
}
