package at.fhj.msd;

public class Exercise_8 {

      public int strStr(String haystack, String needle) {


            for (int i = 0; i < haystack.length(); i++)
            {
                  if (haystack.charAt(i) == needle.charAt(0))
                  {
                        if (needle_checker(haystack, needle, i)) return i;
                  }
            }

            return -1;


      
      }

      private boolean needle_checker(String haystack, String needle, int start)
      {

            int countdown = 0;
            while (countdown < needle.length()) { 
                
                  try {
                      if (!(haystack.charAt(start) == needle.charAt(countdown))) return false;
                  } catch (Exception e) {
                        return false;
                  }
                  
                  countdown++;
                  start++;
            }
            return true;
      }
}
