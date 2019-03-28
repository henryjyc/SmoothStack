package FileIO;

import java.io.*;
import java.util.Scanner;

public class CharCounter {
	File file;
	
	public CharCounter(String[] args) {
		file = new File(args[0]);
	}
	
	public int countHowMany(char letter) {
		int count = 0;
		Scanner fileScan = null;
		String nextString;

		try {
			fileScan = new Scanner(file);
		}catch (IOException e) {
			System.out.println("ERROR: UNABLE TO OPEN FILE");
		}
		while(fileScan.hasNext()) {
			nextString = fileScan.next();
			for(int i = 0; i < nextString.length(); i++) {
				if(nextString.charAt(i)==letter)
					count++;
			}
		}
		return count;
	}
}
