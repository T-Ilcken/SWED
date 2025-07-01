package fra.uas.swed.TI.ex4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Website implements Subject{
    private String url;
    private WebsiteChecker checker;
    private List<Observer> subscriptions = new ArrayList<Observer>();
    private Thread thread;

    public Website(String url) {
        this.url = url;
        this.checker = new WebsiteCheckerLength();
        thread = new Thread(() -> checkFrequency(10000));
        thread.start();
    }

    public String getURL(){
        return url;
    }


    @Override
    public void attach(Observer o) {
        subscriptions.add(o);
    }

    @Override
    public void detach(Observer o) {
        subscriptions.remove(o);
        if (subscriptions.isEmpty()) {
            thread.interrupt();
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : subscriptions) {
            o.update();
        }
    }

    public void checkFrequency( long frequency) {
        while(true) {
            try {
                checkWebsite(this);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void checkWebsite(Website website){
        String newContent = "";
        try {
            Document doc = Jsoup.connect(website.getURL()).get();
            if(checker.compareContent(doc)){
                notifyObservers();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}




