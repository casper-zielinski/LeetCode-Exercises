import java.util.ArrayList;
import java.util.List;

public class summary_ranges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            int start = nums[i];

            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {

                i++;
            }
            if (start == nums[i]) {
                ans.add(String.valueOf(start));
            } else {
                ans.add(String.format("%d->%d", start, nums[i]));
            }
            i++;
        }

        return ans;
    }

}
