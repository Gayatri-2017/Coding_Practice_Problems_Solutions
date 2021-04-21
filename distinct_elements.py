# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")


'''
Given an array A of size N within the range [1....N].
In one move move, you can increase or decrease the value of any element by 1.

After each move, all numbers should remain in the range [1...N]

Task is to find the smallest number of moves to make all elements in the array pairwise distinct (i.e. no value can appear more than once)
'''
import collections

def solution(A):
    
    set_numbers = set(range(1, len(A)+1))
    missing_list = list(set_numbers.difference(set(A)))
    missing_list.sort()
    print(missing_list)

    # Find the duplicate elements in an array
    # duplicate_items = [item for item, count in collections.Counter(A).items() if count > 1]
    print(collections.Counter(A))

    duplicate_items = []
    for item, count in collections.Counter(A).items():
    	if(count>1):
    		while count >1:
    			duplicate_items.append(item)
    			count-=1

    duplicate_items.sort()
    print("duplicate_items = ", duplicate_items)

    # find the pairwise difference
    count_updates = 0

    for i in range(len(duplicate_items)):
        count_updates += abs(duplicate_items[i] - missing_list[i])
        # Check for max moves
        if(count_updates > int(1e9)):
            return -1

    
    return count_updates

print(solution([5, 5, 5, 5, 5]))
print(solution([6,2,3,5,6,3,6]))
