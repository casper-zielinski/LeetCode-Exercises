package at.fhj.msd;

public class Exercise_9 {

      private int pointer1;
      private int pointer2;
      private int pointer1_pos;
      private int pointer2_pos;
      private int left;
      private int right;
      private int area;
      private int area_temp;
      private int area_temp_2;

      public int maxArea(int[] height) {
        
            left = 0;
            right = height.length - 1;
            pointer1_pos = left;
            pointer2_pos = right;
            pointer1 = height[left];
            pointer2 = height[right];
            
            while (right > -1 && left < height.length)
            {

                  if (height[left] >= pointer1)
                  {
                        pointer1 = height[left];
                        pointer1_pos = left;
                  }
                  if (height[right] >= pointer2)
                  {
                        pointer2 = height[right];
                        pointer2_pos = right;
                  }

                  if (right >= left)
                  {
                        area_temp = Integer.min(pointer1, pointer2) * (pointer2_pos - pointer1_pos);
                        area_temp_2 = Integer.min(height[left], height[right]) * (right - left);
                  }
                  else
                  {
                        area_temp = Integer.min(pointer1, pointer2) * (pointer1_pos - pointer2_pos);
                        area_temp_2 = Integer.min(height[left], height[right]) * (left - right);
                  }
                  




                  left++;
                  right--;

                  if (area_temp > area)
                  {
                        area = area_temp;
                  }
                  if (area_temp_2 > area)
                  {
                        area = area_temp_2;
                  }
            }

            return area;
      }
}
