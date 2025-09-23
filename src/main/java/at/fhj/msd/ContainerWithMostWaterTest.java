package at.fhj.msd;

public class ContainerWithMostWaterTest {

    public static void main(String[] args) {
        test(new int[]{10000, 1, 1, 1, 1, 1, 1, 1, 10000}, 80000);
        test(new int[]{1, 10000, 1, 10000, 1, 10000, 1, 10000, 1}, 60000);
        test(generateDecreasingArray(10000), 25000000);
        test(generateArrayWithPeaks(100000, 4567, 7890, 10000), 33230000);
        test(generateAlternatingZeroMax(100000, 10000), 999980000);
        test(generatePeakInMiddle(100000, 50000, 999999999), 99999);
    }

    static void test(int[] height, int expected) {
        Exercise_9 exercise_9 = new Exercise_9();
        int result = exercise_9.maxArea(height);
        System.out.println("Expected: " + expected + ", Got: " + result + 
            (result == expected ? " Yes" : " No"));
    }

    // Main algorithm


    // Utility: strictly decreasing heights
    static int[] generateDecreasingArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    // Utility: two peaks
    static int[] generateArrayWithPeaks(int size, int index1, int index2, int value) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        arr[index1] = value;
        arr[index2] = value;
        return arr;
    }

    // Utility: alternating zero and max
    static int[] generateAlternatingZeroMax(int size, int maxValue) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (i % 2 == 0) ? 0 : maxValue;
        }
        return arr;
    }

    // Utility: peak in the middle
    static int[] generatePeakInMiddle(int size, int peakIndex, int peakValue) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        arr[peakIndex] = peakValue;
        return arr;
    }
}

