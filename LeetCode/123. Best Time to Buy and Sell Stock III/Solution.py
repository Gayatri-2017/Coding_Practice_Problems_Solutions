# You are given an array prices where prices[i] is the price of a given stock on the ith day.

# Find the maximum profit you can achieve. You may complete at most two transactions.

# Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

# Example 1:

# Input: prices = [3,3,5,0,0,3,1,4]
# Output: 6
# Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
# Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
# Example 2:

# Input: prices = [1,2,3,4,5]
# Output: 4
# Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
# Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
# Example 3:

# Input: prices = [7,6,4,3,1]
# Output: 0
# Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

# Constraints:

# 1 <= prices.length <= 105
# 0 <= prices[i] <= 105


# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        # Time: O(n) 
        # Space: O(n) - Two lists
      
        n = len(prices)
        left = [0]*n
        right = [0]*n

        # Left pass
        min_price = prices[0]
        for i in range(1, n):
            min_price = min(min_price, prices[i])
            left[i] = max(left[i-1], prices[i] - min_price)

        # Right pass
        max_price = prices[-1]
        for i in range(n-2, -1, -1):
            max_price = max(max_price, prices[i])
            right[i] = max(right[i+1], max_price - prices[i])

        # Combine
        max_profit = 0
        for i in range(n):
            max_profit = max(max_profit, left[i] + right[i])

        return max_profit

        # Time: O(n) 
        # Space: O(1) - Four variables

        # buy1, buy2 = float('inf'), float('inf')
        # sell1, sell2 = 0, 0

        # for price in prices:
        #     buy1 = min(price, buy1)
        #     sell1 = max(sell1, price-buy1)

        #     buy2 = min(buy2, price-sell1)
        #     sell2 = max(sell2, price-buy2)
        
        # return sell2
