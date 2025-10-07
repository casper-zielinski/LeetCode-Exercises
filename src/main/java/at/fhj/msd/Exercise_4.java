package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 4: Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log(m+n)).
 * This implementation uses O(m+n) approach by merging the arrays.
 */
public class Exercise_4 {

      private int pointer1;
      private int pointer2;
      private int index1;
      private int index2;

      /**
       * Finds the median of two sorted arrays.
       * Time complexity: O(m+n)
       *
       * @param nums1 first sorted array
       * @param nums2 second sorted array
       * @return the median value
       */
      public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            List<Integer> SortedList = AddToSortedList(nums1, nums2);

            // If even number of elements, average the two middle elements
            if (SortedList.size() % 2 == 0)
            {
                  double BeforeMedian = SortedList.get(SortedList.size()/2-1);
                  double AfterMedian = SortedList.get(SortedList.size()/2);
                  return (BeforeMedian + AfterMedian) / 2;
            }
            // If odd number of elements, return the middle element
            else{
                  int Median = SortedList.size()/2;
                  return SortedList.get(Median);
            }

      }

      /**
       * Merges two sorted arrays into a single sorted list using two pointers.
       *
       * @param nums1 first sorted array
       * @param nums2 second sorted array
       * @return merged sorted list
       */
      public List<Integer> AddToSortedList(int[] nums1, int[] nums2)
      {
            List<Integer> SortedList = new ArrayList<>();
            index1 = 0;
            index2 = 0;

            while (true) {
             try {
                // Get current values from both arrays
                pointer1 = setPointer1(nums1, nums2);
                pointer2 = setPointer2(nums1, nums2);

                // If both pointers have the same value
                if (pointer1 == pointer2)
                {

                  if (index1 < nums1.length && index2 < nums2.length)
                  {
                        SortedList.add(pointer2);
                  }


                  index1++;
                  index2++;
                }
                // Move pointer2 if its value is smaller
                else if (checkMin(pointer1, pointer2) == pointer2)
                {
                  index2++;
                }
                // Move pointer1 if its value is smaller
                else if (checkMin(pointer1, pointer2) == pointer1)
                {
                  index1++;
                }
                // Add the minimum value to the result
                SortedList.add(checkMin(pointer1, pointer2));

             }catch (IndexOutOfBoundsException e) {
                  // All elements have been processed
                  return SortedList;
            }
      }

      }

      /**
       * Returns the minimum of two values.
       *
       * @param pointer1 first value
       * @param pointer2 second value
       * @return the smaller value
       */
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

      /**
       * Gets the current value for pointer1, falls back to nums2 if nums1 is exhausted.
       *
       * @param nums1 first array
       * @param nums2 second array
       * @return current value for pointer1
       */
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

      /**
       * Gets the current value for pointer2, falls back to nums1 if nums2 is exhausted.
       *
       * @param nums1 first array
       * @param nums2 second array
       * @return current value for pointer2
       */
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
