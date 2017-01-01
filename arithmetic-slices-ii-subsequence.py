import collections

class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        ans, size = 0, len(A)

        for i in range(size - 2):
            Ai = A[i]
            for j in range(i + 1, size - 1):
                Aj = A[j]
                step = Aj - Ai
                if step != 0:
                    # (count, acc)
                    nextVals = {Aj + step: (1, 1)}
                    for k in range(j + 1, size):
                        Ak = A[k]
                        if Ak in nextVals:
                            acc = nextVals[Ak][1]
                            ans += acc
                            count = (nextVals[Ak + step][0] + 1) if (Ak + step) in nextVals else 1
                            nextVals[Ak + step] = (count, acc * count)

        counter = collections.Counter(A)
        for count in counter.values():
            if count >= 3:
                ans += 2 ** count - (1 + count + count * (count - 1) // 2)

        return ans


# Solution().numberOfArithmeticSlices([79,20,64,28,67,81,60,58,97,85,92,96,82,89,46,50,15,2,36,44,54,2,90,37,7,79,26,40,34,67,64,28,60,89,46,31,9,95,43,19,47,64,48,95,80,31,47,19,72,99,28,46,13,9,64,4,68,74,50,28,69,94,93,3,80,78,23,80,43,49,77,18,68,28,13,61,34,44,80,70,55,85,0,37,93,40,47,47,45,23,26,74,45,67,34,20,33,71,48,96])
# Solution().numberOfArithmeticSlices([2, 4, 6, 8, 10])
