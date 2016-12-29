class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """


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
