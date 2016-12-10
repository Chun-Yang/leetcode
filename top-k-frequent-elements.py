import collections
import itertools

class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        buckets = [[] for i in range(len(nums) + 1)]
        counter = collections.Counter(nums)
        for num, count in counter.items():
            buckets[count].append(num)

        return list(itertools.islice(itertools.chain(*reversed(buckets)), k))

# assert Solution().topKFrequent([1,2,2,3], 2) == [2,1]
