package fra.uas.swed.TI.ex4;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int userID;
    private List<Subscription> subscriptions = new ArrayList<Subscription>();

    public User(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public Subscription getSubscription(int index) {
        return subscriptions.get(index);
    }

    public void subscribe(String url){
        Subscription s = new Subscription(url);
        subscriptions.add(s);
        s.setUser(this);
    }

    public void CancelSubscription(Subscription s){
        subscriptions.remove(s);
        s.getWebsite().detach(s);
    }

    public void ChangeFrequency(Subscription s, long newFrequency){
        s.SetFrequency(newFrequency);
    }
    public void ChangeChannel(Subscription s, Channel newChannel){
        s.SetChannel(newChannel);
    }

}
