class Solution(object):
    def licenseKeyFormatting(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: str
        """
        chars = S.replace('-', '').upper()
        residue = len(chars) % K
        groupCount = len(chars) // K

        groups = []
        if residue > 0:
            groups.append(chars[:residue])

        for i in range(groupCount):
            start = residue + K * i
            groups.append(chars[start: start + K])

        return '-'.join(groups)
