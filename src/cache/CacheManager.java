package cache;

import modules.Out;
import modules.Prefix;

import java.util.HashMap;

public class CacheManager {

    //  (Adress,Input) //

    public static HashMap<Integer,String> cache = new HashMap<>();

    public static void sendToCache(int adress,String bytes){
        cache.put(adress,bytes);
        Out.print(Out.toPrefix(Prefix.cache,"1 Item was cached"));
    }

    public static String getFromCache(int adress){
        String end = "";
        end = cache.get(adress);
        return end;
    }

}
