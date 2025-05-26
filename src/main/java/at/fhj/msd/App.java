package at.fhj.msd;

import java.util.Arrays;

import static at.fhj.msd.Exercise_5.removeDuplicates;

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

      //System.out.println(count);
      int[] num = {0,0,1,1,1,2,2,3,3,4};
      System.out.println(removeDuplicates(num));
      System.out.println(Arrays.toString(num));
      
     
    

      
      

      

      
        
    }
}
