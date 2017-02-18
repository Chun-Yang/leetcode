class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        combs = []
        comb = []

        def dfs(lefts, rights):
            if rights > lefts:
                return
            if lefts == n:
                combs.append(comb + [')'] * (n - rights))
                return

            comb.append(')')
            dfs(lefts, rights + 1)
            comb.pop()

            comb.append('(')
            dfs(lefts + 1, rights)
            comb.pop()

        dfs(0, 0)

        return [''.join(c) for c in combs]

# assert Solution().generateParenthesis(2) == ['()()', '(())']
