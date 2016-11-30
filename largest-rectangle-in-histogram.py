class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if not heights:
            return 0

        l = len(heights)
        left, right = [0] * l, [l] * l
        leftStack, rightStack = [0], [l-1]

        for i in range(1, l):
            if heights[i] > heights[i - 1]:
                left[i] = i
                leftStack.append(i)
            else:
                while True:
                    if len(leftStack) == 0:
                        leftStack.append(i)
                        break

                    j = leftStack[-1]
                    if heights[i] > heights[j]:
                        leftStack.append(i)
                        break
                    else:
                        left[i] = left[j]
                        leftStack.pop()

        for i in reversed(range(l - 1)):
            if heights[i] > heights[i + 1]:
                right[i] = i + 1
                rightStack.append(i)
            else:
                while True:
                    if len(rightStack) == 0:
                        rightStack.append(i)
                        break

                    j = rightStack[-1]
                    if heights[i] > heights[j]:
                        rightStack.append(i)
                        break
                    else:
                        right[i] = right[j]
                        rightStack.pop()

        # print("l", left)
        # print("r", right)
        # print("h", heights)
        area = max(heights[i] * (right[i] - left[i]) for i in range(l))

        # print("area", area)
        return area

# assert Solution().largestRectangleArea([4,2,0,3,2,4,3,4]) == 10
# assert Solution().largestRectangleArea([2,1,5,6,2,3]) == 10
