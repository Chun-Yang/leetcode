class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        slow = 0
        fast = 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break

        finder = 0
        while True:
            finder = nums[finder]
            slow = nums[slow]
            if finder == slow:
                break

        return finder


# assert Solution().findDuplicate([1,2,2,3,4]) == 2
# assert Solution().findDuplicate([1,3,4,2,2]) == 2
