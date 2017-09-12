package io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOutput {

	private String path;

	@SuppressWarnings("unused")
	private boolean appendToFile = false;

	// Both sets the path in the class for other methods.
	public FileOutput(String filePath) {
		path = filePath;
	}

	public FileOutput(String filePath, boolean appendBool) {
		path = filePath;
		appendToFile = appendBool;
	}

	// A method used for writing to a file from another class in hopefully one
	// line.
	public static void writeFile(String fileName, String text, boolean isNewFile) throws IOException {

		// If a new file is being created, it creates one with the file name in
		// the default directory.
		if (isNewFile) {
			File file = new File(fileName + ".txt");

			if (file.createNewFile()) {
				System.out.println("File created.");

				FileOutput data = new FileOutput(fileName + ".txt", true);
				data.writeToFile(text);
			} else
				System.err.println("Error creating file.");
		}

		// If the file exists already, it writes the given text to the file.
		if (!isNewFile) {
			FileOutput data = new FileOutput(fileName + ".txt", true);
			data.writeToFile(text);
		}
	}

	// Writes lines of text to a file, set earlier in variable 'path'.
	public void writeToFile(String textLine) throws IOException {
		String[] textData = FileInput.readFile(path);

		PrintWriter writer = new PrintWriter(path, "UTF-8");

		// I know, BufferedReader is a better way. But honestly, this is low on
		// my priority list.
		for (int i = 0; i < textData.length; i++) {
				writer.println(textData[i]);
		}

		// write the line already given by user.
		writer.println(textLine);
		writer.close();
	}

	// Used mainly for the beginning of the Game class, checking if a file
	// exists in a directory.
	public static boolean getFile(String filePath) {
		File file = new File(filePath);

		boolean exists = file.exists();

		return exists;
	}
}
