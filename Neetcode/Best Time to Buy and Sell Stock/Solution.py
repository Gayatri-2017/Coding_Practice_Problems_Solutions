# https://neetcode.io/problems/buy-and-sell-crypto
# You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.

# You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.

# Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.

# Example 1:

# Input: prices = [10,1,5,6,7,1]

# Output: 6
# Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.

# Example 2:

# Input: prices = [10,8,7,5,2]

# Output: 0
# Explanation: No profitable transactions can be made, thus the max profit is 0.

# Constraints:

# 1 <= prices.length <= 100
# 0 <= prices[i] <= 100


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy_tomorrow, sell_tomorrow = 0, 0
        for i in range(len(prices)-1, -1, -1):
            buy_today = max(sell_tomorrow-prices[i], buy_tomorrow)
            sell_today = max(prices[i], sell_tomorrow)
            print(i, buy_today, sell_tomorrow-prices[i], buy_tomorrow, sell_today, sell_tomorrow)
            buy_tomorrow, sell_tomorrow = buy_today, sell_today
        return buy_tomorrow
