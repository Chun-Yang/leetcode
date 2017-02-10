class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        # -1 : 1 -> 0
        # 2  : 0 -> 1
        m = len(board)
        if m == 0:
            return
        n = len(board[0])
        if n == 0:
            return

        for i in range(m):
            for j in range(n):
                neighboors = []
                if i > 0:
                    neighboors.append([i - 1,j])
                if j > 0:
                    neighboors.append([i,j - 1])
                if i < m - 1:
                    neighboors.append([i + 1,j])
                if j < n - 1:
                    neighboors.append([i,j + 1])
                if i > 0 and j > 0:
                    neighboors.append([i - 1, j - 1])
                if i < m - 1 and j < n - 1:
                    neighboors.append([i + 1,j + 1])
                if i > 0 and j < n - 1:
                    neighboors.append([i - 1, j + 1])
                if i < m - 1 and j > 0:
                    neighboors.append([i + 1, j - 1])

                liveNeighboors = 0
                for x, y in neighboors:
                    if board[x][y] in [1, -1]:
                        liveNeighboors += 1

                if board[i][j] == 1:
                    if liveNeighboors not in [2, 3]:
                        board[i][j] = -1
                elif board[i][j] == 0:
                    if liveNeighboors == 3:
                        board[i][j] = 2

        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
