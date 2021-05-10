# https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3737/ 
# https://leetcode.com/problems/construct-target-array-with-multiple-sums/
# Faces Time Exceeded error for input: [1,1000000000]
import heapq

class Solution:
    
    def isPossible(self, target):

        isAllOne = False
        target = [num*-1 for num in target]

        heapq.heapify(target)

        while(target[-1] <= -1):

            # print(target)
            if target == [-1]*len(target):
                isAllOne = True
                break

            largest = -target[0]
            largest_index = target.index(-largest)
            # print(largest, largest_index)
            rem_sum = -(sum(target)) - largest
            
            heapq.heapreplace(target, -largest + rem_sum)
            # print(target)

        return isAllOne
            
        
    
