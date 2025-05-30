package at.fhj.msd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.plaf.BorderUIResource;


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

   
    
      public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            List<Integer> SortedList = AddToSortedList(nums1, nums2);

            if (SortedList.size() % 2 == 0)
            {
                  double BeforeMedian = SortedList.get(SortedList.size()/2-1);
                  double AfterMedian = SortedList.get(SortedList.size()/2);
                  return (BeforeMedian + AfterMedian) / 2;
            }
            else{
                  int Median = SortedList.size()/2;
                  return SortedList.get(Median);
            }
            
      }

      public List<Integer> AddToSortedList(int[] nums1, int[] nums2)
      {
            List<Integer> SortedList = new ArrayList<>();
            index1 = 0;
            index2 = 0;

            while (true) { 
             try {
                pointer1 = setPointer1(nums1, nums2);
                pointer2 = setPointer2(nums1, nums2);
                if (pointer1 == pointer2)
                {
                  
                  if (index1 < nums1.length && index2 < nums2.length)
                  {
                        SortedList.add(pointer2);
                  }
                  

                  index1++;
                  index2++;
                }
                else if (checkMin(pointer1, pointer2) == pointer2)
                {
                  index2++;
                }
                else if (checkMin(pointer1, pointer2) == pointer1)
                {
                  index1++;
                }
                SortedList.add(checkMin(pointer1, pointer2));
               
             }catch (IndexOutOfBoundsException e) {
                  return SortedList;
            }
      }
                
      }


      public int checkMin(int pointer1, int pointer2)
      {
            if (pointer1 < pointer2)
            {
                  return pointer1;
            }
            else if(pointer2 < pointer1)
            {
                  return pointer2;
            }
            else{
                  return pointer1;
            }
      }

      public int setPointer1(int[] nums1, int[] nums2)
      {
            if (index1 < nums1.length)
            {
                  return nums1[index1];
            }
            else{
                  return nums2[index2];
            }
      }

      public int setPointer2(int[] nums1, int[] nums2)
      {
            if (index2 < nums2.length)
            {
                  return nums2[index2];
            }
            else{
                  return nums1[index1];
            }
      }
      

       
}
