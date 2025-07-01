package fra.uas.swed.TI.ex4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Map<String,Website> websites = new HashMap<String,Website>();

    public static void AddWebsite(Subscription s, String url) {
        if(websites.containsKey(url)){
            Website website = websites.get(url);
            s.setWebsite(website);
            website.attach(s);
        }else{
            Website website = new Website(url);
            websites.put(url, website);
            s.setWebsite(website);
            website.attach(s);
        }
    }
}
