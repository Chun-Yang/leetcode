class Solution(object):
    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        houses = sorted(houses)
        heaters = sorted(heaters)
        heatersCount, left, right, radius = len(heaters), 0, 0, -float('inf')
        for i, house in enumerate(houses):
            leftHeater, rightHeater = heaters[left], heaters[right]
            if house < leftHeater:
                radius = max(radius, leftHeater - house)
            elif house > rightHeater:
                while house > heaters[right]:
                    if right == heatersCount - 1:
                        break
                    right += 1
                if house > heaters[right]:
                    radius = max(radius, house - heaters[right])
                else:
                    while heaters[left + 1] < house:
                        left += 1
                    radius = max(radius, min(house - heaters[left], heaters[right] - house))
            else:
                radius = max(radius, min(house - leftHeater, rightHeater - house))

        return radius
