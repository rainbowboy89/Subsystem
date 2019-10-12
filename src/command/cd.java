package command;

import java.io.File;

import filesystem.FSLoader;
import modules.Out;
import modules.Prefix;

public class cd {

	public static void run(String cmd) {
		String[] args = cmd.split(" ");
		if(args.length == 2) {
			if(args[1].startsWith("/")) {
				String[] dr = args[1].split("/");
				StringBuilder bd = new StringBuilder();
				for(int i = 0;i <= dr.length-1;i++) {
					bd.append(dr[i]+"/");
				}
				File fs = new File("rootfs/"+bd.toString());
				if(fs.exists()) {
					FSLoader.currdir = ""+bd.toString();
				}else {
					Out.print(Out.toPrefix(Prefix.desktop, "Directory not found!"));
				}
			}else {
				String[] dr = cmd.split(" ");
				if(dr[1].startsWith(".")) {
					String[] dri = FSLoader.currdir.split("/");
					//
					if(dri.length > 1) {
						//System.out.println(dri[dri.length-2]);
						StringBuilder bd = new StringBuilder();
						for(int i = 0;i <= dri.length-2;i++) {
							bd.append(dri[i]+"/");
						}
						FSLoader.currdir = bd.toString();
					}else {
						Out.print(Out.toPrefix(Prefix.desktop, "You can not go back!"));
					}
				}else {
					File fs = new File("rootfs/"+FSLoader.currdir+dr[1]);
					if(fs.exists()) {
						FSLoader.backdir = FSLoader.currdir;
						FSLoader.currdir = FSLoader.currdir+dr[1]+"/";
					}else {
						Out.print(Out.toPrefix(Prefix.desktop, "Directory not found!"));
					}
				}
			}
		}else {
			Out.print(Out.toPrefix(Prefix.desktop, Out.toPrefix(Prefix.err, "cd [...]")));
		}
	}
	
}
