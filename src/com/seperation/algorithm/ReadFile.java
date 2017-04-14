package com.seperation.algorithm;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * <H1>Readfile</H1>
 * 
 * ReadFile read txt file and stored result in 2d array
 * 
 * @author Shruti Gupta
 * @version 1.0
 * @since 28-November-2016
 * 
 */
public class ReadFile {
	static int x[];
	static int y[];
	public ReadFile(String filename) throws IOException {
		try {
			List<String> myFileLines = Files.readAllLines(Paths.get(filename));
			// Remove first Line
			myFileLines.remove(0);
			x = new int[myFileLines.size()];
			y= new int[myFileLines.size()];
			for (int i = 0; i < myFileLines.size(); i++) {
				// Split the line by spaces
				String[] splitLine = myFileLines.get(i).split("\\s");
				for (int j = 0; j < splitLine.length; j++) {
					// Convert each String element to an integer
					if(j==0)
						x[i] = Integer.parseInt(splitLine[j]);
					else
						y[i] = Integer.parseInt(splitLine[j]);
				}
			}
		} catch (FileNotFoundException error) {
			throw new FileNotFoundException();
		}
	}
}