class Solution(object):
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        size = len(s1)
        if size == 0:
            return True

        cache = [ [ [ False for offset in range(size) ] for i2 in range(size) ] for i1 in range(size) ]

        for i1 in range(size):
            for i2 in range(size):
                cache[i1][i2][0] = s1[i1] == s2[i2]

        for offset in range(1, size):
            for i1 in range(size - offset):
                for i2 in range(size - offset):
                    for k in range(offset):
                        flag = (
                                cache[i1][i2][k] and \
                                cache[i1+k+1][i2+k+1][offset-1-k] \
                                ) or (
                                cache[i1][i2+k+1][offset-1-k] and \
                                cache[i1+offset-k][i2][k] \
                                )
                        if flag:
                            cache[i1][i2][offset] = True
                            break

        # for offset in range(size):
        #     for i1 in range(size - offset):
        #         for i2 in range(size - offset):
        #             print("i1, i2, offset, cache[i1][i2][offest]", i1, i2, offset, cache[i1][i2][offset])

        return cache[0][0][-1]

# from collections import Counter
# class Solution(object):
#     def isScramble(self, s1, s2):
#         if s1 == s2: return True
#         if Counter(s1) != Counter(s2): return False # early backtracking
#         for i in range(1,len(s1)):
#             if (self.isScramble(s1[:i], s2[:i]) and self.isScramble(s1[i:], s2[i:])): return True
#             if (self.isScramble(s1[:i], s2[-(i):]) and self.isScramble(s1[i:], s2[:-(i)])): return True
#         return False

# import random
# base = 'abcdefghijklmnopqrstuvwxyz'
# s1 = ''.join(''.join(random.sample(base, len(base))) for i in range(5))
# s2 = ''.join(''.join(random.sample(base, len(base))) for i in range(5))
# print("res: ", Solution().isScramble(s1, s2))
