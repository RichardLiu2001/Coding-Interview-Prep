class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        max_profit = 0

        # Lowest price we've found so far
        lowest_so_far = float('inf')

        for price in prices:

            lowest_so_far = min(lowest_so_far, price)

            # The most profit we can get with this current price is the difference between the current price 
            # and the lowest price we've found so far before it.
            current_max_profit = price - lowest_so_far

            # Update overall max profit if the current profit is greater than any profit we found so far.
            max_profit = max(max_profit, current_max_profit)

        return max_profit