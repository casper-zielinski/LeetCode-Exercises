package at.fhj.msd;

import java.util.LinkedList;

/**
 * Exercise 2: Add Two Numbers
 * Given two non-empty linked lists representing two non-negative integers,
 * where the digits are stored in reverse order, add the two numbers and
 * return the sum as a linked list.
 */
public class Exercise_2 {

      /**
       * Initial approach using LinkedList - converts lists to numbers and adds them.
       * Note: This approach has limitations with very large numbers.
       *
       * @param l1 first number as linked list (reversed)
       * @param l2 second number as linked list (reversed)
       * @return sum as linked list (reversed)
       */
      public LinkedList<Integer> addTwoNumber(LinkedList<Integer> l1 , LinkedList<Integer> l2)
      {
            // Reversing l1 to get the actual number
            LinkedList<Integer> s1 = new LinkedList<>();
            for (int i = 0; i < l1.size(); i++)
            {
                  int one = l1.get((l1.size() - 1) - i);
                  s1.addLast(one);
            }

            // Reversing l2 to get the actual number
            LinkedList<Integer> s2 = new LinkedList<>();
            for (int i = 0; i < l2.size(); i++)
            {
                  int one = l2.get((l2.size() - 1) - i);
                  s2.addLast(one);
            }

                  String one = "";
                  String two = "";


            LinkedList<Integer> solution = new LinkedList<>();
            // Build string representations based on which list is longer
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

            // Add the two numbers
            int numsolv = (Integer.parseInt(one) + Integer.parseInt(two));

            // Convert sum back to linked list (reversed)
            String numberStr = Integer.toString(numsolv);
            int digit[] = new int[numberStr.length()];

           for (int i = 0; i < numberStr.length(); i++)
           {
            // Subtracting the integer value of '0' from the char returns an Integer
            digit[i] = numberStr.charAt(i) - '0';
            solution.addFirst(digit[i]);
           }

            return solution;
      }




      public ListNode solved = new ListNode(0);
      public ListNode head = solved;
      public int carry = 0;

      /**
       * Optimized recursive approach using ListNode - handles carry properly.
       * This approach works with arbitrarily large numbers.
       *
       * @param l1 first number as ListNode (reversed order)
       * @param l2 second number as ListNode (reversed order)
       * @return sum as ListNode (reversed order)
       */
      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            /*
             * Summing both values and the carry value
             * Example: 5 + 5 = 10, then sum = 0 and carry = 1
             * carry is calculated as sum / 10 (integer division ignores decimals)
             * If there is a carry, sum should only be the last digit
             * Example: 6 + 6 = 12 --> sum = 2 and carry = 1 (using modulo %)
            */
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            if (carry >= 1) sum = sum % 10;
            solved.next = new ListNode(sum);
            solved = solved.next;

            /*
             * Recursive function to process the next nodes
             * Purpose: Take the next node (.next) and solve the sum equation,
             * then add it to the head ListNode
             *
             * How it works:
             * - solved.next = new ListNode(sum) adds the new node to the result
             * - solved = solved.next moves to the next position in the result list
             * - With solved.next, the new ListNode element is added to the head
             * - With solved = solved.next, we move to the next node element
             *
             * The if statements check if the given ListNodes are empty:
             * - If empty, use a ListNode with value 0
             * - This handles numbers of different lengths correctly
             *
             * The last if statement checks if there's still a carry value:
             * - If there is, append it to the solution via:
             *   solved.next = new ListNode(carry);
             *   solved = solved.next;
             *
             * Return head.next instead of head because the first value is a placeholder:
             * - head starts as new ListNode(0) as a dummy node
             * - Returning head would include this placeholder 0
             * - Returning head.next skips the placeholder
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


}
