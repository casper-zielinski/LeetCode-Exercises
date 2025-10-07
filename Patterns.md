# Patterns

## Two Pointer

**Keywords** die helfen können:

- Array ist sortiert

- "Find pair that sums to X"

- "Palindrome" checken

- "Remove duplicates"

- "Reverse" something

- Man hat zwei **Enden** die sich aufeinander zubewegen

Typische Szenarien:

```java

// Sortiertes Array + Target finden
int[] arr = [1,2,3,4,5]; target = 6
// → Two Pointer von beiden Seiten

// String von außen nach innen prüfen
"racecar" → left=0, right=6, bewegen sich zur Mitte

```

## Sliding Window

**Keywords** die helfen können:

- "Substring" oder "Subarray"

- "Maximus/Minimum in window of size k"

- "Longest/Shortest" something

- "Consecutive" elements

- Fixed window size oder variable window size

```java
// Feste Window-Größe
"Find max sum of k consecutive elements"

// Variable Window-Größe  
"Longest substring without repeating characters"
```

When working with String, just adding a element to a string takes linear time

Example:

```java

String s = "ab"
s += "c"

```

but appending to a list takes constant time. Using lists instead of strings enables a more effiecient solution with O(n) time complexity.