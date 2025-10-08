package at.fhj.msd;

import java.util.HashMap;

/**
 * Exercise 14: Roman to Integer Roman numerals are represented by seven
 * different symbols: I, V, X, L, C, D and M. Given a roman numeral, convert it
 * to an integer.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, there are six instances where subtraction is used: - I can be placed
 * before V (5) and X (10) to make 4 and 9 - X can be placed before L (50) and C
 * (100) to make 40 and 90 - C can be placed before D (500) and M (1000) to make
 * 400 and 900
 */
public class Exercise14 {

    /**
     * Converts a Roman numeral string to an integer. Time complexity: O(n)
     * where n is the length of the string Space complexity: O(1) - HashMap has
     * constant size (7 entries)
     *
     * @param s the Roman numeral string (valid, length 1-15)
     * @return the integer value of the Roman numeral
     */
    public int romanToInt(String s) {

        // Map Roman numeral characters to their integer values
        HashMap<Character, Integer> Symbol = new HashMap<>();
        int result = 0;
        Symbol.put('I', 1);
        Symbol.put('V', 5);
        Symbol.put('X', 10);
        Symbol.put('L', 50);
        Symbol.put('C', 100);
        Symbol.put('D', 500);
        Symbol.put('M', 1000);

        // Process each character in the Roman numeral string
        for (int i = 0; i < s.length(); i++) {

            // Check if current character should be subtracted (subtraction rule)
            // This happens when a smaller numeral appears before a larger one:
            // - I before V or X (4 or 9)
            // - X before L or C (40 or 90)
            // - C before D or M (400 or 900)
            if ((i < s.length() - 1) && ((s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
                    || (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
                    || (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')))) {
                // Subtract when smaller numeral comes before larger one
                result -= (int) (Symbol.get(s.charAt(i)));
            } else {
                // Add normally for all other cases
                result += (int) (Symbol.get(s.charAt(i)));
            }

        }

        return result;
    }
}

