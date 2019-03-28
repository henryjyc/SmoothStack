package FileIO;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class GetDir {

	public static void GetContents(String dirName, List<File> files) {
		File folder = new File(dirName);
		File[] contents = folder.listFiles();
		for(File file : contents) {
			if(file.isFile()) {
				files.add(file);
			}
			else if(file.isDirectory()) {
				GetContents(file.getAbsolutePath(), files);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directory = args[0];
		List<File> files = new ArrayList<File>();
		GetContents(directory, files);
		System.out.println("The files in this directory are...");
		for(File file : files) {
			System.out.print(file.getName() + " ");
		}
	}

}
