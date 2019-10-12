package command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import decoder.FileDecoderEncoder;
import filesystem.FSLoader;
import modules.Out;
import modules.Prefix;

public class readfile {

	public static void run(String arg0) {
		String[] args = arg0.split(" ");
		if(args.length == 2) {
			System.out.println("------------- File : "+args[1]+" : File -------------");
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(
						"rootfs/"+FSLoader.currdir+args[1]));
				String line = reader.readLine();
				while (line != null) {
					System.out.println(FileDecoderEncoder.encode(line));
					// read next line
					line = reader.readLine();
				}
				reader.close();
			System.out.println("------------- File : "+args[1]+" : File -------------");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			Out.print(Out.toPrefix(Prefix.desktop, "readfile [name]"));
		}
	}
	
}
