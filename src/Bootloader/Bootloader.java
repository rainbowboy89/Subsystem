package Bootloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cache.CacheManager;
import command.CommandSearcher;
import console.Console;
import decoder.FileDecoderEncoder;
import erase.Menu;
import filesystem.FSLoader;
import filesystem.Loader;
import modules.Out;
import modules.Prefix;

public class Bootloader {

    public static boolean inBoot = true;

    public static String getboottype() {
    	String type = "normal";
    	BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"config"));
			String line = reader.readLine();
			while (line != null) {
				String rline = FileDecoderEncoder.encode(line);
				if(rline.startsWith("boot")) {
					String[] args = rline.split(",");
					if(args[1].equals("normal")) {
						type = "normal";
					}else if(args[1].equals("menu")) {
						type = "menu";
					}
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return type;
    }
    
    public static void main(String args[])
    {
        inBoot = true;
        Out.print(Out.toPrefix(Prefix.boot,"Starting up..."));
        Out.print(Out.toPrefix(Prefix.boot,"Checking Filesystem..."));
        Loader.load();
        Out.print(Out.toPrefix(Prefix.decoder,"Testing Encoder & Decoder System : "));
        String decode_and_encode_1_test = FileDecoderEncoder.decode("Encoder & Decoder works!");
        Out.print(Out.toPrefix(Prefix.decoder,"Decoded : "+decode_and_encode_1_test));
        Out.print(Out.toPrefix(Prefix.decoder,"Encoded : "+FileDecoderEncoder.encode(decode_and_encode_1_test)));
        Out.print(Out.toPrefix(Prefix.cache,"Testing Cache :"));
        Out.print(Out.toPrefix(Prefix.cache,"Send to Cache \"Testing\" to adress 9173"));
        CacheManager.sendToCache(9173,"Testing");
        Out.print(Out.toPrefix(Prefix.cache,"Get from Cache: \""+CacheManager.getFromCache(9173)+"\""));
        Out.print(Out.toPrefix(Prefix.system,"Loading Filesystem..."));
        FSLoader.checkFiles();
        FSLoader.register();
        //Boottypes
        UserLoader.load();
        String t = getboottype();
        if(t.equals("normal")) {
        	//normal
        	
            Systemloader.load();
            CommandSearcher.load();
            Out.print(Out.toPrefix(Prefix.boot,"Init has been Finished!"));
            inBoot = false;
            try {
    			TimeUnit.SECONDS.sleep(3);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            Out.clearLines(100);
            Out.print(Out.toPrefix(Prefix.desktop, "User loaded: "+UserLoader.getUsername()));
            Console.start();
        }else if(t.equals("menu")){
        	//bootmenu
        	Menu.run();
        }
        //
        
    }

}
