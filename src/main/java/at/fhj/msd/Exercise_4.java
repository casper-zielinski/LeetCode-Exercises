package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;

public class Exercise_4 {

      private int pointer1;
      private int pointer2; 
      private int index1;
      private int index2;
      
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
