class Solution(object):
    def maxRotateFunction(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        l = len(A)
        if l == 0:
            return 0

        prefixes = [0] * ( l + 1 )
        for i in range(l):
            prefixes[i + 1] = prefixes[i] + A[i]

        appendixes = [sum(A)] * ( l + 1 )
        for i in range(l):
            appendixes[i + 1] = appendixes[i] - A[i]

        sums = [0] * l
        for i in range(1, l):
            sums[i] = (l - i) * prefixes[i] - i * appendixes[i]

        return sum(A[i] * i for i in range(l)) + max(sums)
