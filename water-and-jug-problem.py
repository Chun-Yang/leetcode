class Solution(object):
    def canMeasureWater(self, x, y, z):
        """
        :type x: int
        :type y: int
        :type z: int
        :rtype: bool
        """
        if x * y == 0:
            return z == x or z == y or z == 0

        if x == y:
            return z // x <= 2 and z % x == 0

        if x + y < z:
            return False

        small, big = min(x, y), max(x, y)
        fraction, residue = divmod(big, small)
        zf, zr = divmod(z, small)

        return False
