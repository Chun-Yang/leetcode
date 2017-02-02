class Solution(object):
    def magicalString(self, n):
        """
        :type n: int
        :rtype: int
        """
        nums = [1]
        slow = 0
        while len(nums) < n:
            count = nums[slow]
            if count == 2:
                nums.append(nums[-1])
            num = 1 if nums[-1] == 2 else 2
            nums.append(num)
            slow += 1

        return nums[:n].count(1)

# Solution().magicalString(3)
