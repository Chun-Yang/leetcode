class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        cache, size1, size2 = {}, len(nums1), len(nums2)
        def find(start1, start2, k):
            if (start1, start2, k) in cache:
                return cache[(start1, start2, k)]
            if k == 0:
                return []
            # calc end1 and end2
            end1 = size1 - max(0, k - (size2 - start2) - 1)
            end2 = size2 - max(0, k - (size1 - start1) - 1)
            sub1 = nums1[start1:end1] + [-1]
            sub2 = nums2[start2:end2] + [-1]
            max1 = max(sub1)
            max2 = max(sub2)
            index1 = start1 + sub1.index(max1)
            index2 = start2 + sub2.index(max2)
            if max1 > max2:
                cache[(start1, start2, k)] = [max1] + find(index1 + 1, start2, k - 1)
            elif max1 < max2:
                cache[(start1, start2, k)] = [max2] + find(start1, index2 + 1, k - 1)
            else:
                r1 = [max1] + find(index1 + 1, start2, k - 1)
                r2 = [max2] + find(start1, index2 + 1, k - 1)
                cache[(start1, start2, k)] = max(r1, r2)

            return cache[(start1, start2, k)]

        ans = find(0, 0, k)
        return ans

# assert Solution().maxNumber([3, 4, 6, 5], [9, 1, 2, 5, 8, 3], 5) == [9,8,6,5,3]
# assert Solution().maxNumber([8, 6, 9], [1, 7, 5], 3) == [9, 7, 5]
# assert Solution().maxNumber([8, 9], [3, 9], 3) == [9,8,9]
