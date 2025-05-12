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
            //Reversing l1
            LinkedList<Integer> s1 = new LinkedList<>();
            for (int i = 0; i < l1.size(); i++)
            {
                  int one = l1.get((l1.size() - 1) - i);
                  s1.addLast(one);
            }

            //Reversing l2
            LinkedList<Integer> s2 = new LinkedList<>();
            for (int i = 0; i < l2.size(); i++)
            {
                  int one = l2.get((l2.size() - 1) - i);
                  s2.addLast(one);
            }

                  String one = "";
                  String two = "";


            LinkedList<Integer> solution = new LinkedList<>();
            if (s1.size() > s2.size())
            {
                  
                  for (int i = 0; i < s1.size(); i++)
                  {
                    one += (s1.get(i).toString());
                    if (i < s2.size())
                    {
                        two += (s2.get(i).toString());
                    }
                   
                  }
            }
            else if (s2.size() > s1.size())
            {
                  for (int i = 0; i < s2.size(); i++)
                  {
                    if (i < s1.size())
                    {
                        one += (s1.get(i).toString());
                    }
                    two += (s2.get(i).toString());
                  }

            }
            else{
                  for (int i = 0; i < s1.size(); i++)
                  {
                      one += (s1.get(i).toString());
                      two += (s2.get(i).toString());
                  }
            }

            int numsolv = (Integer.parseInt(one) + Integer.parseInt(two));

            String numberStr = Integer.toString(numsolv);
            int digit[] = new int[numberStr.length()];
           
           for (int i = 0; i < numberStr.length(); i++)
           {
            digit[i] = numberStr.charAt(i) - '0';
            solution.addFirst(digit[i]);
           }
           
            return solution;
      }
}
