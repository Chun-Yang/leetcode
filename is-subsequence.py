import bisect

class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        indexes = { c: [] for c in 'abcdefghijklmnopqrstuvwxyz' }
        for i, c in enumerate(t):
            indexes[c].append(i)
        lo = 0
        for c in s:
            cIndex = bisect.bisect_left(indexes[c], lo)
            if cIndex == len(indexes[c]):
                return False
            lo = indexes[c][cIndex] + 1

        return True

# class Solution(object):
#     def isSubsequence(self, s, t):
#         """
#         :type s: str
#         :type t: str
#         :rtype: bool
#         """
#         sizeS, sizeT = len(s), len(t)
#         iS, iT = 0, 0
#         while True:
#             if iS == sizeS:
#                 return True
#             if iT == sizeT:
#                 return False
#             if s[iS] == t[iT]:
#                 iS += 1
#             iT += 1
