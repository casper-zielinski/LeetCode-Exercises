public class User {
    private final String name;
    private final String gender;
    private final int age;
    private final boolean adult;

    private User(Builder builder) {
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
        this.adult = builder.adult;
    }

    @Override
    public String toString() {
        return String.format("User[name=%s, age=%d, gender=%s, is a adult=%b]",
                name, age, gender, adult);
    }

    public static class Builder {
        private final String name;
        private String gender = "Male";
        private int age = 18;
        private boolean adult = true;

        public Builder(String name) {
            if (name == null) {
                throw new IllegalArgumentException("Name is necessary field");
            }
            this.name = name;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder adult(boolean adult) {
            this.adult = adult;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

}
