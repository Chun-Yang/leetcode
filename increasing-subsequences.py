class Solution(object):
    def findSubsequences(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        sequences = set()
        for num in nums:
            newSequences = set()
            for sequence in sequences:
                if num >= sequence[-1]:
                    newSequences.add(sequence + (num,))
            sequences = sequences | newSequences
            sequences.add((num,))

        return [list(sequence) for sequence in sequences if len(sequence) > 1]
