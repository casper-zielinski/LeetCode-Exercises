import java.util.*;

public class Solution {

    public void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }

    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int[] ans = new int[n];

        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[j - i] = (int) Math.pow(nums[i], 2);
                i++;
            } else {
                ans[j - i] = (int) Math.pow(nums[j], 2);
                j--;
            }
        }

        return ans;
    }

    /**
     * TODO Rewatch Video to do it again correctly using HashSet
     */

    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> toRemove = new HashMap<>();

        for (int num : nums) {
            map.put(num, num);
            toRemove.put(num, num);
        }

        int temp = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (toRemove.isEmpty()) {
                break;
            }

            int i = entry.getValue();

            while (map.containsKey(i)) {
                temp++;
                toRemove.remove(i);
                i++;
            }

            if (temp > ans) {
                ans = temp;
            }

            temp = 0;
        }


        return ans;
    }

    /**
    *  TODO
     * Boyer-Moore Voting Algorithm next!
     * Uses a candidate and counter variable
     * Try it next!
     */


    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int appearences = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                int c = map.get(num);

                if (c > appearences) {
                    return num;
                }

                map.replace(num, ++c);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > appearences) return entry.getKey();
        }

        return 0;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> mergedList = new ArrayList<>();

        if (strs.length == 1) {
            List<String> stringList = new ArrayList<>();
            stringList.add(strs[0]);
            mergedList.add(stringList);
            return mergedList;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            String sortedString = new String(letters);
            if (map.containsKey(sortedString)) {
                List<String> stringList = map.get(sortedString);
                stringList.add(s);
                map.replace(sortedString, stringList);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                map.put(sortedString, stringList);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            mergedList.add(entry.getValue());
        }

        return mergedList;
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        Set<Character> box = new HashSet<>();

        int i = 0;
        int j = 0;

        while (i < 9) {

            while (j < 9) {
                Character toRow = board[i][j];
                Character toColumn = board[j][i];
                Character toBox = board[3 * (i / 3) + (j / 3)][3 * (i % 3) + (j % 3)];

                if (!toRow.equals('.')) {
                    if (!row.add(toRow)) {
                        return false;
                    }
                }

                if (!toColumn.equals('.')) {
                    if (!col.add(toColumn)) {
                        return false;
                    }
                }


                if (!toBox.equals('.')) {
                    if (!box.add(toBox)) {
                        return false;
                    }
                }

                j++;
            }

            row.clear();
            col.clear();
            box.clear();
            i++;
            j = 0;
        }

        return true;
    }

    private final Map<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }

        int x;
        int y;
        if (dp.containsKey(n - 1)) {
            x = dp.get(n - 1);
        } else {
            x = climbStairs(n - 1);
            dp.put(n - 1, x);
        }

        if (dp.containsKey(n - 2)) {
            y = dp.get(n - 2);
        } else {
            y = climbStairs(n - 2);
            dp.put(n - 2, y);
        }

        return x + y;
    }

    public int maxNumberOfBalloons(String text) {
        Map<String, Integer> map = new HashMap<>();
        map.put("b", 0);
        map.put("a", 0);
        map.put("l", 0);
        map.put("o", 0);
        map.put("n", 0);

        for (int i = 0; i < text.length(); i++) {
            String curr = String.valueOf(text.charAt(i));
            if (map.containsKey(curr)) {
                int count = map.get(curr);
                map.replace(curr, count + 1);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count;
            if (entry.getKey().equals("l") || entry.getKey().equals("o")) {
                count = entry.getValue() / 2;
            } else {
                count = entry.getValue();
            }
            ans = Math.min(ans, count);
        }

        return ans;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sWords = new int[26];

        for (char sChar : s.toCharArray()) {
            sWords[sChar - 'a']++;
        }

        for (char tChar : t.toCharArray()) {
            if (sWords[tChar - 'a'] == 0) {
                return false;
            } else {
                sWords[tChar - 'a']--;
            }
        }

        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            String curr = String.valueOf(magazine.charAt(i));
            if (map.containsKey(curr)) {
                int count = map.get(curr) + 1;
                map.replace(curr, count);
            } else {
                map.put(curr, 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            String curr = String.valueOf(ransomNote.charAt(i));
            if (!map.containsKey(curr) || map.get(curr) <= 0) {
                return false;
            } else {
                int count = map.get(curr) - 1;
                map.replace(curr, count);
            }
        }

        return true;
    }

    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < jewels.length(); i++) {
            String j = String.valueOf(jewels.charAt(i));
            map.put(j, j);
        }

        for (int i = 0; i < stones.length(); i++) {
            if (map.containsKey(String.valueOf(stones.charAt(i)))) {
                ans++;
            }
        }

        return ans;
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }

            map.put(num, num);
        }

        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String sr = strs[0];

        for (String str : strs) {
            for (int i = 0; i < sr.length(); i++) {
                if (i > str.length() - 1 || sr.charAt(i) != str.charAt(i)) {
                    sr = sr.substring(0, i);
                    break;
                }
            }
        }

        return sr;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return;
        }

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reflection
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int left = matrix[i][j];
                int right = matrix[i][(n - 1) - j];
                matrix[i][j] = right;
                matrix[i][(n - 1) - j] = left;
            }
        }
    }

    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) goingDown = !goingDown;
            i += goingDown ? 1 : -1;
        }

        StringBuilder sr = new StringBuilder();
        for (StringBuilder row : rows) {
            sr.append(row);
        }


        return sr.toString();
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        int topWall = 0;
        int bottomWall = matrix.length - 1;
        int leftWall = 0;
        int rightWall = matrix[0].length - 1;
        int s = matrix.length * matrix[0].length;


        List<Integer> res = new ArrayList<>();

        while (res.size() < s) {

            if (topWall <= bottomWall) {
                for (int i = leftWall; i < rightWall + 1; i++) {
                    res.add(matrix[topWall][i]);
                }

                topWall++;
            }

            if (rightWall >= leftWall) {
                for (int i = topWall; i < bottomWall + 1; i++) {
                    res.add(matrix[i][rightWall]);
                }

                rightWall--;
            }

            if (bottomWall >= topWall) {
                for (int i = rightWall; i > leftWall - 1; i--) {
                    res.add(matrix[bottomWall][i]);
                }

                bottomWall--;
            }

            if (leftWall <= rightWall) {
                for (int i = bottomWall; i > topWall - 1; i--) {
                    res.add(matrix[i][leftWall]);
                }

                leftWall++;
            }
        }
        return res;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (memo.containsKey(n)) return memo.get(n);
            int result = fib(n - 1) + fib(n - 2);
            memo.put(n, result);
            return result;
        }
    }

    public int hIndex(int[] citations) {
        int h = 1;
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int page_number = 0;
            int j = 0;
            while (j < n && h > page_number) {
                if (h <= citations[j]) {
                    page_number++;
                }
                j++;
            }

            if (h > page_number) {
                return h - 1;
            }

            h++;
        }

        return h - 1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1;
        int y = n - 1;
        int z = nums1.length - 1;

        while (z > x) {
            if (y < 0) {
                break;
            } else if (x < 0 || nums2[y] > nums1[x] || nums2[y] == nums1[x]) {
                nums1[z] = nums2[y];
                y--;
                z--;
            } else if (nums1[x] > nums2[y]) {
                nums1[z] = nums1[x];
                x--;
                z--;
            }
        }
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        final int n = nums.length;

        if (n == 0 || n == 1) {
            return n;
        }

        while (i < n) {
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

            if (i < n - 1) {
                nums[j] = nums[i + 1];
                j++;
                i++;
            } else {
                break;
            }
        }

        return j;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int momentary = 0;
        int j = 0;
        int i = 0;

        while (momentary < 3) {
            while (i < n) {
                if (nums[i] == momentary) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                }
                i++;
            }
            i = 0;
            momentary++;
        }
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (i < j - 2 && nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                swap(nums, nums[i + 2], i + 2);
                j--;
            } else {
                i++;
            }
        }
        return j;
    }

    public void swap(int[] nums, int num, int index) {
        int i = index;
        while (i < nums.length - 1) {
            int temp = nums[i + 1];
            nums[i + 1] = num;
            nums[i] = temp;
            i++;
        }
    }

    public int romanToInt(String s) {
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && roman.get(String.valueOf(s.charAt(i + 1))) > roman.get(String.valueOf(s.charAt(i)))) {
                ans -= roman.get(String.valueOf(s.charAt(i)));
            } else {
                ans += roman.get(String.valueOf(s.charAt(i)));
            }
        }

        return ans;
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0], max = prices[0];
        int n = prices.length;

        for (int i = 0; i < n; i++) {

            if (prices[i] < min) {
                min = prices[i];
                max = min;
            } else if (prices[i] > max) {
                max = prices[i];
            }

            if (i == n - 1 || prices[i + 1] < max) {
                ans += max - min;
                min = prices[i];
            }
        }

        return ans;
    }

    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(ans) || (Math.abs(num) == Math.abs(ans) && num > ans)) {
                ans = Math.abs(num);
            }
        }
        return ans;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            int start = nums[i];

            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start == nums[i]) {
                res.add(String.valueOf(start));
            } else {
                res.add(String.format("%d->%d", start, nums[i]));
            }
            i++;
        }

        return res;
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sr = new StringBuilder();
        int maxLength = Math.max(word1.length(), word2.length());
        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                sr.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                sr.append(word2.charAt(i));
            }
        }
        return sr.toString();
    }
}
