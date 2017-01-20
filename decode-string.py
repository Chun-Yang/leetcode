class Solution(object):
  def decodeString(self, s):
    # repeats is a list of prefix and count
    repeats, num  = [['', 1]], ''
    for c in s:
      if c == '[':
        repeats.append(['', int(num)])
        num = ''
      elif c == ']':
        string, count = repeats.pop()
        repeats[-1][0] += (string * count)
        num = ''
      elif c in '1234567890':
        num += c
      else:
        repeats[-1][0] += c

    return repeats[0][0]

# s = Solution().decodeString("3[a2[c]]")
# print("s", s)
