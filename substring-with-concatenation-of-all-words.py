class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        if not words:
            return []

        words_counts = {}
        for word in words:
            if word in words_counts:
                words_counts[word] += 1
            else:
                words_counts[word] = 1

        words_len = len(words)
        word_len = len(words[0])
        s_len = len(s)
        indices = []
        for i in range(s_len - words_len * word_len + 1):
            words_counts_copy = words_counts.copy()
            is_valid = True
            for j in range(words_len):
                next_word_in_s = s[i + j * word_len : i + (j + 1) * word_len]
                if (next_word_in_s in words_counts_copy) and (words_counts_copy[next_word_in_s] > 0):
                    words_counts_copy[next_word_in_s] -= 1
                else:
                    is_valid = False
                    break
            if is_valid:
                indices.append(i)

        return indices


# assert Solution().findSubstring("barfoothefoobarman", ["foo", "bar"]) == [0, 9]
