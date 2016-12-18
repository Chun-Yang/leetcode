class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        needles = {}
        counts = {}
        left = set()
        for c in t:
            if c in counts:
                counts[c] += 1
            else:
                counts[c] = 1
                needles[c] = 0
                left.add(c)

        minStart = 0
        minEnd = 0
        start = 0

        hasWindow = False
        cNeed = None

        for i in range(len(s)):
            # move end
            cEnd = s[i]
            if cEnd in needles:
                # keep adding to needles until we find a window
                needles[cEnd] += 1
                if not hasWindow:
                    if (cEnd in left) and (needles[cEnd] >= counts[cEnd]):
                        left.remove(cEnd)
                    if len(left) == 0:
                        hasWindow = True
                        minEnd = i
                        cNeed = cEnd
                # try to move start
                if hasWindow and cEnd == cNeed:
                    for j in range(start, i + 1):
                        cStart = s[j]
                        if cStart in needles:
                            if needles[cStart] > counts[cStart]:
                                needles[cStart] -= 1
                            # can not move start or minStart
                            else:
                                cNeed = cStart
                                break

                        start += 1
                        # check if the new start and end is better
                        if i - start < minEnd - minStart:
                            minStart = start
                            minEnd = i

        if hasWindow:
            return s[minStart:(minEnd + 1)]
        else:
            return ''

assert Solution().minWindow("ADOBECODEBANC", "ABC") == "BANC"
assert Solution().minWindow("a", "aa") == ""
assert Solution().minWindow("a", "a") == "a"

# x = Solution().minWindow(s,t)
