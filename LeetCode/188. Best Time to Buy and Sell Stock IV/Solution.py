# You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

# Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

# Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

# Example 1:

# Input: k = 2, prices = [2,4,1]
# Output: 2
# Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
# Example 2:

# Input: k = 2, prices = [3,2,6,5,0,3]
# Output: 7
# Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

# Constraints:

# 1 <= k <= 100
# 1 <= prices.length <= 1000
# 0 <= prices[i] <= 1000

# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        num_days = len(prices)
        dp = [[0]*num_days for i in range(k+1)]

        for t in range(1, k+1):
            best_buy_balance = -prices[0]
            for day in range(1, num_days):
                dp[t][day] = max(dp[t][day-1], prices[day]+best_buy_balance)
                best_buy_balance = max(best_buy_balance, dp[t-1][day]-prices[day])

        return dp[-1][-1]
