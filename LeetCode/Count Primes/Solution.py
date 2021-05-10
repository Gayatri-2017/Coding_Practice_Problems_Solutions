# https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3738/
# https://leetcode.com/problems/count-primes/
# Facing TLE issues for n = 5000000

class Solution:
    
    def checkPrime(self, primes_list, number):
        
        sq_root = sqrt(number)
        for prime in primes_list:
            if(prime>sq_root):
                break
                
            if number%prime == 0:
                return False
            
        return True
    
    def countPrimes(self, n: int) -> int:
        primes_list = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37]
        
        for number in range(39, n, 2):
            if(self.checkPrime(primes_list, number) == True):
                primes_list.append(number)
        
        count = len([prime for prime in primes_list if prime<n])
        
        return count
        
