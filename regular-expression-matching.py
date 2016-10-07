class Solution(object):
    def isMatchRec(self, s, p):
        if p == '':
            return s == ''

        is_star = len(p) >= 2 and p[1] == '*'

        if is_star:
            if s == '':
                return (len(p) % 2 == 0) and \
                        all([char == '*' for char in p[3::2]])

            if self.isMatchRec(s, p[2:]):
                return True

            for i in range(len(s)):
                if s[i] == p[0] or p[0] == '.':
                    if self.isMatchRec(s[i+1:], p[2:]):
                        return True
                else:
                    return False
            return False

        else:
            return s != '' and \
                (s[0] == p[0] or p[0] == '.') and \
                self.isMatchRec(s[1:], p[1:])

    def simplifyPattern(self, p):
        # No simplification
        # return p

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
        return simplified_p


    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        return self.isMatchRec(s, self.simplifyPattern(p))

# assert not Solution().isMatch('aa', 'a')
# assert Solution().isMatch('aa', 'aa')
# assert Solution().isMatch('aa', 'a*')
# assert Solution().isMatch('aaa', 'a*a')
# assert Solution().isMatch('aa', '.*')
# assert Solution().isMatch('aaaaaaaaaaaaab', 'a*a*a*a*a*a*a*a*a*a*a*a*b')
# assert not Solution().isMatch('ab', '.*c')
# assert Solution().isMatch('bbbba','.*a*a')
# assert Solution().isMatch("aasdfasdfasdfasdfas","aasdf.*asdf.*asdf.*asdf.*s")
# assert not Solution().isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c")
# assert Solution().isMatch("cbaacacaaccbaabcb","c*b*b*.*ac*.*bc*a*")
# assert Solution().isMatch("","c*a*")
