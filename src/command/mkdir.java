package command;

import java.io.File;

import filesystem.FSLoader;
import modules.Out;
import modules.Prefix;

public class mkdir {

	public static void run(String args0) {
		try {
			String[] dr = args0.split(" ");
			if(dr.length == 2) {
				File f = new File("rootfs"+FSLoader.currdir+dr[1]+"/");
				f.mkdir();
				Out.print(Out.toPrefix(Prefix.desktop, "Directory was created!"));
			}else {
				Out.print(Out.toPrefix(Prefix.desktop, "mkdir [name]"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
