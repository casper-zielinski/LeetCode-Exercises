package at.fhj.msd;

public class Exercise_6 {
    public String longestPalindrome(String s) {
       int n = s.length();
       boolean[][] dp = new boolean[n][n]; //Dynamic Programming, Größere Probleme durch kleinere Teilprobleme lösen
       int[] ans = new int[] {0 ,0};

       /* Alle einmaligen Buchstaben */
       for (int i = 0; i < n ; i++)
       {
            dp[i][i] = true;
       }

       /*Alle zweimaligen Buchstaben die gleich sind */
       for (int i = 0; i < n - 1 ; i++)
       {
            if(s.charAt(i) == s.charAt(i+1))
            {
                  dp[i][i+1] = true;
                  ans[0] = i;
                  ans[1] = i + 1;
            }
       }


       /* String mit Länge 3 >= schauen, ob sie Palindrome sind */
       for (int diff = 2; diff < n; diff++)
       {
            for (int i = 0; i < n - diff; i++)
            {
                  int j = i + diff;
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