from bisect import insort
class Solution(object):
    def medianSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[float]
        """
        size = len(nums)
        nums.append(0)
        window = sorted(nums[:k])
        medians = []
        left = ~(k // 2)
        right = k // 2

        for i in range(size - k + 1):
            medians.append((window[left] + window[right]) / 2.0)
            # add and remove
            insort(window, nums[i + k])
            window.remove(nums[i])

        nums.pop()
        return medians

# Solution().medianSlidingWindow([1,3,-1,-3,5,3,6,7], 3)
