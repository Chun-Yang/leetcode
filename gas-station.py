class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        size = len(gas)
        residues = [gas[i] - cost[i] for i in range(size)]

        maxResidue = 0
        maxResidueIndex = 0
        for i in range(size):
            if residues[i] >= 0 and residues[i - 1] < 0:
                curIndex = i
                curResidue = 0
                while residues[curIndex] >= 0:
                    curResidue += residues[curIndex]
                    curIndex = (curIndex + 1) % size
                if curResidue > maxResidue:
                    maxResidueIndex = curIndex


