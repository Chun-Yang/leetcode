class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        strs_length = len(strs)
        if strs_length == 0:
            return ''

        max_length = min(map(len, strs))
        for i in range(max_length):
            if not all([strs[j][i] == strs[0][i] for j in range(strs_length)]):
                return strs[0][:i]

        return strs[0][:max_length]

# assert Solution().longestCommonPrefix(['abc', 'abcd']) ==  'abc'
# assert Solution().longestCommonPrefix(['abcd']) ==  'abcd'
# assert Solution().longestCommonPrefix(['aa', 'a']) ==  'a'
