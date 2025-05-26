package at.fhj.msd;

public class Exercise_3 {

      private int pointer1;
      private int pointer2; 
      private int index1;
      private int index2;
      

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

}
