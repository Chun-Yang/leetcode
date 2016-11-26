class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        if sum(nums) < s:
            return 0

        j, minLen, numsSum = 0, len(nums), 0
        for i in range(len(nums)):
            numsSum += nums[i]
            while True:
                if numsSum < s:
                    break
                elif numsSum - nums[j] < s:
                    minLen = min(minLen, i - j + 1)
                    break
                else:
                    numsSum -= nums[j]
                    j += 1

        return minLen

# assert Solution().minSubArrayLen(4, [1,4,4]) == 1
# assert Solution().minSubArrayLen(5, [2,3,1,1,1,1,1]) == 2
