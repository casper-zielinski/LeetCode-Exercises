import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int i = 0;
        int lastUnique = nums[i];
        while (nums.length - 1 > i) {
            while (nums.length - 1 > i && lastUnique == nums[i]) {
                i++;
            }
            if (lastUnique != nums[i]) {
                lastUnique = nums[i];
                nums[k] = lastUnique;
                k++;

            }
        }

        System.out.println(Arrays.toString(nums));
        return k;
    }
}
