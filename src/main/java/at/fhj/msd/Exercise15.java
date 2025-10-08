package at.fhj.msd;

/**
 * Exercise 15: Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative
 * positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde"
 * while "aec" is not).
 */
public class Exercise15 {

    /**
     * Checks if string s is a subsequence of string t.
     * Time complexity: O(n) where n is the length of string t
     * Space complexity: O(m) where m is the length of string s (due to StringBuilder)
     *
     * @param s the potential subsequence string
     * @param t the string to check against
     * @return true if s is a subsequence of t, false otherwise
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        StringBuilder sRemover = new StringBuilder(s);

        // Iterate through string t and remove matching characters from s
        while (i < t.length() && s.length() != 0) {
            // If current character in t matches first character in s, remove it from s
            if (s.charAt(0) == t.charAt(i)) {
                sRemover.deleteCharAt(0);
                s = sRemover.toString();
            }
            i++;
        }

        // If all characters in s were found in order, s.length() will be 0
        return s.length() == 0;
    }
}
