package at.fhj.msd;

public class Exercise_5 {

      private static int pointer; 
      private static int pointer2;
      private static int index;

      public static int removeDuplicates(int[] nums) {
            for (int i = 0; i < nums.length; i++)
            {
                  pointer = nums[i];

                  if (pointer2 != pointer || i == 0)
                  {
                      nums[index] = nums[i];
                      index++;  
                      pointer2 = pointer;
                  }
                  
            }
        return index;
      }

}
