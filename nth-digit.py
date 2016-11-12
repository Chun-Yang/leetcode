class Solution(object):
    # def findNthDigit(self, n):
    #     residue = n
    #     num = 0
    #     while True:
    #         numS = str(num)
    #         if residue < len(numS):
    #             print("residue", residue)
    #             print("numS", numS)
    #             return int(numS[residue])
    #         else:
    #             residue -= len(numS)
    #             num += 1

    def findNthDigit(self, n):
        """
        :type n: int
        :rtype: int
        """
        index = 0
        number = 1
        residue = n - 1

        while True:
            index += 1
            countForDigit = index * 9 * (10 ** (index - 1))
            if residue - countForDigit < 0:
                break

            number = 10 ** index
            residue -= countForDigit

        number += residue // index
        number = str(number)
        digit = residue % index

        return int(number[digit])

# assert Solution().findNthDigit(3) == 3
# assert Solution().findNthDigit(9) == 9
# assert Solution().findNthDigit(10) == 1
# assert Solution().findNthDigit(11) == 0
# assert Solution().findNthDigit(210) == 6 # 106, 2
# assert Solution().findNthDigit(211) == 1 # 107, 0
# assert Solution().findNthDigit(1000) == 3 # 370, 0
