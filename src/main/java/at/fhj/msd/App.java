package at.fhj.msd;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] v = {3,3};
        int target = 6;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(v, target)));        
    }
}
