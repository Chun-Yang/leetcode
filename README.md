## things to remember
- from heapq import heappush, heappop
- from bisect import bisect_left, bisect_right, bisect, insort_left, insort_right, insort
- from collections import defaultdict
  - defaultdict(list)
  - defaultdict(set)
- from random import random, randint, randrange, sample, choice
- # builtins
  - ord
  - chr
  - bin # bin(2) -> '0b10'
  - oct # oct(2) -> '0o2'
  - hex # hex(2) -> '0x2'
  - int # int('10', 2) -> 2
  - round
  - sorted
  - reversed
  - zip
  - iter
  - next
- from math import ceil, floor, factorial, log, gcd, pi, e, sqrt
- l, value, index = [1,2,3], 1000, 2 # list
  - l.insert(value, index)
  - l.remove(value)
  - del l[index]
  - l.count(value)
  - l.index(value) (throws if not exist)
  - value in l
- s = 'abc' # string
  - index
  - find
  - split
  - strip
  - lstrip
  - rstrip
  - upper
  - lower
- from re import compile
  - re.compile("[a-z]").split(s)
  - re.compile("[a-z]").search('[]a') # True
  - re.compile("[a-z]").match('[]a') # False
- itertools
  - combinations
  - permutations
  - product
  - islice
- # error handling
```
try:
  pass
except ValueError as e:
  print('error')

raise ValueError('message')
raise Exception('generic error')
```
- isinstance
- remove last bit
  - x & (x - 1)
- # file
  with open('file1.py') as f:
    for line in f:
      pass
  f = open('file1.py')
  f.close()

## onsite questions
- Range query maximum (Binary Index Tree and Segment Tree)
  https://discuss.leetcode.com/category/388/range-sum-query-2d-mutable
- 给一个string和一个string list，把所有string list里在string里match到的字符加上<b></b>, 这题可以用KMP如果你能现场写的话，楼主用的trie，勉强写完，没时间follow up，感觉还可以改进，如果要挂就挂在这里了
- 给一个二维数组，一个source位置和一个goal，有的位置之间还有wall，每次移动必须朝一个方向移动到不能移动为止，问从source能不能到goal
