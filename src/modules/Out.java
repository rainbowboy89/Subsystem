package modules;

import Bootloader.UserLoader;
import TimeDate.Date;
import filesystem.FSLoader;

public class Out {

    public static String toPrefix(Prefix args0, String args1){
        String ret = "[";
        if(args0 == Prefix.boot){
            ret += " Boot ]                 ";
        }else if(args0 == Prefix.system){
            ret += " System ]               ";
        }else if(args0 == Prefix.err) {
            ret += " Error ]                ";
        }else if(args0 == Prefix.desktop){
            ret += " "+ FSLoader.currdir +"  ]		";
        }else if(args0 == Prefix.decoder){
            ret += " Encoder & Decoder ]    ";
        }else if(args0 == Prefix.cache){
            ret += " Cache ]                ";
        }else if(args0 == Prefix.commandloader) {
        	ret += " CommandLoader ]		";
        }
        ret += args1;
        return ret;
    }

    public static void print(String args){

            System.out.println(args);

    }

    public static void printToDesktop(String args){

    }
    
    public static void printn(String args) {
		System.out.print(args);
	}

    public static void clearLines(int lines){
        for(int i= 0;i <= lines-1;i++){
            System.out.println("");
        }
    }


}
