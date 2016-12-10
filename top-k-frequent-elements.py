import collections

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

        i, left, res = len(nums), k, []
        while i > 0:
            l = len(buckets[i])
            if l:
                if l < left:
                    res.extend(buckets[i])
                    left -= l
                else:
                    res.extend(buckets[i][0:left])
                    break;
            i -= 1

        return res

# assert Solution().topKFrequent([1,2,2,3], 2) == [1,2,3]
