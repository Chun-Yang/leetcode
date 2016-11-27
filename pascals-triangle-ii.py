class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        l = rowIndex + 1
        row = [1] * l
        for i in range(1, l):
            preserved = 1
            for j in range(1, i):
                preserved, row[j] = row[j], preserved + row[j]

        return row
