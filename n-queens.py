class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        solutions, qs = [], []
        qSet, pqSumSet, pqDifSet = set(), set(), set()

        def dfs(p):
            if p == n:
                solutions.append(qs[:])
            else:
                for q in range(n):
                    if not (q in qSet or (p + q) in pqSumSet or (p - q) in pqDifSet):
                        qs.append(q)
                        qSet.add(q)
                        pqSumSet.add(p + q)
                        pqDifSet.add(p - q)

                        dfs(p + 1)

                        qs.pop()
                        qSet.remove(q)
                        pqSumSet.remove(p + q)
                        pqDifSet.remove(p - q)

        dfs(0)

        return [
                [ '.' * p + 'Q' + '.' * (n-1-p) for p in s ]
                for s in solutions
                ]

# assert Solution().solveNQueens(2) == []
# assert Solution().solveNQueens(4) == [
#         [
#             ".Q..",
#             "...Q",
#             "Q...",
#             "..Q."],
#         [
#             "..Q.",
#             "Q...",
#             "...Q",
#             ".Q.."]
# ]
