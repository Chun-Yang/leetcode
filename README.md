- 69. Sqrt(x)
  - for binary search, try to find the constrain for mid
    as long as we get in the constrain, the mid will be correct
  - for binary search, when we do ``` l + (r - l) / 2 ```,
    we can not use (r - 1) to try to converge, since divide operation
    goes to the left side: e.g. 1 / 2 == 1
  - to avoid int overflow, we should use divide instead of multiply,
- 70. Climbing Stairs
  - trick: x, y = y, x + y
    => x = (y += x) - x;
    => y += x; x = y - x;
- 72. Edit Distance
  - ways to get length
    list.length
    String.length()
    ArrayList.size()
  - if I can solve a sub problem with a spcific way, maybe I can try
    to solve the whole problem using this algorithem
- 74. Search a 2D Matrix
  - for binary search, when you use lo < hi to search,
    you may hit the search even the loop stops.
    for example: search 2 in [1, 2]
    in this case, you can use true to search and check if lo == hi
    or check if the value after the loop
  - for binary search, when you use lo <= hi,
    the loop may never stop.
    for example: search 2 in [3, 4]
- 75. Sort Colors
  - move one position in while loop may simplify the logic
  - sort from one end is simpler from two ends at the same time
