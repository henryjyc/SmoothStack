package FileIO;

import java.io.*;

public class AppendFile {
	File file;
	String content;
	public AppendFile(String[] args) {
		file = new File(args[0]);
		content = ""; //needed else will begin with a "null"
		for(int i = 1; i < args.length; i++) {
			content += args[i];
			content += " ";
		}
	}
	
	public void addContent() {//appends content to file
		try {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
				out.println(content);
				out.close();
				
		}catch (IOException e) {
			System.out.println("ERROR: UNABLE TO OPEN FILE");
		}
	}
}
