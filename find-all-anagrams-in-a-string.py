class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """

        counter = {}
        for c in p:
            if c in counter:
                counter[c] += 1
            else:
                counter[c] = 1

        res = []

        ls, lp = len(s), len(p)

        for i in range(ls):
            if i - lp >= 0:
                lastC = s[i - lp]
                if lastC in counter:
                    if counter[lastC] == -1:
                        del counter[lastC]
                    else:
                        counter[lastC] += 1
                else:
                    counter[lastC] = 1

            curC = s[i]
            if curC in counter:
                if counter[curC] == 1:
                    del counter[curC]
                else:
                    counter[curC] -= 1
            else:
                counter[curC] = -1

            if not counter:
                res.append(i - lp + 1)

        return res

# assert Solution().findAnagrams("cbaebabacd", "abc") == [0, 6]
