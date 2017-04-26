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
- 77. Combinations
  - combinations can be viewed as a counting problem, we reset
    when we find the first digit that does not have a carry
  - use graph to draw an example may help with a dfs/backtracking solution
    - what is the termination condition? height of tree? found something?
    - what are the children?
- 79. Word Search
  - for 2-d search, we can detect the validity of the current cell together
    instead of check one by one for each direction. This will clean up
    code and will not create time-complexity wise panelty
  - for string, we do not need substring, we can just follow the index
  - we can use the board as 'visited' flag by using bit-wise or special chars
  - java char is 16 bit. it implement the UCS-2 encoding (preprocessor of utf-16)
  - UCS-2 does NOT support all chars in unicode, utf-16 does
  - the way java handle chars beyound ucs-2 is using suppliment mechanisme.
    it reserved some 2-bytes point for 4-bytes use (4 bytes can store all chars)
    http://www.oracle.com/us/technologies/java/supplementary-142654.html
  - ASCII has 128 chars, it is stored in 7 bits. 1 byte can store 256 chars
- 80. Remove Duplicates from Sorted Array II
  - we can use the invariance of the de-duped part to count the existing number
  - concise and easy to reason is more important than micro optimization
- 81. Search in Rotated Sorted Array II
  - remember the set of combinations we use and why
    - lo < hi,  lo = mid + 1, hi = mid,     nums[lo] == target
    - lo <= hi, lo = mid + 1, hi = mid - 1, false
  - use negative thinking in binary search, if it's not in my range, it must be
    in the other.
  - for binary search, we can use this for testing my case:
      1   3
    0 1 2 3 4
- 82. Remove Duplicates from Sorted List II
  - In some case, it might be better to use nested while.
    In this case, we can group the action of removing all duplicates in one
    block which is inside another while loop
    https://discuss.leetcode.com/topic/24470/java-simple-and-clean-code-with-comment
