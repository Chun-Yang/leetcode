class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # preprocess, check if current board is valid
        def check(positions):
            digits = set()
            for i, j in positions:
                if board[i][j] == '.':
                    continue
                if board[i][j] in digits:
                    return False
                else:
                    digits.add(board[i][j])
            return True

        for i in range(9):
            if not check([(i, j) for j in range(9)]):
                return False
            if not check([(j, i) for j in range(9)]):
                return False
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                positions = [
                        [i + x, j + y]
                        for x in range(3)
                        for y in range(3)
                        ]
                if not check(positions):
                    return False

        return True

        # # find unfilled positions
        # unfilled = []
        # for i in range(9):
        #     for j in range(9):
        #         if board[i][j] == '.':
        #             unfilled.append((i, j))

        # def digits(i, j):
        #     options = set(list(range(1, 10)))
        #     squareI, squareJ = (i // 3) * 3, (j // 3) * 3
        #     for k in range(9):
        #         if board[k][j] in options:
        #             options.remove(board[k][j])
        #         if board[i][k] in options:
        #             options.remove(board[i][k])
        #         x, y = squareI + k // 3, squareJ + k % 3
        #         if board[x][y] in options:
        #             options.remove(board[x][y])
        #     return options

        # # backtracking
        # def dfs():
        #     if not unfilled:
        #         return True
        #     i, j = unfilled.pop()
        #     for digit in digits(i, j):
        #         board[i][j] = digit
        #         if dfs():
        #             return True
        #         board[i][j] = '.'
        #     unfilled.append((i, j))
        #     return False

        # return dfs()

# sudoku = [
#         ".........",
#         "4........",
#         "......6..",
#         "...38....",
#         ".5...6..1",
#         "8......6.",
#         ".........",
#         "..7.9....",
#         "...6....."
#         ]

# sudoku = [list(s) for s in sudoku]
# Solution().isValidSudoku(sudoku)
