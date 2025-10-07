package at.fhj.msd;

/**
 * Exercise 6: Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 * A palindrome is a string that reads the same backward as forward.
 */
public class Exercise_6 {
    /**
     * Finds the longest palindromic substring using dynamic programming.
     * Time complexity: O(n²)
     * Space complexity: O(n²)
     *
     * @param s input string
     * @return longest palindromic substring
     */
    public String longestPalindrome(String s) {
       int n = s.length();
       // Dynamic Programming approach: solve larger problems using smaller subproblems
       boolean[][] dp = new boolean[n][n];
       int[] ans = new int[] {0 ,0};

       // All single characters are palindromes
       for (int i = 0; i < n ; i++)
       {
            dp[i][i] = true;
       }

       // Check for two consecutive identical characters
       for (int i = 0; i < n - 1 ; i++)
       {
            if(s.charAt(i) == s.charAt(i+1))
            {
                  dp[i][i+1] = true;
                  ans[0] = i;
                  ans[1] = i + 1;
            }
       }


       // Check for palindromes of length 3 or greater
       for (int diff = 2; diff < n; diff++)
       {
            for (int i = 0; i < n - diff; i++)
            {
                  int j = i + diff;
                  // If outer characters match and inner substring is a palindrome
                  if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
                  {
                        dp[i][j] = true;
                        ans[0] = i;
                        ans[1] = j;
                  }
            }

       }


        return s.substring(ans[0], ans[1] + 1);
    }


}