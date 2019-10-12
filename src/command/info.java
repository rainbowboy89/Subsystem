package command;

import java.net.InetAddress;
import java.net.UnknownHostException;

import Bootloader.Systemloader;
import modules.Out;
import modules.Prefix;
import network.LocalIP;

public class info {

	/*
	 * 
	 * Name : systeminfo
	 * Author : Hendrik
	 * Version : 1.0
	 * Command: systeminfo
	 * 
	 */
	
	public static void run() {
		Out.print(Out.toPrefix(Prefix.desktop, "---------------------System-Info----------------------"));
		Out.print(Out.toPrefix(Prefix.desktop, "System Name : "+Systemloader.systemname));
		Out.print(Out.toPrefix(Prefix.desktop, "System Version : "+Systemloader.systemversion));
		Out.print(Out.toPrefix(Prefix.desktop, "Device Name : "+LocalIP.getLocalName()));
		Out.print(Out.toPrefix(Prefix.desktop, "---------------------System-Info----------------------"));
	}
	
}
