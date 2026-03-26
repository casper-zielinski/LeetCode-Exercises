import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return n;
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

    public int removeDuplicates(int[] nums) {
        int j = 1;
        int i = 1;
        while (nums.length > i) {
            if (nums[i - 1] != nums[i]) {
                nums[j] = nums[i];
                ++j;
            }

            i++;
        }

        return j;
    }
}
