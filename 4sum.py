# O(n^2)
from collections import Counter
from collections import defaultdict

class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        # { <number>: <count> }
        counts = Counter(nums)
        # { <sum>: set(<pair>, ...) }
        uniq_nums = list(counts.keys())
        uniq_nums_len = len(uniq_nums)
        pair_sums = defaultdict(lambda: set())
        for i in range(uniq_nums_len):
            for j in range(i + 1, uniq_nums_len):
                i_num = uniq_nums[i]
                j_num = uniq_nums[j]
                pair_sums[i_num + j_num].add((i_num, j_num))
        for i_num in uniq_nums:
            if counts[i_num] >= 2:
                pair_sums[i_num + i_num].add((i_num, i_num))

        def feasible(quad):
            quad_counts = Counter(quad)
            for i in quad_counts:
                if counts[i] < quad_counts[i]:
                    return False

            return True

        # all the sums that are checked
        residues_checked = set()

        quadruplets = set()
        # for each sum, we find if their is another sum to add up to target
        for s in pair_sums:
            residue = (target - s)
            if residue in pair_sums and residue not in residues_checked:
                residues_checked.add(residue)
                for pair1 in pair_sums[target - s]:
                    for pair2 in pair_sums[s]:
                        quad = tuple(sorted(pair1 + pair2))
                        if feasible(quad):
                            quadruplets.add(quad)

            residues_checked.add(s)

        quadruplets = list(map(list, quadruplets))
        return quadruplets

# assert Solution().fourSum([1, 0, -1, 0, -2, 2], 0) == [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
