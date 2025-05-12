# Leetcode exercises

## Leetcode exercise 1

![Leetcode Problem](resources/Leetcode-Problem1.png)
> Two Sum [X]  
> It returns two Values, those two Values are indexes of the Array that the method received. The indexes both show to values, and those values added are the target Integer, that is also given to the ``twoSum()`` method

**The Code: (in Solution.java)**

```java
public int[] twoSum(int[] nums, int target){
 int [] Solution = new int[2];

 for (int i = 0; i < nums.length; i++)
 {

  for (int j = 1; j <= (nums.length -1);j++)
  {
      if (nums[i] + nums[j] = =target && i != j)
      {
       Solution[0] = i;                 
       Solution[1] = j;
      }
  }

 }
            
      return Solution;
}
```

**In App.java (for Example:)**

```java

 int[] v = {3,3};
 int target = 6;
 Solution s = new Solution();

System.out.println(Arrays.toString(s.twoSum(v, target)));  

```

## Leetcode Exercise 2
![Leetcode Problem 2](resources/Leetcode-Problem2.png)

> I firstly did it wrong, because to use the Test Cases provided by Leetcode, you need to use the ``ListNode.java`` Class provided:

```java
public class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```

> and I just used Linked List, which worked, the result came the same as in the test cases, but the test cases didn't work, so i made it again using the ``ListNode.java`` Class.

> This is the Method using Linked List:
```java
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
```
