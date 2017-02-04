class Solution(object):
    def findMaximizedCapital(self, k, W, Profits, Capital):
        """
        :type k: int
        :type W: int
        :type Profits: List[int]
        :type Capital: List[int]
        :rtype: int
        """
        size = len(Profits)
        pairs = sorted(
                [(Profits[i], Capital[i]) for i in range(size)],
                key=lambda pair: (-pair[0], pair[1])
                )

        for i in range(k):
            j = 0

            while j < size and pairs[j][1] > W:
                j += 1
            if j == size:
                return W

            W += pairs[j][0]
            del pairs[j]
            size -= 1

        return W
