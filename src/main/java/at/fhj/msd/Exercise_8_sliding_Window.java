package at.fhj.msd;

public class Exercise_8_sliding_Window {

      private String slinding_Window = "";

      public int strStr(String haystack, String needle) {


            for (int i=0; i < needle.length(); i++)
            {
                  slinding_Window += haystack.charAt(i);
                 
            }


            for (int i = 0; i < haystack.length(); i++)
            {
                  if (slinding_Window.equals(needle)) return i;
                  else{
                        try {
                            slinding_Window += haystack.charAt(i + needle.length());
                            slinding_Window = slinding_Window.substring(1);
                        } catch (Exception e) {
                              return -1;
                        }
                        

                        

                  }
            }
      
            return -1;
      }

}
