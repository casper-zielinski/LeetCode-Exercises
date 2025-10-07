package at.fhj.msd;

/**
 * Exercise 10: Valid Palindrome
 * Given a string s, determine if it is a palindrome, considering only alphanumeric
 * characters and ignoring cases.
 */
class Exercise10 {

    private int pointer1;
    private int pointer2;

    /**
     * Checks if a string is a palindrome using two-pointer approach.
     * Only alphanumeric characters are considered, case-insensitive.
     * Time complexity: O(n)
     * Space complexity: O(n) due to string split
     *
     * @param s input string
     * @return true if palindrome, false otherwise
     */
    public boolean isPalindrome(String s) {
        String[] sArr = s.split("");
        pointer1 = 0;
        pointer2 = sArr.length - 1;

        while (pointer2 > pointer1) {
            // Skip non-alphanumeric characters from left
            if (!(sArr[pointer1].matches("[A-Za-z0-9]"))) {
                  pointer1++;
                  continue;
            }
            // Skip non-alphanumeric characters from right
            if (!(sArr[pointer2].matches("[A-Za-z0-9]"))) {
                  pointer2--;
                  continue;
            }
            // Compare characters (case-insensitive)
            if (!(sArr[pointer1].equalsIgnoreCase(sArr[pointer2]))) {
                return false;
            }
            pointer1++;
            pointer2--;
        }
        return true;
    }
}
