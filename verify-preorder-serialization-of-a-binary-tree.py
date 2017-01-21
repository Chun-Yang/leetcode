class Solution(object):
    def isValidSerialization(self, preorder):
        leftVisitedStack = [False]
        for value in preorder.split(','):
            if value == '#':
                while leftVisitedStack[-1]:
                    leftVisitedStack.pop()
                    if not leftVisitedStack:
                        return False
                leftVisitedStack[-1] = True
            else:
                leftVisitedStack.append(False)

        return leftVisitedStack == [True]

# Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")
