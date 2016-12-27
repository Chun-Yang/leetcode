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

        # @param array of string
        # @param target integer
        # @return ans array of string
        def dfs(num, target):
            size = len(num)
            if size == 1:
                return num if num[0] == str(target) else []

            ans = []
            # +
            for i in dfs(num[1:], target - int(num[0])):
                ans.append(num[0] + '+' + i)
            # -
            for i in dfs(['-' + num[1]] + num[2:], target - int(num[0])):
                ans.append(num[0] + i)
            # composition
            if int(num[0]) != 0:
                ans.extend(dfs([''.join(num[:2])] + num[2:], target))
            # multiplication
            # this couples with composition
            if num[1] == '0':
                for i in dfs(['0'] + num[2:], target):
                    ans.append(num[0] + '*0' + i[1:])
            else:
                for i in range(1, size):
                    left, right = num[0], ''.join(num[1:i+1])
                    exp = left + '*' + right
                    val = int(left) * int(right)
                    for j in dfs([str(val)] + num[i+1:], target):
                        ans.append(exp + j[len(str(val)):])

            return ans

        ans = dfs(list(num), target)
        return ans

# assert Solution().addOperators("123", 6) == ["1+2+3","1*2*3"]
# assert Solution().addOperators("232", 8) == ["2+3*2","2*3+2"]
# assert Solution().addOperators("121315", 160) == ['12*13-1+5']
assert Solution().addOperators("3456237490", 9191) == []
# ["3+456*23+74-9+0","3+456*23+74-9-0","34*56-2+3-7490"]
