class Solution(object):
    def circularArrayLoop(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        l = len(nums)
        i = 0
        def getNext(i):
            return (i + nums[i]) % l

        def mark(i):
            j = i
            while nums[j] != 0:
                nums[j] = 0
                j = getNext(j)

        for i in range(l):
            if nums[i] != 0:
                slow, fast = i, i
                while True:
                    slow = getNext(slow)
                    fast = getNext(getNext(fast))
                    if slow == fast:
                        break

                # contains more than one element
                if getNext(slow) != slow:
                    prev = slow
                    while True:
                        cur = getNext(prev)
                        if cur == slow:
                            return True
                        elif nums[prev] * nums[cur] < 0:
                            break
                        else:
                            prev = cur
            mark(i)

        return False

# assert Solution().circularArrayLoop([2, -1, 1, 2, 2]) == True
# assert Solution().circularArrayLoop([-2, 1, -1, -2, -2]) == False
# assert Solution().circularArrayLoop([3,1,2]) == True
