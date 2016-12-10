class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        secretHash = {}
        guessHash = {}
        bulls = 0

        # calc bulls
        for i in range(len(secret)):
            s, g = secret[i], guess[i]
            if s == guess[i]:
                bulls += 1
            else:
                secretHash[s] = secretHash.get(s, 0) + 1
                guessHash[g] = guessHash.get(g, 0) + 1

        # calk cows
        cows = sum(min(guessHash[c], secretHash[c]) if c in guessHash else 0 for c in secretHash)
        return str(bulls) + 'A' + str(cows) + 'B'

# assert Solution().getHint('1234', '0111') == '0A1B'
