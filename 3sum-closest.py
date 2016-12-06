"""
- n^2 log(n)
- doubles (set): all pair combinations from input
- counts (dict): count of all numbers in input
                 this is used to determine feasibility
- sorted_nums (array): find the nearest number using binary search
                       for each pair, check feasibility
- closest_diff (number): save the closest difference
- closest_pair (pair): save the closest pair
- loop through doubles and find the closest pair
"""

class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l = len(nums)
        nums.sort()
        res = - float('inf')
        for i in range(l - 2):
            j, k = i + 1, l - 1
            while j < k:
                cur = nums[i] + nums[j] + nums[k]
                if cur == target:
                    return target
                if abs(cur - target) < abs(res - target):
                    res = cur
                if cur > target:
                    k -= 1
                else:
                    j += 1

        return res

# assert Solution().threeSumClosest([0,1,2],0) == 3
