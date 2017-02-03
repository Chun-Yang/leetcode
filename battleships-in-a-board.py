class Solution(object):
    def countBattleships(self, board):
        """
        :type board: List[List[str]]
        :rtype: int
        """
        n = len(board)
        if n == 0:
            return 0
        m = len(board[0])
        if m == 0:
            return 0

        count = 0

        for i in range(n):
            for j in range(m):
                if board[i][j] == 'X' and \
                        (i == 0 or board[i-1][j] == '.') and \
                        (j == 0 or board[i][j-1] == '.'):
                    count += 1

        return count
