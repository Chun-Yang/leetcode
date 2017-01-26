class Solution(object):
    def maxProduct(self, words):
        size = len(words)
        sets = [set(word) for word in words]
        product = 0
        for i in range(size):
            for j in range(i, size):
                if not (sets[i] & sets[j]):
                    product = max(product, len(words[i]) * len(words[j]))
        return product
