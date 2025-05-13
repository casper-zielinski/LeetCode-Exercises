package at.fhj.msd;

import java.util.LinkedList;

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
                int test = Integer.parseInt(part);
                ++count;
            }catch (NumberFormatException e) { //can also be any exception
                
            }
        }
      System.out.println(count);
    

      
      

      

      
        
    }
}
