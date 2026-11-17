import java.util.ArrayList;
import java.util.List;

public class BroadCast implements Subject {
    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        if (observer != null) observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        if (observer != null) observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }
}
