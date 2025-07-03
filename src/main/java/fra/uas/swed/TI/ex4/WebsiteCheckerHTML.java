package fra.uas.swed.TI.ex4;

import org.jsoup.nodes.Document;

public class WebsiteCheckerHTML implements WebsiteChecker {

    public WebsiteCheckerHTML() {

    }


    public Boolean compareContent(Document content,Document newContent){
        String html1 = content.html();
        String html2 = newContent.html();
        Boolean r = true;
        if (!html1.equals(html2)) {
            r= false;
        }
        return r;
    }


}
