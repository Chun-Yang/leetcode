import heapq

class Solution(object):
    def nthSuperUglyNumber(self, n, primes):
        """
        :type n: int
        :type primes: List[int]
        :rtype: int
        """
        size = len(primes)
        uglys = [1]
        pq = [(primes[j], 0, primes[j]) for j in range(size)]
        heapq.heapify(pq)
        i = 1
        while i < n:
            ugly, index, prime = heapq.heappop(pq)
            if ugly != uglys[-1]:
                uglys.append(ugly)
                i += 1
            heapq.heappush(pq, (uglys[index + 1] * prime, index + 1, prime))

        return uglys[-1]
