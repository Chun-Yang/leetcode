class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        res, start, end = [], None, None
        for num in nums + [float('inf')]:
            if start is None:
                start, end = num, num
            elif num - end == 1:
                end = num
            else:
                if start == end:
                    res.append(str(start))
                else:
                    res.append('->'.join([str(start), str(end)]))
                start, end = num, num

        return res
