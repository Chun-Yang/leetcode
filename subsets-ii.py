class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    def subsetsWithDup(self, S):
        res = [[]]
        S.sort()
        if len(S):
            res.append([S[0]])

        end = 1
        for i in range(1, len(S)):
            l = len(res)
            if S[i] != S[i - 1]:
                end = l
            for j in range(l - end, l):
                res.append(res[j] + [S[i]])
        return res


# print("Solution().subsetsWithDup([1,2,3])", Solution().subsetsWithDup([1,2,3]))
# print("Solution().subsetsWithDup([1,2,2])", Solution().subsetsWithDup([1,2,2]))
# print("Solution().subsetsWithDup([1,1])", Solution().subsetsWithDup([1,1]))
