class Solution(object):
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        tokens, begin, isNum = [], 0, True
        for i in range(len(input)):
            if input[i] in '+-*':
                tokens.append(int(input[begin:i]))
                tokens.append(input[i])
                begin = i + 1
        tokens.append(int(input[begin:]))

        size = len(tokens)

        cache = [ [None for start in range(size + 1)] for end in range(size + 1) ]
        def calc(start, end):
            if cache[start][end] is not None:
                return cache[start][end]

            if start + 1 == end:
                cache[start][end] = [tokens[start]]
                return cache[start][end]
            ans = []
            for i in range(start + 1, end, 2):
                left = calc(start, i)
                right = calc(i + 1, end)
                op = tokens[i]
                for j in left:
                    for k in right:
                        if op == '+':
                            ans.append(j + k)
                        elif op == '-':
                            ans.append(j - k)
                        else:
                            ans.append(j * k)

            cache[start][end] = ans
            return cache[start][end]

        return calc(0, size)

# print("Solution().diffWaysToCompute('2-1-1')", Solution().diffWaysToCompute('2-1-1'))
