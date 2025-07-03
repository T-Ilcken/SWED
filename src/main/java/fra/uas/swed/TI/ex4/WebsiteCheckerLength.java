package fra.uas.swed.TI.ex4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebsiteCheckerLength implements WebsiteChecker {

    public WebsiteCheckerLength() {

    }



    @Override
    public Boolean compareContent(Document content,Document newContent) {
        int newContentLength = newContent.html().length();
        int contentLength = content.html().length();
        Boolean r = true;
        if (newContentLength != contentLength) {
            r = false;
        }
        return r;
    }
}
