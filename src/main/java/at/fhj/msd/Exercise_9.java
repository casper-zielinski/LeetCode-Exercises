package at.fhj.msd;

/**
 * Exercise 9: Container With Most Water
 * Given n non-negative integers representing the height of lines,
 * find two lines that together with the x-axis form a container
 * that holds the most water.
 */
public class Exercise_9 {

    /**
     * Finds the maximum area of water that can be contained using two-pointer approach.
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param height array of heights
     * @return maximum area
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate current area
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;

            // Update maximum area
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer with the smaller height
            // Why? The smaller height limits the area,
            // so we try to find a larger height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
