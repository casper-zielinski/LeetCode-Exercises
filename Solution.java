import java.util.*;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode behind = dummy, ahead = dummy;

        for (int i = 0; i <= n; i++) {
            ahead = ahead.next;
        }

        while (ahead != null) {
            behind = behind.next;
            ahead = ahead.next;
        }

        behind.next = behind.next.next;

        return dummy.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        } else if (list1 == null && list2 == null) {
            return null;
        }

        ListNode curr = new ListNode();
        ListNode ans = curr;

        curr.val = Math.min(list1.val, list2.val);

        if (list1.val < list2.val) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        while (list1 != null || list2 != null) {

            if (list2 == null || list1 != null && list1.val < list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }

        return ans;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;

        while (curr.next != null) {
            ListNode nextNode = curr.next;

            int valToInsert = Math.min(curr.val, nextNode.val);

            while (valToInsert > 1) {
                if (curr.val % valToInsert == 0 && nextNode.val % valToInsert == 0) {
                    break;
                } else {
                    valToInsert--;
                }
            }

            curr.next = new ListNode(valToInsert, nextNode);
            curr = nextNode;
        }

        return head;
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<int[]> stack = new ArrayDeque<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int start = i;
            while (!stack.isEmpty() && height < stack.peek()[0]) {
                int[] popped = stack.pop();
                int h = popped[0];
                int j = popped[1];
                int w = i - j;
                ans = Math.max(ans, h * w);
                start = j;
            }
            stack.push(new int[]{height, start});
        }

        while (!stack.isEmpty()) {
            int[] popped = stack.pop();
            int h = popped[0];
            int j = popped[1];
            int w = n - j;
            ans = Math.max(ans, h * w);
        }

        return ans;
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1')
            return false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;

        int farthest = 0;

        while (!queue.isEmpty()) {
            int i = queue.poll();

            int start = Math.max(i + minJump, farthest + 1);
            int end = Math.min(i + maxJump, n - 1);

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0' && !visited[j]) {
                    if (j == n - 1)
                        return true;
                    visited[j] = true;
                    queue.add(j);
                }
            }

            farthest = Math.max(farthest, end);
        }

        return false;
    }

    public int maxJumps(int[] arr, int d) {
        int[] memo = new int[arr.length];
        int ans = 1;

        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, dfs(arr, d, i, memo));
        }

        return ans;
    }

    private int dfs(int[] arr, int d, int i, int[] memo) {
        if (memo[i] != 0) return memo[i];

        int best = 1;

        for (int x = 1; x <= d; x++) {
            if (i + x >= arr.length || arr[i + x] >= arr[i]) break;
            best = Math.max(best, 1 + dfs(arr, d, i + x, memo));
        }

        for (int x = 1; x <= d; x++) {
            if (i - x < 0 || arr[i - x] >= arr[i]) break;
            best = Math.max(best, 1 + dfs(arr, d, i - x, memo));
        }

        memo[i] = best;
        return best;
    }

    public boolean check(int[] nums) {
        int drops = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                drops++;
            }
        }

        return drops <= 1;
    }


    public int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (nums[mid] == target) return mid;

            if (nums[L] <= nums[mid]) {
                if (target >= nums[L] && target < nums[mid]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[R]) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        }

        return -1;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr1) {
            while (num > 0) {
                set.add(num);
                num /= 10;
            }
        }

        int ans = 0;
        for (int num : arr2) {
            while (num > 0) {
                if (set.contains(num)) {
                    int len = String.valueOf(num).length();
                    ans = Math.max(ans, len);
                }
                num /= 10;
            }
        }

        return ans;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<int[]> stack = new ArrayDeque<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                ans[stack.peek()[0]] = i - stack.peek()[0];
                stack.pop();
            }

            stack.push(new int[]{i, temperatures[i]});
        }

        return ans;
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        int n = A.length;
        int count = 0;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            setA.add(A[i]);
            setB.add(B[i]);
            if (setA.contains(B[i])) {
                count++;
                setA.remove(B[i]);
                setB.remove(B[i]);
            }

            if (setB.contains(A[i])) {
                count++;
                setA.remove(A[i]);
                setB.remove(A[i]);
            }

            ans[i] = count;
        }

        return ans;
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) return nums1[i];
                if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                }
            } else if (i >= nums1.length) {
                if (nums1[nums1.length - 1] == nums2[j]) return nums2[j];
                j++;
            } else {
                if (nums2[nums2.length - 1] == nums1[i]) return nums1[i];
                i++;
            }
        }

        return -1;
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int a;
        int b;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        Deque<String> stack = new ArrayDeque<>();

        for (String l : s.split("")) {
            if (map.containsKey(l)) {
                if (!stack.pop().equals(map.get(l))) return false;
            } else {
                stack.push(l);
            }
        }

        return stack.isEmpty();
    }

    public boolean canReach(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int idx, Set<Integer> visited) {

        if (idx < 0 || idx >= arr.length || visited.contains(arr[idx])) {
            return false;
        }

        if (arr[idx] == 0) return true;

        visited.add(arr[idx]);

        return dfs(arr, idx + arr[idx], visited) || dfs(arr, idx - arr[idx], visited);
    }


    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        for (String operation : operations) {
            switch (operation) {
                case "C" -> ans -= stack.pop();
                case "D" -> {
                    int doubleScore = stack.peek() * 2;
                    stack.push(doubleScore);
                    ans += doubleScore;
                }
                case "+" -> {
                    int last = stack.pop();
                    int secondLast = stack.pop();
                    int sum = last + secondLast;

                    stack.push(secondLast);
                    stack.push(last);
                    stack.push(sum);
                    ans += sum;
                }
                default -> {
                    int curr = Integer.parseInt(operation);
                    stack.push(curr);
                    ans += curr;
                }
            }
        }

        return ans;
    }

    public int findMin(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.min(nums[0], nums[1]);
        }

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = (l + r) / 2;

            if (nums[mid] < nums[r]) {
                r--;
            } else if (nums[mid] > nums[r]) {
                l++;
            } else {
                while (l < n - 1 && nums[l] == nums[l + 1]) {
                    l++;
                }

                while (r > 0 && nums[r] == nums[r - 1]) {
                    r--;
                }
            }
        }

        return nums[l];
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else ans += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public boolean isGood(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < n - 1) {
            if (i == n - 2) {
                map.put(n - 1, 2);
            } else {
                map.put(i + 1, 1);
            }

            i++;
        }

        i = 0;

        while (i < n) {
            int curr = nums[i];
            if (map.containsKey(curr)) {
                int c = map.get(curr);
                map.replace(curr, c - 1);
            } else {
                return false;
            }

            i++;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }

        return true;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int a = i + 1; a < n; a++) {
                if (a > i + 1 && nums[a] == nums[a - 1]) continue;
                int L = a + 1, R = n - 1;
                while (L < R) {
                    long sum = (long) nums[i] + nums[a] + nums[L] + nums[R];
                    if (sum == target) {
                        ans.add(List.of(nums[i], nums[a], nums[L], nums[R]));
                        L++;
                        R--;
                        while (nums[L] == nums[L - 1] && L < R) {
                            L++;
                        }

                        while (nums[R] == nums[R + 1] && L < R) {
                            R--;
                        }


                    } else if (sum > target) {

                        do {
                            R--;
                        } while (nums[R] == nums[R + 1] && L < R);
                    } else {

                        do {
                            L++;
                        } while (nums[L] == nums[L - 1] && L < R);
                    }
                }
            }
        }

        return ans;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sol = nums[0] + nums[1] + nums[2];

        if (nums.length == 3 || sol == target) {
            return sol;
        }

        int L, R, temp;

        for (int i = 0; i < nums.length; i++) {
            L = 0;
            R = nums.length - 1;

            while (L < R) {
                if (i == R) {
                    R--;
                }

                if (i == L) {
                    L++;
                }

                if (L >= R) {
                    break;
                }

                temp = nums[i] + nums[L] + nums[R];

                if (temp == target) {
                    return temp;
                } else if (temp < target) {
                    L++;
                } else {
                    R--;
                }

                if (Math.abs(target - temp) < Math.abs(target - sol)) {
                    sol = temp;
                }
            }
        }

        return sol;
    }

    public int maxArea(int[] height) {
        int max = 0;
        int L = 0, R = height.length - 1;

        while (L < R) {
            int tempMax = Math.min(height[L], height[R]) * (R - L);
            if (tempMax > max) {
                max = tempMax;
            }

            if (height[L] == height[R]) {
                if (height[L + 1] > height[R - 1]) {
                    R--;
                } else {
                    L++;
                }
            } else if (height[L] > height[R]) {
                R--;
            } else {
                L++;
            }
        }

        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int lo = i + 1, hi = n - 1;

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    answer.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }

        }

        return answer;
    }


    public boolean isPalindrome(String s) {
        if (s.isBlank()) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        String[] letters = s.split("");
        while (i < j) {
            if (letters[i].isBlank() || !letters[i].matches("[a-zA-Z]")) {
                i++;
            } else if (letters[j].isBlank() || !letters[j].matches("[a-zA-Z]")) {
                j--;
            } else if (!letters[i].equalsIgnoreCase(letters[j])) {
                return false;
            } else {
                j--;
                i++;
            }
        }

        return true;
    }

    public String convert2(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();

        int i = 0;
        boolean ascending = false;

        while (i < numRows) {
            list.add(new StringBuilder());
            i++;
        }

        i = 0;
        for (char c : s.toCharArray()) {
            StringBuilder sr = list.get(i);
            sr.append(c);
            list.set(i, sr);

            if (i >= numRows - 1 || i == 0) {
                ascending = !ascending;
            }

            if (ascending) {
                i++;
            } else {
                i--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder subResult : list) {
            result.append(subResult);
        }

        return result.toString();
    }

    public int[] twoSum2(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l <= r) {
            int curr = numbers[l] + numbers[r];
            if (curr == target) {
                return new int[]{l + 1, r + 1};
            } else if (curr < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{l, r};
    }


    public void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }

    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int[] ans = new int[n];

        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[j - i] = (int) Math.pow(nums[i], 2);
                i++;
            } else {
                ans[j - i] = (int) Math.pow(nums[j], 2);
                j--;
            }
        }

        return ans;
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int length = 1;
                int next = i + 1;
                while (set.contains(next)) {
                    next++;
                    length++;
                }

                ans = Math.max(ans, length);
            }
        }

        return ans;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (candidate == num) {
                count++;
            } else {
                count--;
            }

            if (count <= 0) {
                candidate = num;
                count++;
            }
        }

        return candidate;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> mergedList = new ArrayList<>();

        if (strs.length == 1) {
            List<String> stringList = new ArrayList<>();
            stringList.add(strs[0]);
            mergedList.add(stringList);
            return mergedList;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            String sortedString = new String(letters);
            if (map.containsKey(sortedString)) {
                List<String> stringList = map.get(sortedString);
                stringList.add(s);
                map.replace(sortedString, stringList);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                map.put(sortedString, stringList);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            mergedList.add(entry.getValue());
        }

        return mergedList;
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        Set<Character> box = new HashSet<>();

        int i = 0;
        int j = 0;

        while (i < 9) {

            while (j < 9) {
                Character toRow = board[i][j];
                Character toColumn = board[j][i];
                Character toBox = board[3 * (i / 3) + (j / 3)][3 * (i % 3) + (j % 3)];

                if (!toRow.equals('.')) {
                    if (!row.add(toRow)) {
                        return false;
                    }
                }

                if (!toColumn.equals('.')) {
                    if (!col.add(toColumn)) {
                        return false;
                    }
                }


                if (!toBox.equals('.')) {
                    if (!box.add(toBox)) {
                        return false;
                    }
                }

                j++;
            }

            row.clear();
            col.clear();
            box.clear();
            i++;
            j = 0;
        }

        return true;
    }

    private final Map<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }

        int x;
        int y;
        if (dp.containsKey(n - 1)) {
            x = dp.get(n - 1);
        } else {
            x = climbStairs(n - 1);
            dp.put(n - 1, x);
        }

        if (dp.containsKey(n - 2)) {
            y = dp.get(n - 2);
        } else {
            y = climbStairs(n - 2);
            dp.put(n - 2, y);
        }

        return x + y;
    }

    public int maxNumberOfBalloons(String text) {
        Map<String, Integer> map = new HashMap<>();
        map.put("b", 0);
        map.put("a", 0);
        map.put("l", 0);
        map.put("o", 0);
        map.put("n", 0);

        for (int i = 0; i < text.length(); i++) {
            String curr = String.valueOf(text.charAt(i));
            if (map.containsKey(curr)) {
                int count = map.get(curr);
                map.replace(curr, count + 1);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count;
            if (entry.getKey().equals("l") || entry.getKey().equals("o")) {
                count = entry.getValue() / 2;
            } else {
                count = entry.getValue();
            }
            ans = Math.min(ans, count);
        }

        return ans;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sWords = new int[26];

        for (char sChar : s.toCharArray()) {
            sWords[sChar - 'a']++;
        }

        for (char tChar : t.toCharArray()) {
            if (sWords[tChar - 'a'] == 0) {
                return false;
            } else {
                sWords[tChar - 'a']--;
            }
        }

        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            String curr = String.valueOf(magazine.charAt(i));
            if (map.containsKey(curr)) {
                int count = map.get(curr) + 1;
                map.replace(curr, count);
            } else {
                map.put(curr, 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            String curr = String.valueOf(ransomNote.charAt(i));
            if (!map.containsKey(curr) || map.get(curr) <= 0) {
                return false;
            } else {
                int count = map.get(curr) - 1;
                map.replace(curr, count);
            }
        }

        return true;
    }

    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < jewels.length(); i++) {
            String j = String.valueOf(jewels.charAt(i));
            map.put(j, j);
        }

        for (int i = 0; i < stones.length(); i++) {
            if (map.containsKey(String.valueOf(stones.charAt(i)))) {
                ans++;
            }
        }

        return ans;
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }

            map.put(num, num);
        }

        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String sr = strs[0];

        for (String str : strs) {
            for (int i = 0; i < sr.length(); i++) {
                if (i > str.length() - 1 || sr.charAt(i) != str.charAt(i)) {
                    sr = sr.substring(0, i);
                    break;
                }
            }
        }

        return sr;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return;
        }

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reflection
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int left = matrix[i][j];
                int right = matrix[i][(n - 1) - j];
                matrix[i][j] = right;
                matrix[i][(n - 1) - j] = left;
            }
        }
    }

    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) goingDown = !goingDown;
            i += goingDown ? 1 : -1;
        }

        StringBuilder sr = new StringBuilder();
        for (StringBuilder row : rows) {
            sr.append(row);
        }


        return sr.toString();
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        int topWall = 0;
        int bottomWall = matrix.length - 1;
        int leftWall = 0;
        int rightWall = matrix[0].length - 1;
        int s = matrix.length * matrix[0].length;


        List<Integer> res = new ArrayList<>();

        while (res.size() < s) {

            if (topWall <= bottomWall) {
                for (int i = leftWall; i < rightWall + 1; i++) {
                    res.add(matrix[topWall][i]);
                }

                topWall++;
            }

            if (rightWall >= leftWall) {
                for (int i = topWall; i < bottomWall + 1; i++) {
                    res.add(matrix[i][rightWall]);
                }

                rightWall--;
            }

            if (bottomWall >= topWall) {
                for (int i = rightWall; i > leftWall - 1; i--) {
                    res.add(matrix[bottomWall][i]);
                }

                bottomWall--;
            }

            if (leftWall <= rightWall) {
                for (int i = bottomWall; i > topWall - 1; i--) {
                    res.add(matrix[i][leftWall]);
                }

                leftWall++;
            }
        }
        return res;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (memo.containsKey(n)) return memo.get(n);
            int result = fib(n - 1) + fib(n - 2);
            memo.put(n, result);
            return result;
        }
    }

    public int hIndex(int[] citations) {
        int h = 1;
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int page_number = 0;
            int j = 0;
            while (j < n && h > page_number) {
                if (h <= citations[j]) {
                    page_number++;
                }
                j++;
            }

            if (h > page_number) {
                return h - 1;
            }

            h++;
        }

        return h - 1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1;
        int y = n - 1;
        int z = nums1.length - 1;

        while (z > x) {
            if (y < 0) {
                break;
            } else if (x < 0 || nums2[y] > nums1[x] || nums2[y] == nums1[x]) {
                nums1[z] = nums2[y];
                y--;
                z--;
            } else if (nums1[x] > nums2[y]) {
                nums1[z] = nums1[x];
                x--;
                z--;
            }
        }
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        final int n = nums.length;

        if (n == 0 || n == 1) {
            return n;
        }

        while (i < n) {
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

            if (i < n - 1) {
                nums[j] = nums[i + 1];
                j++;
                i++;
            } else {
                break;
            }
        }

        return j;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int momentary = 0;
        int j = 0;
        int i = 0;

        while (momentary < 3) {
            while (i < n) {
                if (nums[i] == momentary) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                }
                i++;
            }
            i = 0;
            momentary++;
        }
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (i < j - 2 && nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                swap(nums, nums[i + 2], i + 2);
                j--;
            } else {
                i++;
            }
        }
        return j;
    }

    public void swap(int[] nums, int num, int index) {
        int i = index;
        while (i < nums.length - 1) {
            int temp = nums[i + 1];
            nums[i + 1] = num;
            nums[i] = temp;
            i++;
        }
    }

    public int romanToInt(String s) {
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && roman.get(String.valueOf(s.charAt(i + 1))) > roman.get(String.valueOf(s.charAt(i)))) {
                ans -= roman.get(String.valueOf(s.charAt(i)));
            } else {
                ans += roman.get(String.valueOf(s.charAt(i)));
            }
        }

        return ans;
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0], max = prices[0];
        int n = prices.length;

        for (int i = 0; i < n; i++) {

            if (prices[i] < min) {
                min = prices[i];
                max = min;
            } else if (prices[i] > max) {
                max = prices[i];
            }

            if (i == n - 1 || prices[i + 1] < max) {
                ans += max - min;
                min = prices[i];
            }
        }

        return ans;
    }

    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(ans) || (Math.abs(num) == Math.abs(ans) && num > ans)) {
                ans = Math.abs(num);
            }
        }
        return ans;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            int start = nums[i];

            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start == nums[i]) {
                res.add(String.valueOf(start));
            } else {
                res.add(String.format("%d->%d", start, nums[i]));
            }
            i++;
        }

        return res;
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sr = new StringBuilder();
        int maxLength = Math.max(word1.length(), word2.length());
        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                sr.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                sr.append(word2.charAt(i));
            }
        }
        return sr.toString();
    }
}
