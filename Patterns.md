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

## Hash Map


1. Frequency Counting

Keywords: "count", "how many times", "frequency", "occurrences"

Pattern: Store element → count

```txt
Example: Find most frequent element
HashMap<Element, Integer> frequency
```

2. Fast Lookup Required

Keywords: "find", "search", "exists", "contains", "check if"

Pattern: Need O(1) access instead of O(n) iteration

```txt
Example: Two Sum - find complement
HashMap<Number, Index> seen
```

3. Pairing/Mapping

Keywords: "map to", "associate", "pair", "relationship"

Pattern: Store key → value relationships

```txt
Example: Roman to Integer
HashMap<Character, Integer> romanValues
```

4. Seen/Visited Tracking

Keywords: "duplicate", "first occurrence", "unique", "already seen"

Pattern: Track what you've encountered

```txt
Example: First unique character
HashMap<Character, Boolean> seen
```

5. Grouping/Categorization

Keywords: "group by", "anagrams", "same category"

Pattern: Group items by shared property

```txt
Example: Group anagrams
HashMap<String, List<String>> groups
```

6. Index Storage

Keywords: "position", "index", "location of"

Pattern: Store element → index/indices

```txt
Example: Two Sum
HashMap<Number, Index> numToIndex
```

7. Prefix/Cumulative Sum

Keywords: "subarray", "continuous sequence", "range sum"

Pattern: Store cumulative value → count/index

```txt
Example: Subarray sum equals K
HashMap<PrefixSum, Count> prefixSums
```