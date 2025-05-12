package at.fhj.msd;

import java.util.LinkedList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       
        Solution s = new Solution();
        LinkedList<Integer> i = new LinkedList<>();
        i.addFirst(9);
        i.addFirst(9);
        i.addFirst(9);
        i.addFirst(9);
        i.addFirst(9);
        i.addFirst(9);
        i.addFirst(9);
        
        
      
       

        LinkedList<Integer> c = new LinkedList<>();
          c.addFirst(9);
        c.addFirst(9);
        c.addFirst(9);
        c.addFirst(9);
       
        
        
        

        
         System.out.println(i);
        System.out.println(c);
        System.out.println(s.addTwoNumber(i, c));
        
    }
}
