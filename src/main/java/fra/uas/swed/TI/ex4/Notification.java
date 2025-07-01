package fra.uas.swed.TI.ex4;

import java.time.Instant;

public class Notification {
    private int notificationID;
    private String message;
    private Instant timestamp;

    public Notification(int notificationID, String message) {
        this.notificationID = notificationID;
        this.message = message;
        this.timestamp = Instant.now();
    }
    public Instant getTimestamp() {
        return timestamp;
    }

    public void PrintNotification() {
        System.out.println(message);
    }

}
