class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        count = [0] * len(nums)
        indexedNums = [(nums[i], i) for i in range(len(nums))]

        def sort(lo, hi):
            mid = (lo + hi) // 2
            if lo == mid:
                return

            sort(lo, mid)
            sort(mid, hi)

            j = mid
            for i in range(lo, mid):
                while j < hi and indexedNums[i][0] > indexedNums[j][0]:
                    j += 1

                count[indexedNums[i][1]] += j - mid

            indexedNums[lo:hi] = sorted(indexedNums[lo:hi], key=lambda n: n[0])

        sort(0, len(nums))

        return count

# assert Solution().countSmaller([5, 2, 6, 1]) == [2, 1, 1, 0]
# assert Solution().countSmaller([26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41]) == [10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
