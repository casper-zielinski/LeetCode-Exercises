import java.util.List;

public class Test {

    public static void main(String[] args) {
        Subject sub = new BroadCast();
        sub.attach(new UserObserver("Micheal"));

        sub.attach(new UserObserver("Mike"));

        sub.attach(new UserObserver("Walter"));

        sub.notifyObservers("News Broadcast!!!");


        User user1 = new User.Builder("Sam").build();
        User user2 = new User.Builder("Mia").gender("female").age(20).build();
        User user3 = new User.Builder("Walter").gender("male").age(12).adult(false).build();
        List<User> userList = List.of(user1, user2, user3);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
