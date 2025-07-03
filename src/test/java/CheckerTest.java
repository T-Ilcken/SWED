import fra.uas.swed.TI.ex4.WebsiteChecker;
import fra.uas.swed.TI.ex4.WebsiteCheckerHTML;
import fra.uas.swed.TI.ex4.WebsiteCheckerLength;
import fra.uas.swed.TI.ex4.WebsiteCheckerText;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CheckerTest {

    // html comparison strategy
    @Test
    public void testContentEqualHTML() {
        WebsiteChecker checker = new WebsiteCheckerHTML();
        String doc1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        Document doc = Jsoup.parse(doc1);
        assertTrue(checker.compareContent(doc,doc));
    }

    @Test
    public void testHTMLChangedHTML() {
        WebsiteChecker checker = new WebsiteCheckerHTML();
        String html1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head><title id=\"hallo\"hallo>hallo</title></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        assertFalse(checker.compareContent(doc1,doc2));
    }

    @Test
    public void testTextChangedDifferentLengthHTML() {
        WebsiteChecker checker = new WebsiteCheckerHTML();
        String html1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head><title id=\"hallo\">hal</title></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        assertFalse(checker.compareContent(doc1,doc2));
    }

    @Test
    public void testTextChangedSameLengthHTML() {
        WebsiteChecker checker = new WebsiteCheckerHTML();
        String html1 = "<html><head><title id=\"hallo\">hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head><title id=\"hallo\">hallp</title></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        assertFalse(checker.compareContent(doc1,doc2));
    }

    //Length comparing strategy

    @Test
    public void testContentEqualLength() {
        WebsiteChecker checker = new WebsiteCheckerLength();
        String doc1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        Document doc = Jsoup.parse(doc1);
        assertTrue(checker.compareContent(doc,doc));
    }

    @Test
    public void testHTMLChangedLength() {
        WebsiteChecker checker = new WebsiteCheckerLength();
        String html1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head><title id=\"hallo\"hallo>hallo</title></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        assertFalse(checker.compareContent(doc1,doc2));
    }

    @Test
    public void testTextChangedDifferentLengthLength() {
        WebsiteChecker checker = new WebsiteCheckerLength();
        String html1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head><title id=\"hallo\">hal</title></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        assertFalse(checker.compareContent(doc1,doc2));
    }

    @Test
    public void testTextChangedSameLengthLength() {
        WebsiteChecker checker = new WebsiteCheckerLength();
        String html1 = "<html><head><title id=\"hallo\">hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head><title id=\"hallo\">hallp</title></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        assertTrue(checker.compareContent(doc1,doc2));
    }

    //Text comparing strategy
    @Test
    public void testContentEqualText() {
        WebsiteChecker checker = new WebsiteCheckerText();
        String doc1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        Document doc = Jsoup.parse(doc1);
        assertTrue(checker.compareContent(doc,doc));
    }

    @Test
    public void testHTMLChangedText() {
        WebsiteChecker checker = new WebsiteCheckerText();
        String html1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head><title id=\"hallo\">hallo</title></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        assertTrue(checker.compareContent(doc1,doc2));
    }

    @Test
    public void testTextChangedDifferentLengthText() {
        WebsiteChecker checker = new WebsiteCheckerText();
        String html1 = "<html><head><title>hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head><title id=\"hallo\">hal</title></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        assertFalse(checker.compareContent(doc1,doc2));
    }

    @Test
    public void testTextChangedSameLengthText() {
        WebsiteChecker checker = new WebsiteCheckerText();
        String html1 = "<html><head><title id=\"hallo\">hallo</title></head><body><p>hello</p></body></html>";
        String html2 = "<html><head><title id=\"hallo\">hallp</title></head><body><p>hello</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        Document doc2 = Jsoup.parse(html2);
        assertFalse(checker.compareContent(doc1,doc2));
    }
}
