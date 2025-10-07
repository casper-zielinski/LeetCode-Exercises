package at.fhj.msd;

/**
 * Exercise 5: Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates
 * in-place such that each unique element appears only once. The relative order of
 * the elements should be kept the same. Return the number of unique elements.
 */
public class Exercise_5 {

      private static int pointer;
      private static int pointer2;
      private static int index;

      /**
       * Removes duplicates from a sorted array in-place.
       * Time complexity: O(n)
       * Space complexity: O(1)
       *
       * @param nums sorted array of integers
       * @return number of unique elements
       */
      public static int removeDuplicates(int[] nums) {
            for (int i = 0; i < nums.length; i++)
            {
                  pointer = nums[i];

                  // If current element is different from previous, or it's the first element
                  if (pointer2 != pointer || i == 0)
                  {
                      // Place unique element at the next available position
                      nums[index] = nums[i];
                      index++;
                      pointer2 = pointer;
                  }

            }
        return index;
      }

}
