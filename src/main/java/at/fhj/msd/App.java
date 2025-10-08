package at.fhj.msd;

public class App {

    public static void main(String[] args) {
        Exercise16 exercise16 = new Exercise16();
        String[] strs = {"abcdef", "abc", "abcde"};
        System.out.println(exercise16.longestCommonPrefix(strs));
    }
}
