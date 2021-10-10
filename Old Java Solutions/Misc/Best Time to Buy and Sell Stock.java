class Solution {
    public int maxProfit(int[] prices) {
       
       int largestProfit = 0;
       int low = Integer.MAX_VALUE;

       for (int i = 0; i < prices.length; i ++) {
    		int price = prices[i];
    		if (price < low) {
    			low = price;
    		}
    		int currentProfit = price - low; 
    		largestProfit = Math.max(largestProfit, currentProfit);

       } 
       return largestProfit;
    }
}