package at.fhj.msd;

public class Exercise_9 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Berechnent aktuelle Area
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;

            // Update maximum area
            maxArea = Math.max(maxArea, currentArea);

            // Bewege den Pointer mit der kleineren Höhe
            // Warum? Der kleinere limitiert die Area,
            // also probieren wir eine größere Höhe zu finden
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
