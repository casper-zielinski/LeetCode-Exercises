package at.fhj.msd;

/**
 * Exercise 8: Find the Index of the First Occurrence in a String
 * Given two strings needle and haystack, return the index of the first occurrence
 * of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Exercise_8 {

      /**
       * Finds the first occurrence of needle in haystack using two-pointer approach.
       * Time complexity: O(n*m) where n is haystack length and m is needle length
       * Space complexity: O(1)
       *
       * @param haystack the string to search in
       * @param needle the string to search for
       * @return index of first occurrence, or -1 if not found
       */
      public int strStr(String haystack, String needle) {


            for (int i = 0; i < haystack.length(); i++)
            {
                  // Check if first character matches
                  if (haystack.charAt(i) == needle.charAt(0))
                  {
                        // Verify if entire needle matches starting from this position
                        if (needle_checker(haystack, needle, i)) return i;
                  }
            }

            return -1;



      }

      /**
       * Helper method to check if needle matches haystack starting at a given position.
       *
       * @param haystack the string to search in
       * @param needle the string to search for
       * @param start the starting position in haystack
       * @return true if needle matches at this position, false otherwise
       */
      private boolean needle_checker(String haystack, String needle, int start)
      {

            int countdown = 0;
            while (countdown < needle.length()) {

                  try {
                      // Check if characters match at each position
                      if (!(haystack.charAt(start) == needle.charAt(countdown))) return false;
                  } catch (Exception e) {
                        // Out of bounds - needle extends beyond haystack
                        return false;
                  }

                  countdown++;
                  start++;
            }
            return true;
      }
}
