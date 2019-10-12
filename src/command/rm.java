package command;

import java.io.File;
import java.util.Scanner;

import filesystem.FSLoader;
import modules.Out;
import modules.Prefix;

public class rm {

	public static void run(String args0) {
		String[] dr = args0.split(" ");
		if(dr.length == 2) {
			File dir = new File("rootfs"+FSLoader.currdir+dr[1]);
			if(dir.exists()) {
					Scanner in = new Scanner(System.in);
					Out.printn("Do you want to delete [Y/N]");
					String read = in.nextLine();
					if(read.equals("Y")) {
						dir.delete();
						Out.print(Out.toPrefix(Prefix.desktop, "File was deleted!"));
					}else {
						Out.print(Out.toPrefix(Prefix.desktop, "File was not deleted!"));
					}
			}else {
				Out.print(Out.toPrefix(Prefix.desktop, "File does not exist!"));
			}
		}else {
			Out.print(Out.toPrefix(Prefix.desktop, "rm [name]"));
		}
		
	}
	
}
