# # v1.0
# class Solution(object):
#   def decodeString(self, s):
#     # repeats is a list of prefix and count
#     repeats, num  = [['', 1]], ''
#     for c in s:
#       if c == '[':
#         repeats.append(['', int(num)])
#         num = ''
#       elif c == ']':
#         string, count = repeats.pop()
#         repeats[-1][0] += (string * count)
#         num = ''
#       elif c in '1234567890':
#         num += c
#       else:
#         repeats[-1][0] += c
#     return repeats[0][0]

# # v2.0
# class Solution(object):
#     def decodeString(self, s):
#         numbers, strings = [], []
#         number, string = '', ''
#         for c in s:
#             if c == '[':
#                 numbers.append(number)
#                 strings.append(string)
#                 number = ''
#                 string = ''
#             elif c == ']':
#                 string = strings.pop() + int(numbers.pop()) * string
#             elif c.isdigit():
#                 number += c
#             else:
#                 string += c
#         return string

assert Solution().decodeString("") == ""
assert Solution().decodeString("a") == "a"
assert Solution().decodeString("2[a]") == "aa"
assert Solution().decodeString("3[a2[c]]") == "accaccacc"
assert Solution().decodeString("3[a2[c]]4[b]f") == "accaccaccbbbbf"
