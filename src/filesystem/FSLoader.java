package filesystem;

import decoder.FileDecoderEncoder;
import modules.Out;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FSLoader {

    public static String currdir = "/";
    public static String backdir = "/";
    //root directory
    public static String rootfs = "rootfs\\";
    public static File rootdr = new File(rootfs);
    //config
    public static String config_path = "config";
    public static File config = new File(config_path);
    //fsystem
    public static String system = "sys";
    public static File system_folder = new File(rootfs+system);

    public static String usr = rootfs+"usr";
    public static File usr_folder = new File(usr);
    
    //save files
    public static List<String> forbidden_folders = new ArrayList<String>();
    
    
    
    public static void register() {
    	forbidden_folders.add("/sys");
    	forbidden_folders.add("/usr");
    }
    
    public static void checkFiles(){
        if(rootdr.exists()){

        }else{
            rootdr.mkdir();
            Out.clearLines(4);
            Scanner sc = new Scanner(System.in);
            System.out.println("New User");
            System.out.print("Username: ");
            String username = sc.nextLine();
            Out.clearLines(1);
            //
            //
            //
            try{
                config.createNewFile();
                PrintWriter wr = new PrintWriter(config);
                wr.println(FileDecoderEncoder.decode("username,"+username));
                wr.flush();
                wr.println(FileDecoderEncoder.decode("sysname,deskbeta"));
                wr.flush();
                wr.println(FileDecoderEncoder.decode("sysver,1.0"));
                wr.flush();
                wr.println(FileDecoderEncoder.decode("boot,normal"));
                wr.flush();
                wr.close();
                //FSystem
                system_folder.mkdir();
                usr_folder.mkdir();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
