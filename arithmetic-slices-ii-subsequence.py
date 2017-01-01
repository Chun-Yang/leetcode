class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        size = len(A)
        sequences = [ {} for _ in range(size) ]
        total = 0
        for i in range(size):
            for j in range(i):
                step = A[i] - A[j]
                sequences[i][step] = sequences[i].get(step, 0) + 1
                if step in sequences[j]:
                    total += sequences[j][step]
                    # prepare for the next match
                    sequences[i][step] += sequences[j][step]

        return total
