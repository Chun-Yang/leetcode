from heapq import heappush, heappop

class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        m, n = len(nums1), len(nums2)
        if k == 0 or m == 0 or n == 0:
            return []

        front = [(nums1[0] + nums2[0], 0, 0)]
        visited = [ [False for j in range(n)] for i in range(m)]
        visited[0][0] = True
        values = []

        for i in range(k):
            value, x, y = heappop(front)
            values.append([nums1[x], nums2[y]])

            for a, b in [[x + 1, y], [x, y + 1]]:
                if a < m and b < n and not visited[a][b]:
                    heappush(front, [nums1[a] + nums2[b], a, b])
                    visited[a][b] = True

            if not front:
                break

        return values

# Solution().kSmallestPairs([1,2,4], [-1,1,2], 100)
