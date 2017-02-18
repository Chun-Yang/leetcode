# from itertools import product

class Solution(object):
    def letterCombinations(self, digits):
        if not digits:
            return []

        LETTERS = {
                '2': 'abc',
                '3': 'def',
                '4': 'ghi',
                '5': 'jkl',
                '6': 'mno',
                '7': 'pqrs',
                '8': 'tuv',
                '9': 'wxyz'
                }

        combs = ['']

        for i in range(len(digits)):
            newCombs = []
            for c in LETTERS[digits[i]]:
                for comb in combs:
                    newCombs.append(comb + c)
            combs = newCombs

        return combs


        # return [''.join(chars) for chars in product(*[LETTERS[d] for d in digits])]
