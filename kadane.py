def maxSubArraySum(nums):
    if len(nums) == 0:
        return None

    maxSum = nums[0]
    maxLeft = nums[0]
    for i in range(1, len(nums)):
        num = nums[i]
        maxLeft = max(num, num + maxLeft)
        maxSum = max(maxSum, maxLeft)

    return maxSum

assert maxSubArraySum([]) == None
assert maxSubArraySum([-1]) == -1
assert maxSubArraySum([1]) == 1
assert maxSubArraySum([1,2,3]) == 6
assert maxSubArraySum([1, -2, 3]) == 3
assert maxSubArraySum([1, -2, 3, -4, 5]) == 5
