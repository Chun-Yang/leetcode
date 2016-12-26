class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if not n:
            return []

        ans = []
        temp = [None] * n * 2
        def dfs(lefts, rights):
            if lefts == 0:
                temp[-rights:] = [')'] * rights
                ans.append(temp[:])
            else:
                index = 2 * n - lefts - rights
                temp[index] = '('
                dfs(lefts - 1, rights)

                if rights > lefts:
                    temp[index] = ')'
                    dfs(lefts, rights - 1)

        dfs(n, n)
        return [''.join(a) for a in ans]

# print("Solution().generateParenthesis(3)", Solution().generateParenthesis(3))
