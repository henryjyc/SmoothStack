package FileIO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void testGetDir(String[] args) {
		String directory = args[0];
		List<File> files = new ArrayList<File>();
		GetDir.GetContents(directory, files);
		System.out.println("The files in this directory are...");
		for(File file : files) {
			System.out.print(file.getName() + " ");
		}
		System.out.println();
	}
	
	public static void testAppendFile(String[] args) {
		AppendFile appender = new AppendFile(args);
		appender.addContent();
	}
	
	public static void testCharCounter(String[] args) {
		CharCounter counter = new CharCounter(args);
		char letter = 'o';
		int count = counter.countHowMany(letter);
		System.out.println("There are " + count + " " + letter + "\'s in the file.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testGetDir(args);
		//testAppendFile(args);
		testCharCounter(args);
	}

}
