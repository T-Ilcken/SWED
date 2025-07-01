package fra.uas.swed.TI.ex4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebsiteCheckerLength implements WebsiteChecker {
    private int contentLength;

    public WebsiteCheckerLength() {
        contentLength = 0;
    }



    @Override
    public Boolean compareContent(Document doc) {
        int newContent = doc.html().length();
        Boolean r = true;
        if (newContent != contentLength) {
            r = false;
        }
        contentLength = newContent;
        return r;
    }
}
