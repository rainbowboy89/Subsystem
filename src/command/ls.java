package command;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import filesystem.FSLoader;

public class ls {

	public static void run() {
		try {
			listFilesUsingDirectoryStream("rootfs"+FSLoader.currdir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listFilesUsingDirectoryStream(String dir) throws IOException {
	    Set<String> fileList = new HashSet<>();
	    try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
	        for (Path path : stream) {
	            if (!Files.isDirectory(path)) {
	                System.out.println("File : "+path.getFileName().getFileName());
	            }else if(Files.isDirectory(path)) {
	            	System.out.println("Directory : "+path.getFileName().getFileName());
	            }
	        }
	    }
	}
	
}
