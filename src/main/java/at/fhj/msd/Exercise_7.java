package at.fhj.msd;

public class Exercise_7 {

      private int pointer1;
      private int pointer2;
      

      public int removeElement(int[] nums, int val) {
            pointer1 = 0;
            pointer2 = nums.length - 1;
            

            while (pointer2 + 1 >= pointer1)
            {

                  try { //deleting before swap

                      if (nums[pointer2] == val)
                        {
                              nums[pointer2] = -1;
                              pointer2--;
                        }

                  } catch (Exception e) {

                  }
                  


                  try {

                        if (nums[pointer1] == val) //swaping
                        {
                              int temp = nums[pointer2];
                              nums[pointer2] = nums[pointer1];
                              nums[pointer1] = temp;
                        }

                         try {

                              if (nums[pointer2] == val) //after swap deleting

                                    {
                                          nums[pointer2] = -1;
                                          pointer2--;
                                    }

                        } catch (Exception e) {

                        }

                        if (pointer1 > 0 && nums[pointer1 - 1] == val) //swap element before
                        {
                              int temp = nums[pointer2];
                              nums[pointer2] = nums[pointer1 - 1];
                              nums[pointer1 - 1] = temp;
                        }

                        try {

                              if (nums[pointer2] == val)
                              {
                                    nums[pointer2] = -1;
                                    pointer2--;
                              }

                        } catch (Exception e) {

                        }


                  } catch (Exception e) {
                        
                  }

                 

                  
                  pointer1++;
            }


            return pointer2 + 1;
      }

}
