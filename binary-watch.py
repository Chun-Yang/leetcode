class Solution(object):
    def readBinaryWatch(self, num):
        """
        :type num: int
        :rtype: List[str]
        """
        hours, minutes, digits = 4, 6, 10
        cur, ans = [0], []
        def combinations(num, digits):
            if num == 0:
                ans.append(cur[0])
                return
            for i in range(num - 1, digits):
                cur[0] |= (1 << i)
                combinations(num - 1, i)
                cur[0] &= ~(1 << i)

        combinations(num, digits)

        minutesMask = (1 << minutes) - 1
        r = []
        for i in range(len(ans)):
            h = ans[i] >> minutes
            m = ans[i] & minutesMask
            if (h < 12 and m < 60):
                r.append(str(h) + ':' + str(m).zfill(2))

        return r

# Solution().readBinaryWatch(2)
