package command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import Bootloader.UserLoader;
import decoder.FileDecoderEncoder;
import filesystem.FSLoader;
import modules.Out;
import modules.Prefix;

public class setboot {

	public static void run(String arg0) {
		String[] args = arg0.split(" ");
		if(args.length==2) {
			File config = new File("config");
			if(args[1].equals("menu")) {
				config.delete();
				try {
					config.createNewFile();
					PrintWriter wr = new PrintWriter(config);
	                wr.println(FileDecoderEncoder.decode("username,"+UserLoader.username));
	                wr.flush();
	                wr.println(FileDecoderEncoder.decode("sysname,deskbeta"));
	                wr.flush();
	                wr.println(FileDecoderEncoder.decode("sysver,1.0"));
	                wr.flush();
	                wr.println(FileDecoderEncoder.decode("boot,menu"));
	                wr.flush();
	                wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Out.print(Out.toPrefix(Prefix.desktop, "Set to Bootmenu"));
				
				Out.print(Out.toPrefix(Prefix.desktop, "Please restart!"));
				System.exit(0);
			}else if(args[1].equals("normal")) {
				config.delete();
				try {
					config.createNewFile();
					PrintWriter wr = new PrintWriter(config);
	                wr.println(FileDecoderEncoder.decode("username,"+UserLoader.username));
	                wr.flush();
	                wr.println(FileDecoderEncoder.decode("sysname,deskbeta"));
	                wr.flush();
	                wr.println(FileDecoderEncoder.decode("sysver,1.0"));
	                wr.flush();
	                wr.println(FileDecoderEncoder.decode("boot,normal"));
	                wr.flush();
	                wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Out.print(Out.toPrefix(Prefix.desktop, "Set to Normal Bootloader"));
		}else {
			Out.print(Out.toPrefix(Prefix.desktop, "Types:"));
			Out.print(Out.toPrefix(Prefix.desktop, "normal | normal bootloader"));
			Out.print(Out.toPrefix(Prefix.desktop, "menu   | menu bootloader"));
		}
	}else {
		Out.print(Out.toPrefix(Prefix.desktop, "setboot [type]"));
	}
	}
	
}
