package command;

import command.edit.edit;
import modules.Out;
import modules.Prefix;

public class CommandSearcher {

	public static void load() {
		help.commands.add(new String("help : Show this"));
		help.commands.add(new String("systeminfo : Shows the Info from the System"));
		help.commands.add(new String("shutdown : Shutdown the system"));
		help.commands.add(new String("cd : change directory"));
		help.commands.add(new String("ls : list directory"));
		help.commands.add(new String("mkdir : create directory"));
		help.commands.add(new String("rmdir : remove directory"));
		help.commands.add(new String("edit [name] : Edit or Create a File"));
		help.commands.add(new String("rm [name] : remove File"));
		help.commands.add(new String("readfile [name] : read file"));
		help.commands.add(new String("setboot [type] : normal(this),menu(bootloader)"));
	}
	
	public static void runAndSearch(String cmd) {
		boolean found = false;
		if(cmd.startsWith("shutdown")) {
			found = true;
			shutdown.run();
		}else if(cmd.startsWith("systeminfo")) {
			found = true;
			info.run();
		}else if(cmd.startsWith("help")) {
			found = true;
			help.run();
		}else if(cmd.startsWith("cd")) {
			found = true;
			cd.run(cmd);
		}else if(cmd.startsWith("ls")) {
			found = true;
			ls.run();
		}else if(cmd.startsWith("mkdir")) {
			found = true;
			mkdir.run(cmd);
		}else if(cmd.startsWith("rmdir")) {
			found = true;
			rmdir.run(cmd);
		}else if(cmd.startsWith("edit")) {
			found = true;
			edit.run(cmd);
		}else if(cmd.startsWith("rm")) {
			found = true;
			rm.run(cmd);
		}else if(cmd.startsWith("clear")) {
			found = true;
			clear.run();
		}else if(cmd.startsWith("readfile")) {
			found = true;
			readfile.run(cmd);
		}else if(cmd.startsWith("setboot")) {
			found = true;
			setboot.run(cmd);
		}
		if(!found) {
			Out.print(Out.toPrefix(Prefix.desktop, Out.toPrefix(Prefix.err, "Command not found : "+cmd)));
		}
	}
	
}
