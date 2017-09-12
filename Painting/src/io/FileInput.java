package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInput {

	// The issue lies within the path variable. This is why nothing is really
	// working properly...
	private String path;

	// Sets the path in the class for other methods.
	public FileInput(String filePath) {
		path = filePath;
	}

	// A one stop shop for reading files, similar to FileOutput.writeFile();
	public static String[] readFile(String fileName) throws IOException {
		String filePath = fileName;
		String[] textData;

		FileInput input = new FileInput(filePath);

		textData = input.openFile(filePath);
		return textData;
	}

	// Method that returns the amount of lines in a given text file, stored in
	// 'path'
	@SuppressWarnings("unused")
	public int readLines() throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader bf = new BufferedReader(fr);

		String aLine;
		int numOfLines = 0;

		while ((aLine = bf.readLine()) != null) {
			numOfLines++;
		}

		bf.close();

		return numOfLines;
	}

	// Reads the file stored in 'path', and returns a string array for use.
	public String[] openFile(String path) throws IOException {

		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);

		FileReader fr1 = new FileReader(path);
		BufferedReader textReaderr = new BufferedReader(fr1);

		String aLine;
		int numOfLines = 0;

		while ((aLine = textReader.readLine()) != null) {
			numOfLines++;
		}

		String[] textData = new String[numOfLines];

		aLine = null;

		int i = 0;
		while ((aLine = textReaderr.readLine()) != null) {
			textData[i] = aLine;
			i++;
		}

		textReader.close();
		textReaderr.close();

		return textData;
	}

}
