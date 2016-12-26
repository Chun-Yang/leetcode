import re

class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        p = re.compile('([a-zA-Z]+) *$').search(s)
        return len(p.group(1)) if p else 0
