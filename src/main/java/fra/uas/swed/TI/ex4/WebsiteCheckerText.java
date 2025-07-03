package fra.uas.swed.TI.ex4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class WebsiteCheckerText implements WebsiteChecker {

    public WebsiteCheckerText() {

    }

    @Override
    public Boolean compareContent(Document content,Document newContent) {
        String text1 = content.text();
        String text2 = newContent.text();
        Boolean r = true;
        if (!text1.equals(text2)) {
            r = false;
        }
        return r;
    }
}
