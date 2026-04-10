import java.util.*;

public class Solution {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int[] memo = new int[n + 1];
            memo[0] = 0;
            memo[1] = 1;


            int i = 2;
            while (i <= n) {
                memo[i] = memo[i - 1] + memo[i - 2];
                i++;
            }


            return memo[n];
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
