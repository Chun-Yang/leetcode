class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        pairs = { '(': ')', '{': '}', '[': ']' }
        lefts = []
        for c in s:
            if c in '({[':
                lefts.append(c)
            elif lefts and pairs[lefts[-1]] == c:
                lefts.pop()
            else:
                return False

        return not lefts
