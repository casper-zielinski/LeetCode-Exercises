
public class Test {

    public static void main(String[] args) {
        Subject sub = new BroadCast();
        sub.attach(new UserObserver("Micheal"));

        sub.attach(new UserObserver("Mike"));

        sub.attach(new UserObserver("Walter"));

        sub.notifyObservers("News Broadcast!!!");
    }
}
