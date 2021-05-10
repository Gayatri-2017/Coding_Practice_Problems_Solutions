# https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3738/
# https://leetcode.com/problems/count-primes/

# Count the number of prime numbers less than a non-negative number, n.

class Solution:
    
    def countPrimes(self, n: int) -> int:
        
        is_composite = [False for prime in range(n)]
        
        if(len(is_composite)>=2):
            is_composite[0], is_composite[1] = True, True
        elif(len(is_composite)==1):
            is_composite[0] = True
            
        for prime in range(2, len(is_composite)):
            
            if is_composite[prime] == False:
                for i in range(prime*prime, len(is_composite), prime):
                    is_composite[i] = True
            
        count = len([prime for prime in is_composite if prime==False])
        
        return count
        
