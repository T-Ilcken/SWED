package fra.uas.swed.TI.ex4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebsiteCheckerText implements WebsiteChecker {
    private String content;

    public WebsiteCheckerText() {
        content = "";
    }

    @Override
    public Boolean compareContent(Document doc) {
        String newContent = doc.text();
        Boolean r = true;
        if (!newContent.equals(content)) {
            r= false;
        }
        content = newContent;
        return r;
    }
}
