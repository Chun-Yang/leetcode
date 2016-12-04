from collections import Counter

class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        counter = Counter(candidates)
        counts = [[i, counter[i]] for i in counter if i <= target]

        l = len(counts)

        cache = {}
        def find(index, target):
            if (index, target) in cache:
                return cache[(index, target)]
            if index >= l:
                return []
            res = []
            num, count = counts[index]
            for i in range(count + 1):
                used = num * i
                if used < target:
                    for r in find(index + 1, target - used):
                        res.append([num] * i + r)
                elif used == target:
                    res.append([num] * i)
                else:
                    break

            cache[(index, target)] = res
            return res

        return find(0, target)

# assert Solution().combinationSum2([1,1,1,1,1], 3) == [[1,1,1]]
# assert Solution().combinationSum2([10,1,2,7,6,1,5], 8) == [[1,1,6],[1,2,5],[1,7],[2,6]]
