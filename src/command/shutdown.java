package command;

import Bootloader.UserLoader;
import modules.Out;
import modules.Prefix;

public class shutdown {

	/*
	 * 
	 * Name : shutdown
	 * Author : hendrik
	 * Version : 1.0
	 * Command : shutdown
	 *  
	*/
	
	public static void run() {
		Out.print(Out.toPrefix(Prefix.desktop, "Goodbye "+UserLoader.getUsername()+"!"));
		System.exit(0);
	}
	
}
