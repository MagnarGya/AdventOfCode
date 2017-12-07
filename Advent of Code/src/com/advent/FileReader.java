package com.advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	Scanner file;
	
	public FileReader(String path){
		try {
			file = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasNext() {
		return file.hasNext();
	}
	
	public String getLine() {
		if(file.hasNextLine()) {
			return file.nextLine();
		}else {
			return "";
		}
	}
	public void close() {
		file.close();
	}
}
