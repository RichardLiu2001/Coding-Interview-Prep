class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            if (price < minPrice) {

                minPrice = price;
            }

            // compare difference between current price and min price,
            // and update maxProfit accordingly.
            maxProfit = Math.max(maxProfit, price - minPrice);

        }

        return maxProfit;

    }
}