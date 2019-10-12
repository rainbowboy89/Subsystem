package modules;

import java.util.Scanner;

import command.CommandSearcher;
import filesystem.FSLoader;

public class In {

	public static void input() {
		Scanner sc = new Scanner(System.in);
		Out.printn(Out.toPrefix(Prefix.desktop, "=> "));
		String line = sc.nextLine();
		CommandSearcher.runAndSearch(line);
	}
	
}
