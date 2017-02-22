class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # find unfilled positions
        unfilled = []
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    unfilled.append((i, j))

        def digits(i, j):
            options = set(['1', '2', '3', '4', '5', '6', '7', '8', '9'])
            squareI, squareJ = (i // 3) * 3, (j // 3) * 3
            for k in range(9):
                if board[k][j] in options:
                    options.remove(board[k][j])
                if board[i][k] in options:
                    options.remove(board[i][k])
                x, y = squareI + k // 3, squareJ + k % 3
                if board[x][y] in options:
                    options.remove(board[x][y])
            return options

        # backtracking
        def dfs():
            if not unfilled:
                return True
            i, j = unfilled.pop()
            for digit in digits(i, j):
                board[i][j] = digit
                if dfs():
                    return True
                board[i][j] = '.'
            unfilled.append((i, j))
            return False

        dfs()
