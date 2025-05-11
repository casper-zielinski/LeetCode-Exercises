package at.fhj.msd;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       
        Solution s = new Solution();
        LinkedList<Integer> i = new LinkedList<>();
        i.addFirst(2);
        i.addLast(4);
        i.addLast(3);
        LinkedList<Integer> c = new LinkedList<>();
        c.add(5);
        c.add(6);
        c.add(4);

        System.out.println(i);
        System.out.println(s.addTwoNumber(i, c));
        
    }
}
