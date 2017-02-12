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
- external sort (merge sort)
  - 给你一大堆文件，每个文件里面是排序好的数，一行只有一个数字，文件可能很大，内存装不下。要求把所有文件里的数字排序好放到一个输出文件里面

- two sum closest
  - 找到所有比target number小的对儿的个数
- 给出一群Interval，在一条实数轴上，返回一堆点，要求每个Interval都有点，而且点的个数尽量少。
- (?) 说每个城市都有个日历，日历上面有假期，问一年之内怎么休息能拿到最多的假期
- 自动补全的实现

- given list of points, 求可围成的最小矩形的面积（矩形定义式跟x\y轴平行）
- Moving Average from Data Stream
  http://www.programcreek.com/2014/05/leetcode-moving-average-from-data-stream-java/
- tournament-scheduling的题目：N名选手，实力按数字排序，越厉害的数字越小，按要求给出初赛的scheduling。要求为每一轮最厉害的选手都跟当前最弱的人比
