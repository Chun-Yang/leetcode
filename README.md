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
