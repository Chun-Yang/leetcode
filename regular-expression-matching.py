class Solution(object):
    def isMatchRec(self, s, p):
        if p == '':
            return s == ''

        is_star = len(p) >= 2 and p[1] == '*'

        if is_star:
            if s == '':
                return self.isMatchRec(s, p[2:])

            if s[0] == p[0] or p[0] == '.':
                return self.isMatchRec(s[1:], p) \
                        or self.isMatchRec(s, p[2:])

            return self.isMatchRec(s, p[2:])
        else:
            if s == '':
                return False

            if s[0] == p[0] or p[0] == '.':
                return self.isMatchRec(s[1:], p[1:])

            return False

    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        simplified_p = ''
        previous_star = ''
        previous_star_index = 0
        for index, char in enumerate(p):
            if char == '*' :
                current_star = p[index - 1]
                if previous_star == current_star and previous_star_index == index - 2:
                    simplified_p = simplified_p[:-1]
                else:
                    simplified_p += char
                previous_star = current_star
                previous_star_index = index
            else:
                simplified_p += char

        return self.isMatchRec(s, simplified_p)

# assert not Solution().isMatch('aa', 'a')
# assert Solution().isMatch('aa', 'aa')
# assert Solution().isMatch('aa', 'a*')
# assert Solution().isMatch('aaa', 'a*a')
# assert Solution().isMatch('aa', '.*')
# assert Solution().isMatch('aaaaaaaaaaaaab', 'a*a*a*a*a*a*a*a*a*a*a*a*b')
# assert not Solution().isMatch('ab', '.*c')
# assert Solution().isMatch('bbbba','.*a*a')
# assert Solution().isMatch("aasdfasdfasdfasdfas","aasdf.*asdf.*asdf.*asdf.*s")
