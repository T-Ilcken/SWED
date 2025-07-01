package fra.uas.swed.TI.ex4;

import org.jsoup.nodes.Document;

public class WebsiteCheckerHTML implements WebsiteChecker {
    private String content;

    public WebsiteCheckerHTML() {
        content = "";
    }


    public Boolean compareContent(Document doc){
        String newContent = doc.html();
        Boolean r = true;
        if (!newContent.equals(content)) {
            r= false;
        }
        content = newContent;
        return r;
    }


}
