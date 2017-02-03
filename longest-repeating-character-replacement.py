from collections import Counter

class Solution(object):
    def characterReplacement(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        size = len(s)

        if size == 0:
            return 0

        def findMaxLength(letter):
            maxLength = 0
            kLeft = k
            right = 0

            for left in range(size):
                if left > 0 and s[left - 1] != letter:
                    kLeft += 1

                while True:
                    if right == size:
                        return max(maxLength, right - left)
                    elif s[right] == letter:
                        right += 1
                    elif kLeft > 0:
                        kLeft -= 1
                        right += 1
                    else:
                        break

                maxLength = max(maxLength, right - left)

            return maxLength

        return max(findMaxLength(l) for l in Counter(s).keys())

Solution().characterReplacement("AABABBA", 1)
