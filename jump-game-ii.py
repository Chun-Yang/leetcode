def jump(self, nums):
    jump, ps, pb, cb = 0, 0, 0, 0
    while cb < len(nums)-1:
        for i in range(ps + 1, pb + 1):
            cb = max(cb, i + nums[i])
        jump += 1
        ps, pb = pb, cb
    return jump
