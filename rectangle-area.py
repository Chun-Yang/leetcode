class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        areaA = (C - A) * (D - B)
        areaB = (G - E) * (H - F)
        xDiff = max(0, min(C, G) - max(A, E))
        yDiff = max(0, min(D, H) - max(B, F))
        overlap = xDiff * yDiff
        res = areaA + areaB - overlap
        return res

# assert Solution().computeArea(0,0,5,5,0,0,5,5) == 25
# assert Solution().computeArea(0,0,6,5,0,0,5,5) == 30
