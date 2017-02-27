from collections import Counter
from collections import defaultdict

class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        counters = [ ''.join(sorted(string)) for string in strs ]
        groups = defaultdict(list)
        for i, counter in enumerate(counters):
            groups[counter].append(strs[i])
        return groups.values()
