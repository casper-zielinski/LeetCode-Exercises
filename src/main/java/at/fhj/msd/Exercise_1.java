package at.fhj.msd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_1 {
      private int pointer1;
      private int pointer2; 
      private int index1;
      private int index2;
      private final int[] solution = new int[2];
      
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

      public int[] twoSumEfficient(int[] nums, int target)
      {
      
      int[] copy = nums;
      List<Integer> list = Arrays.stream(copy).boxed().collect(Collectors.toList());
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
                  if (sum > target)
                  {
                        --index2;
                  }
                  else if (sum < target)
                  {
                        ++index1;
                  }
                  if (sum == target)
                  {
                        solution[0]= list.indexOf(pointer1);
                        solution[1] = list.lastIndexOf(pointer2);
                        return solution;
                        
                  }
            }
        }
        else return solution;
      }

}
