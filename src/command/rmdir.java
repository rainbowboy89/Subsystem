package command;

import java.io.File;
import java.util.Scanner;

import filesystem.FSLoader;
import modules.Out;
import modules.Prefix;

public class rmdir {

	public static void run(String args0) {
		String[] dr = args0.split(" ");
		if(dr.length == 2) {
			File dir = new File("rootfs"+FSLoader.currdir+dr[1]);
			if(dir.exists()) {
				if(FSLoader.forbidden_folders.contains(FSLoader.currdir+dr[1])) {
					Out.print(Out.toPrefix(Prefix.desktop, "This Folder can you not delete"));
				}else {
					Scanner in = new Scanner(System.in);
					Out.printn("Do you want to delete [Y/N]");
					String read = in.nextLine();
					if(read.equals("Y")) {
						dir.delete();
						Out.print(Out.toPrefix(Prefix.desktop, "Folder was deleted!"));
					}else {
						Out.print(Out.toPrefix(Prefix.desktop, "Folder was not deleted!"));
					}
					
				}
			}else {
				Out.print(Out.toPrefix(Prefix.desktop, "Folder does not exist!"));
			}
		}else {
			Out.print(Out.toPrefix(Prefix.desktop, "rmdir [name]"));
		}
		
	}
	
}
