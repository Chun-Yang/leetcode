class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        solutions = []
        positions = [0] * n

        def valid(index, position):
            for i in range(index):
                if positions[i] == position or index - i == abs(position - positions[i]):
                    return False
            return True

        def dfs(index):
            if index == n:
                solutions.append(positions[:])
            else:
                for position in range(n):
                    if valid(index, position):
                        positions[index] = position
                        dfs(index + 1)
        dfs(0)

        def toBoard(positions):
            return [ '.' * p + 'Q' + '.' * (n-1-p) for p in positions ]

        return [toBoard(s) for s in solutions]

# Solution().solveNQueens(2)
