class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        qSet, pqSumSet, pqDifSet = set(), set(), set()

        def dfs(p):
            if p == n:
                return 1
            else:
                count = 0
                for q in range(n):
                    if not (q in qSet or (p + q) in pqSumSet or (p - q) in pqDifSet):
                        qSet.add(q)
                        pqSumSet.add(p + q)
                        pqDifSet.add(p - q)

                        count += dfs(p + 1)

                        qSet.remove(q)
                        pqSumSet.remove(p + q)
                        pqDifSet.remove(p - q)
                return count

        return dfs(0)

# assert Solution().totalNQueens(2) == 0
# assert Solution().totalNQueens(4) == 2
