package erase;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Bootloader.UserLoader;
import decoder.FileDecoderEncoder;
import modules.Out;

public class Menu {

	public static void delete(File file)
	    	throws IOException{
	 
	    	if(file.isDirectory()){
	 
	    		//directory is empty, then delete it
	    		if(file.list().length==0){
	    			
	    		   file.delete();
	    			
	    		}else{
	    			
	    		   //list all the directory contents
	        	   String files[] = file.list();
	     
	        	   for (String temp : files) {
	        	      //construct the file structure
	        	      File fileDelete = new File(file, temp);
	        		 
	        	      //recursive delete
	        	     delete(fileDelete);
	        	   }
	        		
	        	   //check the directory again, if empty then delete it
	        	   if(file.list().length==0){
	           	     file.delete();
	        	   }
	    		}
	    		
	    	}else{
	    		//if file, then delete it
	    		file.delete();
	    	}
	    }
	
	
	public static void run() {
		Out.print("1 : Erase PloitBeta");
		Out.print("2 : Exit");
		Out.print("");
		Scanner sc = new Scanner(System.in);
		Out.printn("Option :");
		String option = sc.nextLine();
		if(option.equals("1")) {
			File d1 = new File("rootfs\\");
			File c1 = new File("config");
			try {
				delete(d1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c1.delete();
			System.out.println("All System files has been deletes!");
		}else if(option.equals("2")) {
			File config = new File("config");
			config.delete();
			try {
				config.createNewFile();
				PrintWriter wr = new PrintWriter(config);
                wr.println(FileDecoderEncoder.decode("username,"+UserLoader.username));
                wr.flush();
                wr.println(FileDecoderEncoder.decode("sysname,deskbeta"));
                wr.flush();
                wr.println(FileDecoderEncoder.decode("sysver,1.0"));
                wr.flush();
                wr.println(FileDecoderEncoder.decode("boot,normal"));
                wr.flush();
                wr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
	
}
