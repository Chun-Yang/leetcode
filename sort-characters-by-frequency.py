# use counting sort
# use redix sort
# use bucket sort

# couting sort
class Solution(object):
    def frequencySort(self, s):
        R = 26
        counter = [0] * (R + 1)
        orda = ord('a')

        for c in s:
            counter[ord(c) - orda + 1] += 1
        print("counter", counter)

        for i in range(R):
            counter[i + 1] += counter[i]
        print("counter", counter)

        aux = [None] * len(s)
        for c in s:
            aux[counter[ord(c) - orda]] = c
            counter[ord(c) - orda] += 1

        return ''.join(aux)


assert Solution().frequencySort('adenfiadnfbe') == 'aabddeeffinn'
