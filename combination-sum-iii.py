class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        res = []

        # build array from left to right
        # existing is the array already constructed,
        # i is the index which we will consider
        def add(existing, i, rest):
            minForPrev = existing[i - 1] + 1
            maxForPrev = 10 - k + i # 9 - ( k - 1 - i )

            # dealing with the last digit
            if i == k - 1:
                if rest >= minForPrev and rest <= maxForPrev:
                    existing[i] = rest
                    res.append(list(existing))
                return

            restCount = (k - i - 1)
            # rest - ( 9 + (9 - (restCount - 1)) ) * restCount // 2
            minForRest = rest - ( 19 - restCount ) * restCount // 2
            minNum = max(minForPrev, minForRest)
            # rest - ( minNum + 1 + (minNum + restCount) ) * restCount // 2
            maxForRest = rest - ( minNum * 2 + 1 + restCount ) * restCount // 2
            maxNum = min(maxForPrev, maxForRest)

            for num in range(minNum, maxNum + 1):
                existing[i] = num
                add(existing, i + 1, rest - num)

        add([0] * k, 0, n)
        return res

# assert Solution().combinationSum3(2, 4) == [[1, 3]]
# assert Solution().combinationSum3(3, 7) == [[1, 2, 4]]
# assert Solution().combinationSum3(2, 6) == [[1, 5], [2, 4]]
