hex_lookup = ['0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f']
max_value = pow(2, 32)

class Solution(object):
    def toHex(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return '0'

        is_negative = num < 0
        if is_negative:
            num = max_value + num

        hex_list = []
        while num > 0:
            hex_list.insert(0, hex_lookup[num & 15])
            num >>= 4

        return ''.join(hex_list)


assert Solution().toHex(26) == '1a'
assert Solution().toHex(-1) == 'ffffffff'
