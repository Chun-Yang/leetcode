class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        l = len(A)
        if l <= 2:
            return 0

        import operator as op
        def ncr(n, r):
            r = min(r, n-r)
            if r == 0: return 1
            numer = reduce(op.mul, range(n, n-r, -1))
            denom = reduce(op.mul, range(1, r+1))
            return numer//denom

        lengthsOfSlices = []
        dist = A[1] - A[0]
        start, end = 0, 2

        while end < l:
            if A[end] - A[end - 1] != dist:
                if end - start >= 3:
                    lengthsOfSlices.append(end - start)
                dist = A[end] - A[end - 1]
                start = end - 1
            end += 1

        if end - start >= 3:
            lengthsOfSlices.append(end - start)

        return sum(ncr(n - 1, 2) for n in lengthsOfSlices)

# Solution().numberOfArithmeticSlices([1,2,3,8,9,10])
