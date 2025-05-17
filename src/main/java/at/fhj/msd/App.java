package at.fhj.msd;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       
        Solution s = new Solution();
      
       
        
        
        

      String numberStr = "472ddasd5dadsasa45asd ";
      String[] parts = numberStr.split("");
      if (numberStr.contains("@"))
      {
        System.out.println("WOww");
      }

      //how to cound integers/natural numbers in a String/String Array
      int count = 0;
        for (String part : parts) {
            try {
                @SuppressWarnings("unused")
                int test = Integer.parseInt(part);
                ++count;
            }catch (NumberFormatException e) { //can also be any exceptiong
                
            }
        }

      System.out.println(count);
      int[] num1 = {-1,0};
      // int[] num2 = {3,4};
      // System.out.println(s.findMedianSortedArrays(num1, num2));
      // System.out.println(Arrays.toString(s.twoSumEfficient(num1, -8)));
      System.out.println(Arrays.toString(s.twoSumSorted(num1, -1)));
      System.out.println(s.longestPalindrome("bbaaa"));
    

      
      

      

      
        
    }
}
