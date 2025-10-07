package at.fhj.msd;

/**
 * Exercise 12: Find Closest Number to Zero
 * Given an integer array nums, return the number with the smallest distance to zero.
 * If there are multiple answers, return the number with the largest value.
 */
public class Exercise12 {

    /**
     * Finds the number closest to zero in the array.
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param nums array of integers
     * @return number closest to zero (largest if tie)
     */
    public int findClosestNumber(int[] nums) {
        int smallest = nums[0];
        for (int num : nums) {
            // Zero is the closest possible number
            if (num == 0) {
                return 0;
            } else {
                // Update if closer to zero, or if same distance but positive
                if (Math.abs(num) < Math.abs(smallest) || (num == Math.abs(smallest) && num > 0)) {
                    smallest = num;
                }
            }
        }

        return smallest;
    }
}
