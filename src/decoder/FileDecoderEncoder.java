package decoder;

import modules.Out;
import modules.Prefix;

import javax.print.DocFlavor;
import java.util.HashMap;

public class FileDecoderEncoder {
    public static String alpabet = "ABCDEFGIJKLMNOPQRSTUVWXYZäöü		ÄÖÜabcdefghijklmnopqrstuvwxyz1234	567890!\"§$%&/()=?´`*+~'#_-.:,abcdefghijklmnopqrstuvwxyz1234567890!\"§$%&/()=?´`*+~'ABCDEFGIJKLMNOPQRSTUVWXYZäöüÄÖÜ#_-.:,;<>|HEDabcdefghijklmnopqrstuvwxyz1234567890!\"§$%&/()=?´`*+~'ABCDEFGIJKLMNOPQRSTUVWXYZäöüÄÖÜ#_-.:,;<>|HED;<>|HED";
    public static String[] alphabet_array = alpabet.split("");
    public static HashMap<String, String> chars = new HashMap<>();
    public static HashMap<String, String> ochars = new HashMap<>();
    public static HashMap<String, String> bchars = new HashMap<>();

    public static void load(){
        Out.print(Out.toPrefix(Prefix.system,"Encoder loading"));
        //

        int loadin = 0;
        for(String chara : alphabet_array){
            chars.put("99"," ");
            ochars.put(" ","99");
            if(loadin > 9){

                chars.put(String.valueOf(loadin),chara);
                ochars.put(chara,String.valueOf(loadin));
                bchars.put(String.valueOf(loadin),chara);
                Out.print(Out.toPrefix(Prefix.decoder,"Put in: "+chara+" as "+String.valueOf(loadin)));
            }else{
                chars.put("0"+String.valueOf(loadin),chara);
                ochars.put(chara,String.valueOf(loadin));
                bchars.put("0"+String.valueOf(loadin),chara);
                Out.print(Out.toPrefix(Prefix.decoder,"Put in: "+chara+" as 0"+String.valueOf(loadin)));
            }
            loadin += 1;
        }

        //
    }

    public static String decode(String text){
        String ret = "";
        String text2 = ":"+text;
        if(text == null){
            ret = "";
        }else{
            String[] inChars = text2.split("");
            int h = 1;
            for(String curr : inChars){

                    if(h == 1){

                    }else {
                        ret += ochars.get(curr) + ",";
                    }
                    h++;

            }
        }
        return ret;
    }

    public static String encode(String text){
        String cached = "";
        boolean firstcached = false;
        String ret = "";
        if(text == null){
            ret = "";
        }else{
            String[] inChars = text.split(",");
            for(int i = 0;i <= inChars.length-1;i++){
                if(inChars[i].equals("99")){
                    ret += " ";
                }else{
                    ret += bchars.get(inChars[i]);
                }

            }
        }
        return ret;
    }
}
