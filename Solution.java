import java.util.*;

public class Solution {

    public void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return;
        }

        Map<String, Integer> bucket = new HashMap<>();
        int i = 0; //setter / getter
        int j = matrix.length - 1; // getter
        int c = 0; // setter
        while (i < matrix.length) {
            while (j >= 0) {
                bucket.put("%d,%d".formatted(i, c), matrix[i][c]);

                if (bucket.containsKey("%d,%d".formatted(j, i))) {
                    matrix[i][c] = bucket.get("%d,%d".formatted(j, i));
                } else {
                    matrix[i][c] = matrix[j][i];
                }

                j--;
                c++;
            }
            c = 0;
            i++;
            j = matrix.length - 1;
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
