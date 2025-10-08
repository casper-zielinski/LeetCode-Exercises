package at.fhj.msd;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;

import at.fhj.msd.Exercise15;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    Exercise16 exercise16 = new Exercise16();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    // Example Cases
    @Test
    void test1_exampleFlower() {
        String[] strs = {"flower", "flow", "flight"};
        assertEquals("fl", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test2_exampleNoCommon() {
        String[] strs = {"dog", "racecar", "car"};
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    // Edge Cases - Single Element
    @Test
    void test3_singleString() {
        String[] strs = {"alone"};
        assertEquals("alone", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test4_singleEmptyString() {
        String[] strs = {""};
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    // Edge Cases - Empty Strings
    @Test
    void test5_allEmptyStrings() {
        String[] strs = {"", "", ""};
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test6_oneEmptyStringInArray() {
        String[] strs = {"flower", "", "flight"};
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test7_emptyStringAtEnd() {
        String[] strs = {"flower", "flow", ""};
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    // All Identical
    @Test
    void test8_allIdenticalStrings() {
        String[] strs = {"test", "test", "test"};
        assertEquals("test", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test9_allIdenticalSingleChar() {
        String[] strs = {"a", "a", "a", "a"};
        assertEquals("a", exercise16.longestCommonPrefix(strs));
    }

    // Prefix is One of the Strings
    @Test
    void test10_prefixIsFirstString() {
        String[] strs = {"a", "abc", "abcd"};
        assertEquals("a", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test11_prefixIsShortestString() {
        String[] strs = {"abcdef", "abc", "abcde"};
        assertEquals("abc", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test12_oneStringIsPrefix() {
        String[] strs = {"interspecies", "interstellar", "interstate"};
        assertEquals("inters", exercise16.longestCommonPrefix(strs));
    }

    // Single Character Differences
    @Test
    void test13_differAtFirstChar() {
        String[] strs = {"apple", "banana", "cherry"};
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test14_differAtSecondChar() {
        String[] strs = {"aa", "ab", "ac"};
        assertEquals("a", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test15_singleCharCommon() {
        String[] strs = {"a", "ab", "abc"};
        assertEquals("a", exercise16.longestCommonPrefix(strs));
    }

    // Long Prefixes
    @Test
    void test16_longCommonPrefix() {
        String[] strs = {"programming", "programmer", "program"};
        assertEquals("program", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test17_veryLongPrefix() {
        String[] strs = {
            "abcdefghijklmnopqrstuvwxyz",
            "abcdefghijklmnopqrstuvwxyzabc",
            "abcdefghijklmnopqrstuvwxyzdef"
        };
        assertEquals("abcdefghijklmnopqrstuvwxyz", exercise16.longestCommonPrefix(strs));
    }

    // Two Strings Only
    @Test
    void test18_twoIdentical() {
        String[] strs = {"hello", "hello"};
        assertEquals("hello", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test19_twoCompletelyDifferent() {
        String[] strs = {"abc", "xyz"};
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test20_twoWithPartialMatch() {
        String[] strs = {"flower", "flow"};
        assertEquals("flow", exercise16.longestCommonPrefix(strs));
    }

    // Varying Lengths
    @Test
    void test21_varyingLengthsCommonPrefix() {
        String[] strs = {"c", "cc", "ccc", "cccc"};
        assertEquals("c", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test22_shortAndLongStrings() {
        String[] strs = {"a", "aaaaaaaaaaaaaaaaaaaaa"};
        assertEquals("a", exercise16.longestCommonPrefix(strs));
    }

    // Almost Matching
    @Test
    void test23_almostFullMatch() {
        String[] strs = {"test", "testing", "tester"};
        assertEquals("test", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test24_differOnlyAtEnd() {
        String[] strs = {"abcd", "abce", "abcf"};
        assertEquals("abc", exercise16.longestCommonPrefix(strs));
    }

    // Special Patterns
    @Test
    void test25_repeatingPattern() {
        String[] strs = {"aaaa", "aaab", "aaac"};
        assertEquals("aaa", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test26_noCommonButSameLength() {
        String[] strs = {"abc", "def", "ghi"};
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    // Large Array
    @Test
    void test27_manyStringsWithCommon() {
        String[] strs = new String[100];
        for (int i = 0; i < 100; i++) {
            strs[i] = "prefix" + i;
        }
        assertEquals("prefix", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test28_manyStringsNoCommon() {
        String[] strs = new String[100];
        for (int i = 0; i < 100; i++) {
            strs[i] = String.valueOf((char) ('a' + i % 26));
        }
        // First string is "a", 27th string is "a" again, but 2nd is "b"
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    // Performance Cases
    @Test
    void test29_longStringsLongPrefix() {
        String base = "a".repeat(150);
        String[] strs = {
            base + "x",
            base + "y",
            base + "z"
        };
        assertEquals(base, exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test30_longStringsNoPrefix() {
        String[] strs = {
            "a".repeat(200),
            "b".repeat(200),
            "c".repeat(200)
        };
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    // Order Matters
    @Test
    void test31_shortestNotFirst() {
        String[] strs = {"flower", "flow", "fl"};
        assertEquals("fl", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test32_shortestInMiddle() {
        String[] strs = {"flower", "fl", "flight"};
        assertEquals("fl", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test33_shortestAtEnd() {
        String[] strs = {"flower", "flight", "fl"};
        assertEquals("fl", exercise16.longestCommonPrefix(strs));
    }

    // Corner Cases
    @Test
    void test34_oneCharStrings() {
        String[] strs = {"a", "b", "c"};
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

    @Test
    void test35_mixedWithEmpty() {
        String[] strs = {"prefix", "pre", "", "pref"};
        assertEquals("", exercise16.longestCommonPrefix(strs));
    }

}
