class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        size = len(citations)
        if size == 0 or citations[-1] == 0:
            return 0

        lo, hi = 1, size + 1
        while lo < hi:
            mid = (lo + hi) // 2
            c = citations[size - mid]
            if c >= mid:
                lo = mid + 1
            else:
                hi = mid

        return lo - 1
