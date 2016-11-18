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

        def allPossible(lo, hi):
            return []

        def addOps(lo, hi, target):
            print("num[lo:hi], target", num[lo:hi], target)
            res = []

            if hi - lo == 1:
                s = num[lo]
                n = int(s)
                if n == target:
                    res.append(s)
                return res

            if num[lo] == '0':
                s = '0'
                n = 0
                for r in addOps(lo + 1, hi, target):
                    res.append(s + '+' + r)
                for r in addOps(lo + 1, hi, -target):
                    res.append(s + '-' + r)
                if target == n:
                    for r in allPossible(lo + 1, hi):
                        res.append(s + '*' + r)

            for i in range(lo + 1, hi):
                s = num[lo:i]
                n = int(s)
                for r in addOps(i, hi, target - n):
                    res.append(s + '+' + r)
                for r in addOps(i, hi, n - target):
                    res.append(s + '-' + r)
                if n != 0 and target % n == 0:
                    for r in addOps(lo + 1, hi, target // n):
                        res.append(s + '*' + r)

            return res

        ops = addOps(0, len(num), target)
        return [exp  for exp in ops if exp != str(target)]


# assert Solution().addOperators("123", 6) == ["1+2+3", "1*2*3"]
assert Solution().addOperators("232", 8) == ["2*3+2","2+3*2"]
