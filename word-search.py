class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if not word:
            return True

        m = len(board)
        if m == 0:
            return False

        n = len(board[0])
        if n == 0:
            return False

        visited = [ [False for j in range(n)] for i in range(m) ]

        l = len(word)

        def search(i, j, index):
            if i < 0 or j < 0 or i >= m or j >= n:
                return False

            if visited[i][j]:
                return False

            if board[i][j] != word[index]:
                return False

            if index + 1 == l:
                return True

            visited[i][j] = True

            found = search(i - 1, j, index + 1) \
                or  search(i + 1, j, index + 1) \
                or  search(i, j - 1, index + 1) \
                or  search(i, j + 1, index + 1)

            if found:
                return True

            visited[i][j] = False
            return False


        for i in range(m):
            for j in range(n):
                if search(i, j, 0):
                    return True

        return False

# assert Solution().exist([
#     "ABCE",
#     "SFCS",
#     "ADEE"
# ], "ABCCED")
