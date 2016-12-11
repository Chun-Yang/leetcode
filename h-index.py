class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        l = len(citations)
        counter = [0] * (l + 1)
        for c in citations:
            if c > l:
                counter[l] += 1
            else:
                counter[c] += 1

        total = 0
        for i in reversed(range(l + 1)):
            total += counter[i]
            if total >= i:
                return i

        return 0
