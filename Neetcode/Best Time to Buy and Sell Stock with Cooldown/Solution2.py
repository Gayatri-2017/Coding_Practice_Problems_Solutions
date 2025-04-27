class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = {}
        
        @cache
        def dfs(i: int, state: str) -> int:
            print(i, state) 
            if i >= len(prices):
                return 0
            
            if(i,state) in dp:
                return dp[(i, state)]
            
            match state:
                case 'buying': 
                    dp[(i, state)] = max(
                        dfs(i+1, 'selling') - prices[i],
                        dfs(i+1, 'buying')
                    )
                    return dp[(i, state)]
                case 'selling':
                    dp[(i, state)] = max(
                        dfs(i+1, 'cooldown') + prices[i],
                        dfs(i+1, 'selling')
                    )
                    return dp[(i, state)]
                case 'cooldown':
                    return dfs(i+1, 'buying')
            
        return dfs(0, 'buying')
# Time Complexity: O(n)
# Space Complexity: O(n)
