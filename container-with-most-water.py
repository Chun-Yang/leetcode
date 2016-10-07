class Solution(object):
    def area(self, height, left, right):
        return min(height[left], height[right]) * (right - left)

    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left = 0
        right = len(height) - 1
        max_left = 0
        max_right = len(height) - 1
        max_area = self.area(height, max_left, max_right)

        while (left < right):
            # move the one that is smaller
            if height[left] > height[right]:
                if height[right - 1] > height[max_right]:
                    max_right = right - 1
                    max_area = max(max_area, self.area(height, max_left, max_right))
                right -= 1
            else:
                if height[left + 1] > height[max_left]:
                    max_left = left + 1
                    max_area = max(max_area, self.area(height, max_left, max_right))
                left += 1

        return max_area
