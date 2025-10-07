package at.fhj.msd;

/**
 * Exercise 13: Merge Strings Alternately
 * Given two strings word1 and word2, merge them by adding letters in alternating order,
 * starting with word1. If a string is longer than the other, append the additional
 * letters onto the end of the merged string.
 */
public class Exercise13 {

    /**
     * Merges two strings alternately, character by character.
     *
     * @param word1 the first string
     * @param word2 the second string
     * @return the merged string with characters alternating from word1 and word2
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        // Find the maximum length between both strings to handle different lengths
        int max = Math.max(word1.length(), word2.length());
        int iterable = 0;

        // Iterate through both strings simultaneously
        while (iterable < max) {
            // Append character from word1 if available
            if (iterable < word1.length()) {
                merge.append(word1.charAt(iterable));
            }
            // Append character from word2 if available
            if (iterable < word2.length()) {
                merge.append(word2.charAt(iterable));
            }

            iterable++;
        }

        return merge.toString();
    }
}
