class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        longNums, shortNums = (nums1, nums2) if len(nums1) > len(nums2) else (nums2, nums1)
        counter = collections.Counter(shortNums)
        res = []
        for num in longNums:
            if not counter:
                return res
            if num in counter:
                if counter[num] == 1:
                    del counter[num]
                else:
                    counter[num] -= 1
                res.append(num)

        return res
