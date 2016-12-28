# the whole number is the max
# exp can be a single array with length size * 2 - 1

# need to deal with multiplication
class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        if not num:
            return []

        size, ans = len(num), []

        def dfs(index, exp, value, mutiplied):
            if index == size:
                if value == target:
                    ans.append(exp)
            else:
                upper = size if num[index] != '0' else index + 1
                for i in range(index, upper):
                    e = num[index:i + 1]
                    v = int(e)
                    dfs(i+1, exp + '+' + e, value + v, v)
                    dfs(i+1, exp + '-' + e, value - v, -v)
                    dfs(i+1, exp + '*' + e, value - mutiplied + v * mutiplied, v * mutiplied)

        upper = size if num[0] != '0' else 1
        for i in range(0, upper):
            e = num[:i+1]
            v = int(e)
            dfs(i+1, e, v, v)

        return ans

# assert Solution().addOperators("123", 6) == ["1+2+3","1*2*3"]
# assert Solution().addOperators("232", 8) == ["2+3*2","2*3+2"]
# assert Solution().addOperators("121315", 160) == ['12*13-1+5']
# assert Solution().addOperators("3456237490", 9191) == []
