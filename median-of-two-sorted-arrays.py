class Solution(object):
    def findMedian(self, nums):
        nums_len = len(nums)
        if nums_len <= 0:
            raise Exception('nums_len should be positive')

        if nums_len % 2 == 0:
            return (nums[nums_len // 2 - 1] + nums[nums_len // 2]) / 2.0
        else:
            return nums[(nums_len) // 2]

    def shorten(self, nums, length, remove_larger):
        if remove_larger:
            return nums[:-length]
        else:
            return nums[length:]

    def isInBetweenThree(self, one, three):
        middle = len(three) // 2
        return  one <= three[middle] and one >= three[middle - 1] or \
                one >= three[middle] and one <= three[middle + 1]

    def isInBetweenTwo(self, one, two):
        middle = len(two) // 2
        return one >= two[middle - 1] and one <= two[middle]

    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        nums1_len = len(nums1)
        nums2_len = len(nums2)

        if nums1_len == 0:
            return self.findMedian(nums2)
        elif nums2_len == 0:
            return self.findMedian(nums1)
        elif nums1_len == 1 and nums2_len == 1:
            return (nums1[0] + nums2[0]) / 2.0
        else:
            nums1_median = self.findMedian(nums1)
            nums2_median = self.findMedian(nums2)
            if nums1_median == nums2_median:
                return nums1_median
            else:
                is_single = (nums1_len + nums2_len) % 2 == 1

                one_and_three = (not is_single) and ( \
                    (nums1_len == 1 and self.isInBetweenThree(nums1[0], nums2)) or \
                    (nums2_len == 1 and self.isInBetweenThree(nums2[0], nums1)) \
                    )

                if one_and_three:
                    return (nums1_median + nums2_median) / 2.0

                one_and_two = is_single and ( \
                    (nums1_len == 1 and self.isInBetweenTwo(nums1[0], nums2)) or \
                    (nums2_len == 1 and self.isInBetweenTwo(nums2[0], nums1)) \
                    )

                if one_and_two:
                    return nums1[0] if nums1_len == 1 else nums2[0]

                min_len = max(1, min(nums1_len, nums2_len) // 2)
                nums1_bigger = nums1_median > nums2_median
                return self.findMedianSortedArrays(
                        self.shorten(nums1, min_len, nums1_bigger),
                        self.shorten(nums2, min_len, not nums1_bigger)
                        )

# assert Solution().findMedianSortedArrays([1, 3], [2]) == 2
# assert Solution().findMedianSortedArrays([1, 2], [3, 4]) == 2.5
# assert Solution().findMedianSortedArrays([2], [1, 3, 4]) == 2.5
# assert Solution().findMedianSortedArrays([2, 3], [1, 4, 5]) == 3
# assert Solution().findMedianSortedArrays([3], [1, 2, 4, 5, 6]) == 3.5
assert Solution().findMedianSortedArrays([1, 2, 6], [3, 4, 5]) == 3.5
