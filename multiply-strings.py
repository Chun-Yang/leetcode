class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        l1, l2 = len(num1), len(num2)
        product = [0] * (l1 + l2)

        for i1, d1 in enumerate(reversed(num1)):
            for i2, d2 in enumerate(reversed(num2)):
                lo = i1 + i2
                hi = lo + 1
                product[hi], product[lo] = divmod(product[lo] + int(d1) * int(d2), 10)

        while product and product[-1] == 0:
            product.pop()

        return ''.join(str(d) for d in product[::-1]) if product else '0'

# assert Solution().multiply('0', '0') == '0'
# assert Solution().multiply('1', '0') == '0'
# assert Solution().multiply('100', '10') == '1000'
# assert Solution().multiply('12', '12') == '144'
