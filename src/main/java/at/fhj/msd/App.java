package at.fhj.msd;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Exercise_9 exercise_9 = new Exercise_9();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(exercise_9.maxArea(height));
        System.out.println(Arrays.toString(height));
    }
}
