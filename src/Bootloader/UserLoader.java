package Bootloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import decoder.FileDecoderEncoder;

public class UserLoader {

	public static String username = "";
	public static File config = new File("config");
	
	
	
	public static void load() {
		
		
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"config"));
			String line = reader.readLine();
			while (line != null) {
				String rline = FileDecoderEncoder.encode(line);
				if(rline.startsWith("username")) {
					String[] args = rline.split(",");
					username = args[1];
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUsername() {
		return username;
	}
	
}
