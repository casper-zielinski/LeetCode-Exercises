import java.util.Arrays;

public class RemoveDuplicates {
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
