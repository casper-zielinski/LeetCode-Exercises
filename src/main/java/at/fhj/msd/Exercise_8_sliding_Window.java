package at.fhj.msd;

/**
 * Exercise 8 (Sliding Window Approach): Find the Index of the First Occurrence in a String
 * Alternative implementation using a sliding window technique.
 * This approach maintains a window of size equal to needle length and slides it across haystack.
 */
public class Exercise_8_sliding_Window {

      private StringBuilder slinding_Window = new StringBuilder("");

      /**
       * Finds the first occurrence of needle in haystack using sliding window technique.
       * Time complexity: O(n*m) where n is haystack length and m is needle length
       * (String operations like substring and concatenation add overhead)
       * Space complexity: O(m) for the window string
       *
       * @param haystack the string to search in
       * @param needle the string to search for
       * @return index of first occurrence, or -1 if not found
       */
      public int strStr(String haystack, String needle) {


            // Initialize the sliding window with first needle.length() characters
            for (int i=0; i < needle.length(); i++)
            {
                  slinding_Window.append(haystack.charAt(i));

            }


            // Slide the window through haystack
            for (int i = 0; i < haystack.length(); i++)
            {
                  // Check if current window matches needle
                  if (slinding_Window.toString().equals(needle)) return i;
                  else{
                        try {
                            // Add next character to window
                            slinding_Window.append(haystack.charAt(i + needle.length()));
                            // Remove first character from window
                            slinding_Window = new StringBuilder(slinding_Window.substring(1));
                        } catch (Exception e) {
                              // Reached end of haystack without finding needle
                              return -1;
                        }

                  }
            }
            return -1;
      }

}
