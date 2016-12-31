class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        m = len(dungeon)
        n = len(dungeon[0])
        healthes = [[None for i in range(n)] for j in range(m)]

        def calcHealth(h, d):
            if d >= 0:
                return max(1, h - d)
            else:
                return h - d

        healthes[-1][-1] = calcHealth(1, dungeon[-1][-1])

        for i in reversed(range(m - 1)):
            healthes[i][-1] = calcHealth(healthes[i+1][-1], dungeon[i][-1])
        for j in reversed(range(n - 1)):
            healthes[-1][j] = calcHealth(healthes[-1][j+1], dungeon[-1][j])

        for i in reversed(range(m - 1)):
            for j in reversed(range(n - 1)):
                healthes[i][j] = min(
                        calcHealth(healthes[i+1][j], dungeon[i][j]),
                        calcHealth(healthes[i][j+1], dungeon[i][j])
                        )

        return healthes[0][0]
