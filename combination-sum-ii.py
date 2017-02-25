class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates = sorted(candidates, reverse=True)
        combs = [set([()])] + [ set() for i in range(target) ]
        for num in candidates:
            # NOTE: the reverse is necessary since we do not want to use
            # the current value more than once for each comb
            for i in reversed(range(num, target + 1)):
                for comb in combs[i-num]:
                    combs[i].add(comb + (num,))

        return [list(comb) for comb in combs[target]]

# assert Solution().combinationSum2([1,1,2], 2) == [[2], [1,1]]
