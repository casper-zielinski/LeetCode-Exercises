public class UserObserver implements Observer {
    private static int count;
    private String name;
    private final int id;

    public UserObserver(String name) {
        id = count++ + 1;
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.printf("User %s with id %d got message: %s \n", this.name, this.id, message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
