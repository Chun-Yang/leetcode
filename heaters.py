class Solution(object):
    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        housesCount, heatersCount = len(houses), len(heaters)
        distForHouses = [float('inf')] * housesCount
        houseIndex, heaterIndex = 0, 0
        while True:
            if houseIndex == housesCount:
                return max(distForHouses)

            if heaterIndex == heatersCount:
                distForHouses[houseIndex] = houses[houseIndex] - heaters[-1]
                houseIndex += 1
            else:
                house = houses[houseIndex]
                heater = heaters[heaterIndex]
                distForHouses[houseIndex] = min(
                        abs(house - heater),
                        distForHouses[houseIndex]
                        )
                # advance the small one
                if house < heater:
                    houseIndex += 1
                else:
                    heaterIndex += 1

# assert Solution().findRadius([1,2,3], [2]) == 1
