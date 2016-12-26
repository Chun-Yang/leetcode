class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        array = [1]
        for _ in range(n - 1):
            i, temp, size = 0, [], len(array)
            while i < size:
                count, num = 0, array[i]
                while i < size and array[i] == num:
                    count += 1
                    i += 1
                temp.extend([count, num])
            array = temp

        return ''.join(str(i) for i in array)
