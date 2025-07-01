package fra.uas.swed.TI.ex4;

public interface Subject {
    public void attach(Observer o);

    public void detach(Observer o);

    public void notifyObservers();
}
