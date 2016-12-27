class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        pairs = { '(': ')', '{': '}', '[': ']' }
        unpaired = []
        for c in s:
            if c in '({[':
                unpaired.append(c)
            elif unpaired and c == pairs[unpaired[-1]]:
                unpaired.pop()
            else:
                return False
        return not unpaired
