# TODO: use quick sort
# 1. limited heap
# 2. quick sort (most robust since it can be used to find any nth in O(N))
# 3. logic for three

class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        three = []
        for num in nums:
            if num not in three:
                three.append(num)
                three = sorted(three, reverse=True)
                if len(three) == 4:
                    three.pop()

        if len(three) == 3:
            return three[-1]
        else:
            return three[0]

# assert Solution().thirdMax([1,2]) == 2
# assert Solution().thirdMax([4,6,1,2,5,6,9,10,9]) == 6
