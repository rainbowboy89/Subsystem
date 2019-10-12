package command;

import java.util.ArrayList;
import java.util.List;

import modules.Out;
import modules.Prefix;

public class help {

	public static List<String> commands = new ArrayList<String>();
	
	public static void run() {
		Out.print(Out.toPrefix(Prefix.desktop, "-----------HELP-----------"));
		for(String str : commands) {
			Out.print(Out.toPrefix(Prefix.desktop, str));
		}
		Out.print(Out.toPrefix(Prefix.desktop, "-----------HELP-----------"));
	}
	
}
