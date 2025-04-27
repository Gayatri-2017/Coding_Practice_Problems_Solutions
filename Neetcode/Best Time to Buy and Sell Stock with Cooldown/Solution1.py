# https://neetcode.io/problems/buy-and-sell-crypto-with-cooldown
# Best Time to Buy and Sell Stock with Cooldown

# You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.

# You may buy and sell one NeetCoin multiple times with the following restrictions:

# After you sell your NeetCoin, you cannot buy another one on the next day (i.e., there is a cooldown period of one day).
# You may only own at most one NeetCoin at a time.
# You may complete as many transactions as you like.

# Return the maximum profit you can achieve.

# Example 1:

# Input: prices = [1,3,4,0,4]

# Output: 6
# Explanation: Buy on day 0 (price = 1) and sell on day 1 (price = 3), profit = 3-1 = 2. Then buy on day 3 (price = 0) and sell on day 4 (price = 4), profit = 4-0 = 4. Total profit is 2 + 4 = 6.

# Example 2:

# Input: prices = [1]

# Output: 0
# Constraints:

# 1 <= prices.length <= 5000
# 0 <= prices[i] <= 1000

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp_tomorrow_buy, dp_tomorrow_sell = 0, 0   # Buying and selling tomorrow 
        dp_day_after_tomorrow_buy = 0 # Buying day after tomorrow (cooldown)

        for i in range(n - 1, -1, -1):
            
            # Max profit if buying today (or waiting until tomorrow)
            dp_today_buy = max(dp_tomorrow_sell - prices[i], dp_tomorrow_buy) # max(buy today or wait today)
            # Max profit if selling today (or waiting until tomorrow)
            dp_today_sell = max(dp_day_after_tomorrow_buy + prices[i], dp_tomorrow_sell) # max(sell today or wait today)

            # Swapping variables
            dp_day_after_tomorrow_buy = dp_tomorrow_buy
            dp_tomorrow_buy, dp_tomorrow_sell = dp_today_buy, dp_today_sell

        return dp_tomorrow_buy

# Time Complexity O(n)
# Space Complexity O(1)
