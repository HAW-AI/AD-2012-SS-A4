package aufgabe1b;

import java.io.File;
import java.util.ArrayList;

public class Searcher {
	public static ArrayList<File> searchFile(String path, String needle, int depth) {
		ArrayList<File> result = new ArrayList<File>();
		File dir = new File(path);
		File[] files = dir.listFiles();
		for(File file : files)
			if (file.isFile()) {
				if (file.getName().contains(needle))
					result.add(file);
			} else if (depth > 0)
				result.addAll(searchFile(file.getAbsolutePath(), needle, depth - 1));
		return result;
	}
	
	public static ArrayList<File> searchFile(String path, String needle) {
		return searchFile(path, needle, 1);
	}
	
	public static void main(String[] args) {
		System.out.println(searchFile("C:\\FullHD", "R", 1));
	}
}
