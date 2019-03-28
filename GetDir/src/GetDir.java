import java.io.File;
import java.util.List;

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
}
