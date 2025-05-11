package at.fhj.msd;

import java.util.LinkedList;


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

      public LinkedList<Integer> addTwoNumber(LinkedList<Integer> l1 , LinkedList<Integer> l2)
      {
            LinkedList<Integer> s1 = new LinkedList<>();
            for (int i = 0; i < l1.size(); i++)
            {
                  int one = l1.get((l1.size() - 1) - i);
                  s1.addLast(one);
            }

            LinkedList<Integer> s2 = new LinkedList<>();
            for (int i = 0; i < l2.size(); i++)
            {
                  int one = l2.get((l2.size() - 1) - i);
                  s2.addLast(one);
            }


            LinkedList<Integer> solution = new LinkedList<>();
            if (s1.size() > s2.size())
            {
                  for (int i = 0; i < s1.size(); i++)
                  {
                    solution.add(i, s1.get(i) + s2.get(i));
                  }
            }
            else if (s2.size() > s1.size())
            {
                  for (int i = 0; i < s1.size(); i++)
                  {
                    solution.add(i, s1.get(i) + s2.get(i));
                  }

            }
            else{
                  for (int i = 0; i < s1.size(); i++)
                  {
                        solution.add(i, s1.get(i) + s2.get(i));
                  }
            }

            
            

            return solution;
      }
}
