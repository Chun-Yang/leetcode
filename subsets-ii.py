from itertools import chain
from collections import Counter

class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        counter = Counter(nums)
        counts = [[num, counter[num]] for num in counter]
        l = len(counts)
        res = []

        def mutate(i):
            if i == l:
                item = sum([[num] * count for num, count in counts], [])
                res.append(item)
                return

            num, count = counts[i]
            for j in range(count + 1):
                counts[i][1] = j
                mutate(i + 1)

        mutate(0)

        return res
