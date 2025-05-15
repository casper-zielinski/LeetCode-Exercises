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

>Hier eine Erklärung wie der head und solved node funktioniert (weil ich damit am meisten Probleme hatte):  
>Du hast:

```java

public ListNode solved = new ListNode(0); // Startknoten (Dummy)
public ListNode head = solved;            // head zeigt auf den Anfang der Liste
```

> Dann:

```java

solved.next = new ListNode(sum);

```

>➡️ Was passiert hier?

- Du erzeugst einen neuen ListNode mit dem Wert sum

- Du hängst diesen neuen Node an das aktuelle Ende (also an solved)

- Die Liste hat sich strukturell verändert — head zeigt immer noch auf den Anfang, aber die verkettete Struktur hat sich erweitert

```java

solved = solved.next;

```

>➡️ Was passiert hier?

- Du veränderst einfach nur die Referenz solved

- Sie zeigt jetzt nicht mehr auf das erste Element, sondern auf das gerade angehängte neue Element (new ListNode(sum))

>Aber:

- head bleibt unverändert

- head zeigt weiterhin auf den Dummy-Knoten ganz vorne ([0])
  
>🔍 Warum wird head nicht aktualisiert?  
Weil du head und solved beide am Anfang auf denselben Knoten zeigen lässt:

```java
ListNode solved = new ListNode(0);
ListNode head = solved;
```

>Danach zeigen sie auf dieselbe Stelle — aber sobald du solved = solved.next machst, zeigst du solved auf ein neues Objekt.  
>Das ändert nichts an dem Objekt, auf das head zeigt.

```java
ListNode solved = new ListNode(0);  // Dummy-Startknoten
ListNode head = solved;             // head zeigt auf solved

solved.next = new ListNode(3);      // [0] -> [3]
solved = solved.next;              // solved zeigt auf [3]
solved.next = new ListNode(5);      // [0] -> [3] -> [5]
```

- head zeigt noch immer auf [0]

- Du kannst am Ende alles traversieren über head, z. B.:

```java
while (head != null) {
    System.out.println(head.val);
    head = head.next;
}
// Ausgabe: 0 3 5

```

>Merksatz:  
solved = solved.next verschiebt den Zeiger.  
>solved.next = new ListNode(...) verändert die Struktur der Liste.  
>Wenn du später mit head.next arbeitest, ist deine Dummy-Node [0] hilfreich, um am Ende nur das echte Ergebnis ab head.next zurückzugeben.

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
