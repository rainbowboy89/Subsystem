package network;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class LocalIP {

	public static String getLocalIP() {
		String localip = null;
		try {
			 localip = InetAddress.getLocalHost().getHostAddress();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return localip;
	}
	
	public static String getLocalName() {
		String localip = null;
		try {
			 localip = InetAddress.getLocalHost().getHostName();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return localip;
	}
	
}
