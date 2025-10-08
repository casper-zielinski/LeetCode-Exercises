package at.fhj.msd;

/**
 * Exercise 16: Longest Common Prefix
 *
 * Problem:
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * - 1 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs[i] consists of only lowercase English letters.
 */
public class Exercise16 {

    /**
     * Finds the longest common prefix among an array of strings.
     *
     * Algorithm:
     * 1. Start with the first string as the initial prefix candidate
     * 2. Compare this prefix with each string in the array
     * 3. For each string, check character by character
     * 4. If a mismatch is found or the string is shorter than the prefix,
     *    truncate the prefix to the matching portion
     * 5. Use exception handling to catch IndexOutOfBoundsException when
     *    the current string is shorter than the prefix
     * 6. Return the final prefix after checking all strings
     *
     * Time Complexity: O(S) where S is the sum of all characters in all strings
     * Space Complexity: O(1) - only uses a constant amount of extra space
     *
     * @param strs array of strings to find common prefix from
     * @return the longest common prefix, or empty string if none exists
     */
    public String longestCommonPrefix(String[] strs) {
        // Start with the first string as the prefix candidate
        String word = strs[0];

        // Compare with each string in the array
        for (String s : strs) {
            int i = 0;

            // If any string is empty, there can be no common prefix
            if (s.isEmpty()) {
                return "";
            }

            // Check each character of the current prefix
            while (i < word.length()) {
                try {
                    // If characters don't match, truncate the prefix
                    if (word.charAt(i) != s.charAt(i)) {
                        word = word.substring(0, i);
                    }
                } catch (Exception e) {
                    // If current string is shorter than prefix, truncate to its length
                    word = word.substring(0, i);
                }

                i++;
            }
        }
        return word;
    }
}
