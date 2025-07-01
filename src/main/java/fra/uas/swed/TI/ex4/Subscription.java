package fra.uas.swed.TI.ex4;


import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Subscription implements Observer {
    private long frequency;
    private Channel channel;
    private Website website;
    private List<Notification> notifications = new ArrayList<Notification>();
    private User user;

    public Subscription(String url) {
        Database.AddWebsite(this,url);
        this.frequency = 10000L;
        this.channel = Channel.PUSH;
    }

    public Channel getChannel() {
        return channel;
    }
    public Website getWebsite() {
        return website;
    }
    public void SetChannel(Channel channel) {
        this.channel = channel;
    }
    public long getFrequency() {
        return frequency;
    }
    public void SetFrequency(long frequency) {
        this.frequency = frequency;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setWebsite(Website website) {
        this.website = website;
    }

    @Override
    public void update() {
        String msg = "Notification via " + channel + ": Website " + website.getURL() + " changed!";
        Notification notification = new Notification(notifications.size() + 1, msg);
        if(!notifications.isEmpty()) {
            if(Duration.between(notifications.getLast().getTimestamp(), Instant.now()).toMillis() > frequency) {
                notifications.add(notification);
                notification.PrintNotification();
            }
        } else{
            notifications.add(notification);
            notification.PrintNotification();
        }
    }
}