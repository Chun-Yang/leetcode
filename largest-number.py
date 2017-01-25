class Solution:
    # @param {integer[]} nums
    # @return {string}
    def largestNumber(self, nums):
        numsAsStr = [str(num) for num in nums]
        def compare(x, y):
            if x + y > y + x:
                return 1
            else:
                return -1

        ans = ''.join(num for num in sorted(numsAsStr, cmp=compare, reverse=True))
        return ans.lstrip('0') or '0'

# x = Solution().largestNumber([1])
# print("x", x)
