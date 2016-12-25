class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        v1, v2 = version1.split('.'), version2.split('.')
        l1, l2 = len(v1), len(v2)
        if l1 > l2:
            v2 += ['0'] * (l1 - l2)
        elif l1 < l2:
            v1 += ['0'] * (l2 - l1)

        for i in range(max(l1, l2)):
            if int(v1[i]) > int(v2[i]):
                return 1
            elif int(v1[i]) < int(v2[i]):
                return -1

        return 0
