# v1.0
# https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/28
# class Solution(object):
#     def findMedianSortedArrays(self, nums1, nums2):
#         """
#         :type nums1: List[int]
#         :type nums2: List[int]
#         :rtype: float
#         """
#         n1, n2 = len(nums1), len(nums2)

#         # make sure n1 <= n2
#         if n1 > n2:
#             nums1, nums2, n1, n2 = nums2, nums1, n2, n1

#         if n1 == 0:
#             return (nums2[(n2 - 1) // 2] + nums2[n2 // 2]) * 0.5

#         lo, hi = 0, n1 * 2
#         while lo <= hi:
#             c1 = (lo + hi) // 2
#             c2 = n1 + n2 - c1

#             l1 = nums1[(c1 - 1) // 2] if c1 > 0 else - float('inf')
#             r1 = nums1[c1 // 2] if c1 < n1 * 2 else float('inf')

#             l2 = nums2[(c2 - 1) // 2] if c2 > 0 else - float('inf')
#             r2 = nums2[c2 // 2] if c2 < n2 * 2 else float('inf')

#             if l1 > r2:
#                 hi = c1 - 1
#             elif l2 > r1:
#                 lo = c1 + 1
#             else:
#                 return (max(l1, l2) + min(r1, r2)) * 0.5

#         raise AssertionError

# v2.0
# kth smalliest
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            n1, n2, nums1, nums2 = n2, n1, nums2, nums1

        # k is 0 based
        def kthMin(k):
            lo, hi = max(0, k - n2), min(n1, k + 1)
            while lo <= hi:
                c1 = (lo + hi) // 2
                c2 = k - c1
                l1 = - float('inf') if c1 == 0  else nums1[c1 - 1]
                r1 = float('inf')   if c1 == n1 else nums1[c1]
                l2 = - float('inf') if c2 == 0  else nums2[c2 - 1]
                r2 = float('inf')   if c2 == n2 else nums2[c2]
                if l1 > r2:
                    hi = c1 - 1
                elif l2 > r1:
                    lo = c1 + 1
                else:
                    return min(r1, r2)
            raise ValueError

        left = kthMin((n1 + n2) // 2)
        right = kthMin((n1 + n2 - 1) // 2)
        return (left + right) / 2.0

# assert Solution().findMedianSortedArrays([1], [2]) == 1.5
# assert Solution().findMedianSortedArrays([1, 2], [3, 4]) == 2.5
# assert Solution().findMedianSortedArrays([1, 2, 3, 4], [4]) == 3
# assert Solution().findMedianSortedArrays([2], [1,3,4]) == 2.5
