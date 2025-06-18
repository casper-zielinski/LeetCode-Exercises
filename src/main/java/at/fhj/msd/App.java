package at.fhj.msd;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       
      Exercise_7 ex = new Exercise_7();
      int[] nums = new int[] {6};
      System.out.println(ex.removeElement( nums, 5));
      System.out.println(Arrays.toString(nums));

        
    }
}
