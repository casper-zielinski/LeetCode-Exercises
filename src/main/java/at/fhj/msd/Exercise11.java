package at.fhj.msd;

/**
 * Exercise 11: Best Time to Buy and Sell Stock
 * Given an array where the ith element is the price of a stock on day i,
 * find the maximum profit from buying and selling one share of the stock.
 * You must buy before you sell.
 */
public class Exercise11 {

    /**
     * Calculates the maximum profit from a single buy-sell transaction.
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param prices array of stock prices
     * @return maximum profit achievable
     */
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = prices[0];
        int maxProf = sell - buy;

        for (int price : prices) {
            // If we find a lower price, reset buy and sell
            if (price < buy) {
                buy = price;
                sell = price;
                if ((sell - buy) > maxProf) {
                    maxProf = sell - buy;
                }
            }
            // If price is higher than current sell, update sell and profit
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
