package at.fhj.msd;

/**
 * Exercise 3: Two Sum II - Input Array Is Sorted
 * Given a 1-indexed array of integers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers (1-indexed).
 */
public class Exercise_3 {

      private int pointer1;
      private int pointer2;
      private int index1;
      private int index2;


      /**
       * Two-pointer approach to find two numbers that sum to target in a sorted array.
       * Time complexity: O(n)
       * Space complexity: O(1)
       *
       * @param numbers sorted array of integers (1-indexed)
       * @param target the target sum
       * @return array containing 1-indexed positions of the two numbers
       */
      public int[] twoSumSorted(int[] numbers, int target)
      {
            // Start with pointers at both ends
            index1 = 0;
            index2 = numbers.length - 1;



            while (index1 < index2)
            {
      	      pointer1 = numbers[index1];
                  pointer2 = numbers[index2];

                  int sum = pointer1 + pointer2;

                  // If sum too large, move right pointer left
                  if (sum > target) --index2;
                  // If sum too small, move left pointer right
                  else if (sum < target) ++index1;
                  // Found the target sum, return 1-indexed positions
                  else{
                        int[] sol = {index1 + 1, index2 + 1};
                        return sol;
                  }
            }
            return null;
      }

}
