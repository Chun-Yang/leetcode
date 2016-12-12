class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        counter = {}
        for point in points:
            x, y = point.x, point.y
            counter[(x, y)] = counter.get((x, y), 0) + 1

        uniqPoints = list(counter.keys())
        l = len(uniqPoints)
        if l <= 2:
            return len(points)

        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a

        def divide(x, y):
            fraction, residue = divmod(x, y)
            return fraction, 0 if residue == 0 else residue // gcd(residue, y)

        lines = {}
        for i in range(l):
            for j in range(i+1, l):
                x1, y1 = uniqPoints[i]
                x2, y2 = uniqPoints[j]
                if x1 == x2:
                    k = float('inf')
                    h = x1
                else:
                    k = divide((y2 - y1), (x2 - x1))
                    h = divide((y1 * x2 - y2 * x1), (x2 - x1))
                lines[(h, k)] = lines.get((h, k), set()) | set([(x1, y1), (x2, y2)])

        return max(sum(counter[point] for point in line) for line in lines.values())

# class Point(object):
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b

# points = [[0,9],[138,429],[115,359],[115,359],[-30,-102],[230,709],[-150,-686],[-135,-613],[-60,-248],[-161,-481],[207,639],[23,79],[-230,-691],[-115,-341],[92,289],[60,336],[-105,-467],[135,701],[-90,-394],[-184,-551],[150,774]]

# assert Solution().maxPoints([Point(x, y) for x, y in points]) == 12
