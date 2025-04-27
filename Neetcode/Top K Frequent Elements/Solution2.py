class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count_d = defaultdict(int)
        for num in nums:
            count_d[num] += 1
        return [x[0] for x in (sorted(count_d.items(), key=lambda item: item[1], reverse=True))][:k]
      
