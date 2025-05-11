package at.fhj.msd;


public class Solution {

      public int[] twoSum(int[] nums, int target){
            int [] Solution = new int[2];
           
             
      

            for (int i = 0; i < nums.length; i++)
            {
                  for (int j = 1; j <= (nums.length - 1); j++)
                  {
                        if (nums[i] + nums[j] == target && i != j)
                        {
                              Solution[0] = i;
                              Solution[1] = j;
                        }
                  }
            }
            
            return Solution;
      }
}
