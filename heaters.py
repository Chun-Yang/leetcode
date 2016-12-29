class Solution(object):
    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        heaters, heaterIndex, radius = sorted(heaters) + [float('inf')], 0, - float('inf')
        for house in sorted(houses):
            while abs(house - heaters[heaterIndex]) >= abs(heaters[heaterIndex + 1] - house):
                heaterIndex += 1
            radius = max(radius, abs(house - heaters[heaterIndex]))

        return radius
