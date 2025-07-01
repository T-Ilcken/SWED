import fra.uas.swed.TI.ex4.WebsiteChecker;
import fra.uas.swed.TI.ex4.WebsiteCheckerHTML;
import fra.uas.swed.TI.ex4.WebsiteCheckerLength;
import fra.uas.swed.TI.ex4.WebsiteCheckerText;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class CheckerTest {

    @Test
    public void testContentEqualHTML() {
        WebsiteChecker checker = new WebsiteCheckerHTML();
        String doc1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        Document doc = Jsoup.parse(doc1);
        checker.compareContent(doc);
        assertEquals(checker.compareContent(doc),checker.compareContent(doc));
    }

    @Test
    public void testContentDifferentHTML() {
        WebsiteChecker checker = new WebsiteCheckerHTML();
        String html1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        checker.compareContent(doc1);
        assertNotEquals(checker.compareContent(doc1),checker.compareContent(doc2));
    }

    @Test
    public void testContentEqualLength() {
        WebsiteChecker checker = new WebsiteCheckerLength();
        String doc1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        Document doc = Jsoup.parse(doc1);
        checker.compareContent(doc);
        assertEquals(checker.compareContent(doc),checker.compareContent(doc));
    }

    @Test
    public void testContentDifferentLength() {
        WebsiteChecker checker = new WebsiteCheckerLength();
        String html1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        checker.compareContent(doc1);

        assertNotEquals(checker.compareContent(doc1),checker.compareContent(doc2));
    }

    @Test
    public void testContentEqualText() {
        WebsiteChecker checker = new WebsiteCheckerText();
        String doc1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        Document doc = Jsoup.parse(doc1);
        checker.compareContent(doc);
        assertEquals(checker.compareContent(doc),checker.compareContent(doc));
    }

    @Test
    public void testContentDifferentText() {
        WebsiteChecker checker = new WebsiteCheckerText();
        String html1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        checker.compareContent(doc1);
        assertNotEquals(checker.compareContent(doc1),checker.compareContent(doc2));
    }
}
