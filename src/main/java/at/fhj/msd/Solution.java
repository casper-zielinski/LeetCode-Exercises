package at.fhj.msd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Solution<T> {

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

     
      private int pointer1;
      private int pointer2; 
      private int index1;
      private int index2;
      private final int[] solution = new int[2];
      
      
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
            digit[i] = numberStr.charAt(i) - '0'; //means basically subtracting the integer 0 from the char, which then returns an Integer
            solution.addFirst(digit[i]);
           }
           
            return solution;
      }




      public ListNode solved = new ListNode(0);
      public ListNode head = solved;
      public int carry = 0;

      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            /*
             * Summing both Values and the Carry Value 
             * (if 5 + 5 = 10, then sum = 0 and carry 1)
             * carry is just sum / 10, because it is an integer, 
             * the commas are ignored
             * if there is a carry, then sum should only be the first number
             * (so 6 + 6 --> sum = 2 and carry = 1)
            */ 
            int sum = l1.val + l2.val + carry;
            carry = sum/10; //
            if (carry >= 1) sum = sum % 10; // 
            solved.next = new ListNode(sum);
            solved = solved.next;

            /*
             * Here are the recursiv Functions
             * They purpose is to take the next
             * Node (the .next Node) and
             * with that solve the sum equation and 
             * adding it to the head ListNode
             * This works with the lines:
             * solved.next = new ListNode(sum);
             * solved = solved.next;
             * With solver.next the new ListNode Element
             * is also added to the header and 
             * with the solved = solved.next line
             * it goes to the next Node Element
             * 
             * The if statements are there to check if the 
             * given List Node are Empty, and if they are, then to just use 
             * a ListNode Element with the Value 0, which makes sense when it 
             * comes to adding two numbers different size
             * 
             * The last if statement is there to check if these
             * is still a carry, if there is
             * than it should be appended to the solution
             * via:
             * solved.next = new ListNode(carry);
             * solved = solved.next;
             * 
             * than the head.next is returned, because the first value is a placeholder
             * public ListNode solved = new ListNode(0);
             * public ListNode head = solved;
             * in this hase return head would also return the 0 value, which
             * is easy avoidable by returning just head.next
             */
            if (l1.next != null && l2.next != null)
            {
                  addTwoNumbers(l1.next, l2.next);
            }
            else if (l1.next != null && l2.next == null)
            {
                  addTwoNumbers(l1.next, new ListNode(0));
            }
            else if (l1.next == null && l2.next != null)
            {
                  addTwoNumbers(new ListNode(0), l2.next);
            }
            else if (carry > 0)
            {
                  solved.next = new ListNode(carry);
                  solved = solved.next;
            }
            
            return head.next;
      }


      public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            


            return 3.14;
      
      }


      
      public int[] twoSumSorted(int[] numbers, int target)
      {
            index1 = 0;
            index2 = numbers.length - 1;
            


            while (index1 < index2)
            {
      	      pointer1 = numbers[index1];
                  pointer2 = numbers[index2];

                  int sum = pointer1 + pointer2;

                  if (sum > target) --index2;
                  else if (sum < target) ++index1;
                  else{
                        int[] sol = {index1 + 1, index2 + 1};
                        return sol;
                  }
            }
            return null;
      }



      

      public int inOF = 0;
      public String longestPalindrome(String s) {
            String[] sArray = s.split("");
            List<String> sList = new ArrayList<>();
            List<String> palindromList = new ArrayList<>();
            LinkedList<Integer> whichindex = new LinkedList<>();
            String palindrom = "";
            int count = 0;
            
            index2 = 0;

           for (int i = 0; i < sArray.length; i++)
           {
            
            if (sList.contains(sArray[i]))
            {
                 index1 = sList.indexOf(sArray[i]);
                 sList.add(sArray[i]);
                 index2 = sList.lastIndexOf(sArray[i]);
                 int copy_index2 = index2;
                 int distance = index2 - index1;
                 int j = 0;
                 int right = 0;
                 while (j < distance)
                 {
                  if (j == 0) palindrom = "";
                  
                  if (sList.get(index1).equals(sList.get(index2)))
                  {
                        ++right;
                        palindrom += sArray[index2];
                  }
                  ++index1;
                  --index2;
                  ++j;
                 }

                 if (right == distance)
                 {
                  palindrom+= sArray[copy_index2];
                  palindromList.add(palindrom);
                  if (palindromList.size() > 1)
                  {
                        if (palindromList.get(count - 1).length() > palindromList.get(count).length())
                        {
                              whichindex.addFirst(count);
                        }
                        else
                        {
                              whichindex.addLast(count);
                        }
                  }
                  else{
                        whichindex.add(count); 
                  }
                  ++count;
                 }
            }
            else{
                sList.add(sArray[i]);  
            }
           }

           if (!palindromList.isEmpty())
           {
             return palindromList.get(whichindex.getLast());
           }
           else{
            return sArray[0];
           }
           
      }
      

       
}
