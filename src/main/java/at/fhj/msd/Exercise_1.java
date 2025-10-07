package at.fhj.msd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise 1: Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target. You may assume that each input has exactly one solution,
 * and you may not use the same element twice.
 */
public class Exercise_1 {
      private int pointer1;
      private int pointer2;
      private int index1;
      private int index2;
      private final int[] solution = new int[2];

      /**
       * Brute force approach to find two numbers that add up to target.
       * Time complexity: O(n²)
       *
       * @param nums the array of integers
       * @param target the target sum
       * @return array containing indices of the two numbers
       */
       public int[] twoSum(int[] nums, int target){
            int [] Solution = new int[2];

            // Check every possible pair of numbers
            for (int i = 0; i < nums.length; i++)
            {
                  for (int j = 1; j <= (nums.length - 1); j++)
                  {
                        // If sum equals target and indices are different
                        if (nums[i] + nums[j] == target && i != j)
                        {
                              Solution[0] = i;
                              Solution[1] = j;
                        }
                  }
            }

            return Solution;
      }

      /**
       * More efficient two-pointer approach using sorted array.
       * Time complexity: O(n log n) due to sorting
       *
       * @param nums the array of integers
       * @param target the target sum
       * @return array containing indices of the two numbers (from original array)
       */
      public int[] twoSumEfficient(int[] nums, int target)
      {

      int[] copy = nums;
      // Keep original indices by storing values in list
      List<Integer> list = Arrays.stream(copy).boxed().collect(Collectors.toList());
      // Sort array to enable two-pointer technique
      Arrays.sort(nums);
      index1 = 0;
      index2 = nums.length - 1;
      int sum = list.get(index1) + list.get(1);
      solution[0] = 0;
      solution[1] = 1;

        if (sum != target)
        {

            while (true)
            {
                  pointer1 = nums[index1];
                  pointer2 = nums[index2];
                  sum = pointer1 + pointer2;
                  // If sum too large, move right pointer left
                  if (sum > target)
                  {
                        --index2;
                  }
                  // If sum too small, move left pointer right
                  else if (sum < target)
                  {
                        ++index1;
                  }
                  // Found the target sum
                  if (sum == target)
                  {
                        // Map back to original array indices
                        solution[0]= list.indexOf(pointer1);
                        solution[1] = list.lastIndexOf(pointer2);
                        return solution;

                  }
            }
        }
        else return solution;
      }

}
