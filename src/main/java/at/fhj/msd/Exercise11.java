package at.fhj.msd;

public class Exercise11 {

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = prices[0];
        int maxProf = sell - buy;

        for (int price : prices) {
            if (price < buy) {
                buy = price;
                sell = price;
                if ((sell - buy) > maxProf) {
                    maxProf = sell - buy;
                }
            }
            if (price > sell) {
                sell = price;
                if ((sell - buy) > maxProf) {
                    maxProf = sell - buy;
                }
            }
        }

        return maxProf;
    }
}
