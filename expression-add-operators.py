import re

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        if not num:
            return []

        def dfs(n):
            if len(n) == 1:
                return [n]
            exps = []
            for e in dfs(n[1:]):
                exps.append(n[0] + e)
                exps.append(n[0] + '+' + e)
                exps.append(n[0] + '-' + e)
                exps.append(n[0] + '*' + e)
            return exps

        exps = dfs(num)
        regex = re.compile('0[1-9]')
        ans = [e for e in dfs(num) if (not regex.search(e) and eval(e) == target)]
        return ans

# assert Solution().addOperators("123", 6) == ["1+2+3","1*2*3"]
# assert Solution().addOperators("232", 8) == ["2*3+2","2+3*2"]
# assert Solution().addOperators("121315", 160) == ['12*13-1+5']
# assert Solution().addOperators("3456237490", 9191) == []
