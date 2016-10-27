from bisect import bisect_left

class Solution(object):
    def maxEnvelopes(self, envelopes):
        if len(envelopes) == 0:
            return 0

        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        heights = [e[1] for e in sorted(envelopes, key=lambda x: (x[0], -x[1]))]

        ends = [heights[0]]
        lengths = [1]

        for h in heights[1:]:
            if h > ends[-1]:
                ends.append(h)
                lengths.append(lengths[-1] + 1)
            elif h < ends[0]:
                ends[0] = h
            else:
                index = bisect_left(ends, h)
                ends[index] = h

        return lengths[-1]

# assert Solution().maxEnvelopes([[5,4],[6,4],[6,7],[2,3]]) ==  3
# assert Solution().maxEnvelopes([[1,3],[3,5],[6,7],[6,8],[8,4],[9,5]]) == 3
