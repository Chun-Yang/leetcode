class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        counter, positions = [0], []

        def attacked(layer, position):
            for i in range(layer):
                if positions[i] == position:
                    return True
                if abs(position - positions[i]) == (layer - i):
                    return True

            return False

        def dfs(layer):
            if layer == n:
                counter[0] += 1
                return
            for i in range(n):
                if not attacked(layer, i):
                    positions.append(i)
                    dfs(layer + 1)
                    positions.pop()

        dfs(0)

        return counter[0]
