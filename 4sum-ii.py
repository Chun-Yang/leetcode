class Solution(object):
    def fourSumCount(self, A, B, C, D):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :type D: List[int]
        :rtype: int
        """
        l = len(A)
        abDict = {}
        cdDict = {}
        for i in range(l):
            for j in range(l):
                abSum = A[i] + B[j]
                if abSum in abDict:
                    abDict[abSum] += 1
                else:
                    abDict[abSum] = 1
                cdSum = C[i] + D[j]
                if cdSum in cdDict:
                    cdDict[cdSum] += 1
                else:
                    cdDict[cdSum] = 1

        count = 0
        for abSum in abDict:
            if -abSum in cdDict:
                count += abDict[abSum] * cdDict[-abSum]

        return count
