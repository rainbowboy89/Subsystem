package Bootloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import decoder.FileDecoderEncoder;

public class Systemloader {

	public static String systemname = "";
	public static String systemversion = "";
	
	public static void load() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"config"));
			String line = reader.readLine();
			while (line != null) {
				String rline = FileDecoderEncoder.encode(line);
				if(rline.startsWith("sysname")) {
					String[] args = rline.split(",");
					systemname = args[1];
				}else if(rline.startsWith("sysver")) {
					String[] args = rline.split(",");
					systemversion = args[1];
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
