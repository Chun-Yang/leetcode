class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        size = len(ratings)
        minsLeft = [1] * size
        minsRight = [1] * size
        for i in range(1, size):
            if ratings[i] > ratings[i - 1]:
                minsLeft[i] = minsLeft[i - 1] + 1
        for i in reversed(range(0, size - 1)):
            if ratings[i] > ratings[i + 1]:
                minsRight[i] = minsRight[i + 1] + 1

        return sum(max(minsLeft[i], minsRight[i]) for i in range(size))
