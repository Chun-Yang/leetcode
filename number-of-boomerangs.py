class Solution(object):
    def numberOfBoomerangs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        l = len(points)
        hashArray = [{} for i in range(l)]
        for i in range(l):
            for j in range(i + 1, l):
                dist = (points[i][0] - points[j][0]) ** 2 + (points[i][1] - points[j][1]) ** 2
                if dist in hashArray[i]:
                    hashArray[i][dist] += 1
                else:
                    hashArray[i][dist] = 1

                if dist in hashArray[j]:
                    hashArray[j][dist] += 1
                else:
                    hashArray[j][dist] = 1

        count = 0
        for h in hashArray:
            for key, value in h.items():
                count += value * (value - 1)

        return count
