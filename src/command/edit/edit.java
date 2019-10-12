package command.edit;

import java.io.File;

import filesystem.FSLoader;
import modules.Out;
import modules.Prefix;

public class edit {

	public static void run(String arg) {
		String[] args = arg.split(" ");
		if(args.length==2) {
			File fs = new File("rootfs"+FSLoader.currdir+args[1]);
			if(fs.exists()) {
				editFrameExisting.main(args[1]);
			}else {
				editFrameNew.main(args[1]);
			}
		}else {
			Out.print(Out.toPrefix(Prefix.desktop, "edit [name]"));
		}
	}
	
}
