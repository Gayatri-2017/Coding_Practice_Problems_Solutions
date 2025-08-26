# You are given an array prices where prices[i] is the price of a given stock on the ith day.

# You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

# Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

# Example 1:

# Input: prices = [7,1,5,3,6,4]
# Output: 5
# Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
# Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
# Example 2:

# Input: prices = [7,6,4,3,1]
# Output: 0
# Explanation: In this case, no transactions are done and the max profit = 0.

# Constraints:

# 1 <= prices.length <= 105
# 0 <= prices[i] <= 104

# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # O(n) - complexity
        # Extra space - O(1)
        cost_price = prices[0]
        profit = 0
        for curr in prices[1:]:
            if cost_price > curr:
                # Let's buy stock at this rate and check in future if it is more profitable. 
                # Since curr is less than the previous cost_price, there's no point in selling at this cost.
                cost_price = curr
            else:
                # Update profit if it is profitable to sell at curr price
                profit = max(curr - cost_price, profit)
        
        return profit


        # O(n^2) - complexity
        # Extra space - O(1)
        # max_prof = 0 
        # for i in range(len(prices)-1):
        #     curr_price = prices[i]
        #     print(i)
        #     max_prof = max(max([max(prices[j]-curr_price, 0) for j in range(i+1, len(prices))]), max_prof)
        #     print(max_prof)
        # return max_prof
    
    # O(n^2) - complexity
    # Extra space - O(n)
    # Brute Force
    # Time limit exceeded
    # def maxProfit(self, prices: List[int]) -> int:
    #     max_prof = [0]*len(prices)
    #     for i in range(len(prices)-1):
    #         curr_price = prices[i]
    #         print(i)
    #         max_prof[i] = max([max(prices[j]-curr_price, 0) for j in range(i+1, len(prices))])
    #     print(max_prof)
    #     return max(max_prof)

