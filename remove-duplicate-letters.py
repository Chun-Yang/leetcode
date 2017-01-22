
from collections import Counter

class Solution(object):
    def removeDuplicateLetters(self, s):
        counter, deduped, freezed = Counter(s), [], set()
        for c in s:
            if c not in freezed:
                while deduped and deduped[-1] >= c and len(deduped) > len(freezed):
                    deduped.pop()
                deduped.append(c)
                counter[c] -= 1
                if counter[c] == 0:
                    freezed |= set(deduped[len(freezed):])

        return ''.join(deduped)

assert Solution().removeDuplicateLetters("bcabc") == 'abc'
assert Solution().removeDuplicateLetters("abacb") == 'abc'
