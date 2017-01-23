class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        left, right = -float('inf'), -float('inf')
        count = 0
        for l, r in sorted(points):
            if l > right:
                count += 1
                left, right = l, r
            else:
                left, right = l, min(right, r)

        return count
