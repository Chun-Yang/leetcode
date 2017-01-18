class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        ans, positions = [], []

        def attacked(layer, position):
            for i in range(layer):
                if positions[i] == position:
                    return True
                if abs(position - positions[i]) == (layer - i):
                    return True

            return False

        def dfs(layer):
            if layer == n:
                ans.append(positions[:])
                return
            for i in range(n):
                if not attacked(layer, i):
                    positions.append(i)
                    dfs(layer + 1)
                    positions.pop()

        dfs(0)

        def toString(i):
            return '.' * (i) + 'Q' + '.' * (n - i - 1)

        graph = [[toString(i) for i in solution] for solution in ans]
        return graph

# Solution().solveNQueens(4)
