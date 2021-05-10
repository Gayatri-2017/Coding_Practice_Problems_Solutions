# https://leetcode.com/problems/ugly-number/

# Facing TLE issues
  
class Solution:
  def isUgly(self, n: int) -> bool:
    if n<=0:
        return False
    if n == 1:
        return True

    factors = []
    sqrt_n = int(sqrt(n))
    for i in range(1, sqrt_n+1):
        if n%i == 0:
            print("i = ", i)
            factors.append(i)


    for factor in factors:
        if factor%2 != 0 and factor%3 != 0 and factor%5 != 0:
            return False

    return True
        
