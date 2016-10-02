'''
- is_open (bool): wether the trace is open or not
- if current is open, any step further is safe, check if next is closed
- if current is open, next is closed, check two lines
- if current is closed, check one line
'''

from collections import deque

class Solution(object):
    def __init__(self):
        self.is_open = True
        self.is_transition = False
        self.last_n_points = deque(
            [(0, 0), (0, 0), (0, 0), (0, 0), (0, 0), (0, 0)],
            6
        )

    def nextPoint(self, index, distance):
        last_point = self.last_n_points[-1]
        residue = index % 4
        # north
        new_point = list(last_point)

        if residue == 0:
            new_point[1] += distance
        elif residue == 1:
            new_point[0] -= distance
        elif residue == 2:
            new_point[1] -= distance
        elif residue == 3:
            new_point[0] += distance

        return tuple(new_point)


    def addPoint(self, point):
        self.last_n_points.append(point)

    def isCrossing(self, line1, line2):
        return self.isCrossingOrdered(line1, line2) or self.isCrossingOrdered(line2, line1)

    def isCrossingOrdered(self, line1, line2):
        p1, p2 = line1
        p3, p4 = line2
        return  p1[1] <= max(p3[1], p4[1]) and \
                p1[1] >= min(p3[1], p4[1]) and \
                p3[0] <= max(p1[0], p2[0]) and \
                p3[0] >= min(p1[0], p2[0])


    def isSelfCrossing(self, x):
        """
        :type x: List[int]
        :rtype: bool
        """
        if len(x) <= 3:
            return False

        for index, distance in enumerate(x):
            next_point = self.nextPoint(index, distance)

            if index < 2:
                pass
            elif self.is_transition:
                self.is_transition = False
                distance_fifth_before = 0 if index - 5 < 0 else x[index - 5]
                is_short = x[index - 1] < (x[index - 3] - distance_fifth_before)
                if is_short:
                    if self.isCrossing(
                            [self.last_n_points[-1], next_point],
                            [self.last_n_points[-4], self.last_n_points[-3]],
                            ):
                        return True
                else:
                    if self.isCrossing(
                            [self.last_n_points[-1], next_point],
                            [self.last_n_points[-6], self.last_n_points[-5]],
                            ):
                        return True

            elif self.is_open:
                still_open = distance > x[index - 2]
                if not still_open:
                    self.is_open = False
                    self.is_transition = True

            elif self.isCrossing(
                    [self.last_n_points[-1], next_point],
                    [self.last_n_points[-4], self.last_n_points[-3]],
                    ):
                return True

            self.addPoint(next_point)

        return False

# assert Solution().isSelfCrossing([2,1,1,2])
# assert not Solution().isSelfCrossing([1, 1, 1])
# assert Solution().isSelfCrossing([1, 1, 1, 1])
# assert not Solution().isSelfCrossing([1, 1, 2, 3])
# assert not Solution().isSelfCrossing([1, 1, 2, 3, 4, 5, 6])
# assert not Solution().isSelfCrossing([9, 8, 7, 6, 5, 4, 3])
# assert Solution().isSelfCrossing([9, 8, 7, 9, 5, 4, 3])
# assert Solution().isSelfCrossing([1,1,2,1,1])
