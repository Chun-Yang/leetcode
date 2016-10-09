class Solution(object):
    LETTERS = {
            '2': ['a', 'b', 'c'],
            '3': ['d', 'e', 'f'],
            '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'],
            '6': ['m', 'n', 'o'],
            '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'],
            '9': ['w', 'x', 'y', 'z']
            }
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        digits_len = len(digits)
        if digits_len == 0:
            return []
        elif digits_len == 1:
            return Solution.LETTERS[digits]
        else:
            combs = []
            for i in Solution.LETTERS[digits[0]]:
                for j in self.letterCombinations(digits[1:]):
                    combs.append(i + j)

        return combs

# assert len(Solution().letterCombinations('22')) == 9
