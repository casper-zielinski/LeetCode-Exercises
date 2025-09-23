# Leetcode exercises

## Leetcode exercise 1 (Dif: Easy)

![Leetcode Problem](resources/Leetcode-Problem1.png)
> Two Sum [X]  
> It returns two Values, those two Values are indexes of the Array that the method received. The indexes both show to values, and those values added are the target Integer, that is also given to the ``twoSum()`` method

**The Code (in Solution.java) :**

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

**The Code (in App.java) :**

```java

 int[] v = {3,3};
 int target = 6;
 Solution s = new Solution();

System.out.println(Arrays.toString(s.twoSum(v, target)));  

```

## Leetcode Exercise 2 (Dif: Medium)

![Leetcode Problem 2](resources/Leetcode-Problem2.png)

> I firstly did it wrong, because to use the Test Cases provided by Leetcode, you need to use the ``ListNode.java`` Class provided:

**The Code (in ListNode.java) :**

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

**The Code (in Solution.java) :**

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

**The Code (in Solution.java) :**

```java
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
```

> The most of the documentation is in the Code Comments already, it uses recursive Method calling
> to get to the next Node and saving it's value without overriding previous ones.  
> In App.Java for Test:

**The Code (in App.java) :**

```java
ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));

ListNode l2 = new ListNode(9, new ListNode(9, new ListNode (9, new ListNode(9))));

System.out.println(s.addTwoNumbers(l1, l2));
//Just to debug (It wont print anything logical)
```

>Here's an explanation of how the head and solved nodes work (because this part confused me the most):
>This Code

```java

public ListNode solved = new ListNode(0); // Startnode (Dummy)
public ListNode head = solved;            // head points to the Start of the List
```

> Then:

```java

solved.next = new ListNode(sum);

```

>➡️ What’s happening here?

- You create a new ListNode with the value sum.

- You attach this new node to the end of the current list (i.e., to solved).

- The structure of the list has changed — head still points to the beginning, but the linked structure has been extended.

```java

solved = solved.next;

```

>➡️ What’s happening here?

- You're just changing the reference solved.

- It no longer points to the first node but to the newly added node (new ListNode(sum)).

>But:

- head remains unchanged.

- head still points to the dummy node at the front ([0]).
  
>🔍 Why doesn't head get updated?
Because you initially made head and solved point to the same node:

```java
ListNode solved = new ListNode(0);
ListNode head = solved;
```

>After this, they both point to the same place — but as soon as you do solved = solved.next, you're changing the reference of solved to a new object.  
>This doesn't change the object that head is pointing to.

```java
ListNode solved = new ListNode(0);  // Dummy-StartNode
ListNode head = solved;             // head points to solved

solved.next = new ListNode(3);      // [0] -> [3]
solved = solved.next;              // solved points to [3]
solved.next = new ListNode(5);      // [0] -> [3] -> [5]
```

- head still points to [0].

- You can traverse the entire list starting from head, for example:

```java
while (head != null) {
    System.out.println(head.val);
    head = head.next;
}
// Output: 0 3 5

```

>💡 Key takeaway:
solved = solved.next moves the pointer.
solved.next = new ListNode(...) changes the structure of the list.
When you later work with head.next, the dummy node [0] helps you return just the actual result starting from head.next.

## Leetcode Exercise 1 with better Time Complexity O(n log n)

**The Code (in Solution.java) :**

```java
      private int pointer1;
      private int pointer2; 
      private int index1;
      private int index2;
      private int[] solution = new int[2];
      
      
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

```

> It uses Pointers instead of iterating through the Array two Times (Which is the previous one with a time complexity of O(n²)). This Code transforms an Array into a List, with this List it is checked, which values are needed to be added to sum up the target, of these values the indexes are returned. This is made because the original array is being sorted, so the indexes would be wrong.

## Leetcode Exercise 3 (Dif: Medium)

![Two Sum II - Input Array Is Sorted](resources/Leetcode-Problem3.png)

**The Code (in Solution.java) :**

```java
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
```

>Similar to the first exercise, this array is sorted, which makes it much easier to find the indexes. I used two Pointers to find the two values who summed up are equal to the target value.
> The YT Video that explains how Pointers work: [https://www.youtube.com/watch?v=4YKBwKnTnlM&t=674s](YT-Video)

## Leetcode Exercise 4 (Dif: Hard)

![Leetcode Problem 4](resources/Leetcode-Problem4.png)

>Used Pointers to go through the arrays and add them to the list. Althrough it works, the Time Complexity is O(n+m) [n being the length of the first array and m the length of the second array].  
> Also used more Methods to make the Code readable

```java
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
```

- The ``findMedianSortedArrays()`` Method calls the ``AddToSortedList()`` Method with the given Arrays and finds the Median in them. The ``AddToSortedList()`` Method merges the Arrays into a List while still keeping the List sorted. The ``checkMin()`` Method checks two values and returns the smaller one. The ``setPointer1()`` and ``setPointer2()`` Method both set The Pointers to another if one Array has been already iterated through.

## Leetcode Exercise 5 (Dif: Easy)

![Problem 5](resources/Leetcode-Problem5.png)

*Problem: You have an Integer Array with duplicates, return how many unique charachters exist.*

## Leetcode Exercise 6 (Dif: Medium)

![Problem 6](resources/Leetcode-Problem6.png) 

*Problem: Find the Longest Palindrom in a String and return it*

Solved it usind DP (Dynamic Programming) 
Solving Bigger Problems using Solutions from smaller Problems

## Leetcode Exercise 7 (Dif: Easy)

![Problem 7](resources/Leetcode-Problem7.png)

*Problem: Find occurrences of val value in a integer array and delete it, while the other values are at the left side, the right side is not important and can be whatever it can be.*

Solved it using Two-Pointers and swaping the Elements and Deleting the Element val by Transforming it to -1

## Leetcode Exercise 8 (Dif: Easy)

![Problem 8](resources/Leetcode-Problem8.png)

*Problem: Find a String in a different String and give the index (Starting index) of the first occurrence, return -1 if the substring is not found*

Solved it using Two Pointers, but can be done faster (Sliding Window).

It thought it can be done better using Sliding Window, but it is slower because of the building of the sliding window.

Faster with: KMP-Algorithmus (Knuth-Morris-Pratt).

## Leetcode Exercise 9 (Dif: Medium)

![Problem 9](resources/Leetcode-Problem9.png)
