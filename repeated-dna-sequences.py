class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        existings = set()
        dups = set()
        for i in range(len(s) - 9):
            ten = s[i:i+10]
            if ten in existings:
                dups.add(ten)
            else:
                existings.add(ten)

        return list(dups)

# assert Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT") == ["AAAAACCCCC", "CCCCCAAAAA"]
# assert Solution().findRepeatedDnaSequences("AAAAAAAAAAA") == ["AAAAAAAAAA"]
