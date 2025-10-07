package at.fhj.msd;

/**
 * Exercise 7: Remove Element
 * Given an integer array nums and an integer val, remove all occurrences of val
 * in nums in-place. The relative order of elements may be changed.
 * Return the number of elements in nums which are not equal to val.
 */
public class Exercise_7 {

      private int pointer1;
      private int pointer2;


      /**
       * Removes all occurrences of a value from the array in-place using two pointers.
       * Time complexity: O(n)
       * Space complexity: O(1)
       *
       * @param nums array of integers
       * @param val value to remove
       * @return number of elements remaining after removal
       */
      public int removeElement(int[] nums, int val) {
            pointer1 = 0;
            pointer2 = nums.length - 1;


            while (pointer2 + 1 >= pointer1)
            {

                  try { // Delete from end before swapping

                      if (nums[pointer2] == val)
                        {
                              nums[pointer2] = -1;
                              pointer2--;
                        }

                  } catch (Exception e) {

                  }


                  try {

                        // Swap if current element equals val
                        if (nums[pointer1] == val)
                        {
                              int temp = nums[pointer2];
                              nums[pointer2] = nums[pointer1];
                              nums[pointer1] = temp;
                        }

                         try {

                              // Delete after swap if needed
                              if (nums[pointer2] == val)

                                    {
                                          nums[pointer2] = -1;
                                          pointer2--;
                                    }

                        } catch (Exception e) {

                        }

                        // Handle element before current pointer
                        if (pointer1 > 0 && nums[pointer1 - 1] == val)
                        {
                              int temp = nums[pointer2];
                              nums[pointer2] = nums[pointer1 - 1];
                              nums[pointer1 - 1] = temp;
                        }

                        try {

                              if (nums[pointer2] == val)
                              {
                                    nums[pointer2] = -1;
                                    pointer2--;
                              }

                        } catch (Exception e) {

                        }


                  } catch (Exception e) {

                  }




                  pointer1++;
            }


            return pointer2 + 1;
      }

}
