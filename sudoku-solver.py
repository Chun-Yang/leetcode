class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        self.stringToArray(board)
        self.solve(board)
        self.arrayToString(board)

    def stringToArray(self, board):
        for i in range(len(board)):
            board[i] = list(board[i])

    def arrayToString(self, board):
        for i in range(len(board)):
            board[i] = ''.join(board[i])

    def solve(self, board):
        i, j = self.findNextFreeSlot(board)
        # solved
        if i == -1 and j == -1:
            return True

        for k in range(1, 10):
            if self.isValid(board, i, j, str(k)):
                board[i][j] = str(k)
                if self.solve(board):
                    return True
                # back tracking
                board[i][j] = '.'

        return False

    def findNextFreeSlot(self, board):
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    return i, j

        return -1, -1

    def isValid(self, board, i, j, k):
        # row
        for p in range(9):
            if board[i][p] == k:
                return False

        # column
        for q in range(9):
            if board[q][j] == k:
                return False

        # square
        square_col = i // 3
        square_row = j // 3
        for p in range(3 * square_col, 3 * (square_col + 1)):
            for q in range(3 * square_row, 3 * (square_row + 1)):
                if board[p][q] == k:
                    return False

        return True

# p1 = [
#     "..9748...",
#     "7........",
#     ".2.1.9...",
#     "..7...24.",
#     ".64.1.59.",
#     ".98...3..",
#     "...8.3.2.",
#     "........6",
#     "...2759.."
# ]
# s1 = [
#     "519748632",
#     "783652419",
#     "426139875",
#     "357986241",
#     "264317598",
#     "198524367",
#     "975863124",
#     "832491756",
#     "641275983"
# ]

# Solution().solveSudoku(p1)
# assert p1 == s1
