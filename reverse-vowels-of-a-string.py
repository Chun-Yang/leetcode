class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        lo, hi, chars = 0, len(s) - 1, list(s)
        vowels = set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'])
        while (lo < hi):
            if s[lo] not in vowels:
                lo += 1
            elif s[hi] not in vowels:
                hi -= 1
            else:
                chars[lo], chars[hi] = chars[hi], chars[lo]
                lo += 1
                hi -= 1

        return ''.join(chars)
