69. Sqrt(x)
  - for binary search, try to find the constrain for mid
    as long as we get in the constrain, the mid will be correct
  - for binary search, when we do ``` l + (r - l) / 2 ```,
    we can not use (r - 1) to try to converge, since divide operation
    goes to the left side: e.g. 1 / 2 == 1
  - to avoid int overflow, we should use divide instead of multiply,
70. Climbing Stairs
  - trick: x, y = y, x + y
    => x = (y += x) - x;
    => y += x; x = y - x;
72. Edit Distance
  - ways to get length
    list.length
    String.length()
    ArrayList.size()
  - if I can solve a sub problem with a spcific way, maybe I can try
    to solve the whole problem using this algorithem
74. Search a 2D Matrix
  - for binary search, when you use lo < hi to search,
    you may hit the search even the loop stops.
    for example: search 2 in [1, 2]
    in this case, you can use true to search and check if lo == hi
    or check if the value after the loop
  - for binary search, when you use lo <= hi,
    the loop may never stop.
    for example: search 2 in [3, 4]
75. Sort Colors
  - move one position in while loop may simplify the logic
  - sort from one end is simpler from two ends at the same time
76. Minimum Window Substring
  - we can use a counter to indicate wether a match is met
  - use while loop can be more flexible than for loop and more symmatic
    for two pointer problems
  - go though a test case using all of the variables
    with the thought algorithem is helpful, expecially for two pointer
    since there might be multiple variables
  - choose variable based on the result may be benifical and straight forward
    e.g. use [) for substring
  - for right exclusive, we can do
    ```
    r = 1
    while (r <= length) {
      // do things
      r++;
    }
    ```
77. Combinations
  - combinations can be viewed as a counting problem, we reset
    when we find the first digit that does not have a carry
  - use graph to draw an example may help with a dfs/backtracking solution
    - what is the termination condition? height of tree? found something?
    - what are the children?
79. Word Search
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
80. Remove Duplicates from Sorted Array II
  - we can use the invariance of the de-duped part to count the existing number
  - concise and easy to reason is more important than micro optimization
81. Search in Rotated Sorted Array II
  - remember the set of combinations we use and why
    - lo < hi,  lo = mid + 1, hi = mid,     nums[lo] == target
    - lo <= hi, lo = mid + 1, hi = mid - 1, false
  - use negative thinking in binary search, if it's not in my range, it must be
    in the other.
  - for binary search, we can use this for testing my case:
      1   3
    0 1 2 3 4
82. Remove Duplicates from Sorted List II
  - In some case, it might be better to use nested while.
    In this case, we can group the action of removing all duplicates in one
    block which is inside another while loop
    https://discuss.leetcode.com/topic/24470/java-simple-and-clean-code-with-comment
84. One key observation is the max area will cover equal to at least one of the bar
86. Partition List
  - use diagram to go through a relatively simple test case
  - use different notation for different operations
  - for linked-list we can use
    "-" for next
    "->" for link change
    "=" for equal
    "=>" for equal change
87. Scramble String
  - when you think its exponential, try dp
  - try to reduce a recursive operation to one operation that recurse
  - when use dp, string length is a good way to be a dimension.
  - for a NP-complete like problem, we can try:
    1. dp
    2. dfs with early termination
88. Merge Sorted Array
  - try different order forward, backward...
90. Subsets II
  - we can use dp like this: loop through all elements, and add new ones based
    on those exsisting ones
  - if we want to use dfs, we need to konw:
    - what are the children
    - termination condition
91. Decode Ways
  - we can reduce the amount of memory we use for dp if the optimal
    equation consists only limited amount of previous steps
92. Reverse Linked List II
  - go though one example may be missleading, we may need multiple examples
    in multiple steps
93. Maximal Rectangle
  - We can try to reduce a 2D problem to a 1D problem
  - The largest matrix has to be one of the largest histogram of one row
  - we can also use a lefts, rights and heights dp solution for each row
94. Binary Tree Inorder Traversal
  - when we use stack, we do not have to save all of the nodes along the path
    we only need to save those that we need to check later on
96. Unique Binary Search Trees
  - Catalan Numbers
98. Validate Binary Search Tree
  - Binary search tree's parents constrain the child with a range
99. Recover Binary Search Tree
  - Inorder Traversal is an important traversal for BST
  - If I can solve a problem as a sorted list, then I should be able to do
    it using inorder traversal
105. Construct Binary Tree from Preorder and Inorder Traversal
  - When the values are unique, we can try to use hash table to speed lookup
108. Convert Sorted Array to Binary Search Tree
  - Height balanced vs Weight balanced (less common)
  - Height balanced means the diff or height of any leaf is at most one
109. Convert Sorted List to Binary Search Tree
  - We can find middle using fast and slow pointer, also the two pointers
    are reusable
  - In-order traversal align with linked-list
110. Balanced Binary Tree
  - we can use a special number (0, negative number) to indicate the state
  - complete: 1 2 3
  - full: 1 2 4
  - iterative:
    - preorder: a stack
    - inorder: a stack + cur
    - postorder: two stacks (like preorder, but from one stack to another)
120. Triangle
  - For un-symmatric structure, we can try to do things from another end
121. Best Time to Buy and Sell Stock
  - DP can use multiple values, not just one single value
123. Best Time to Buy and Sell Stock III
  - When we have exponential run time, we should consider DP
  - If we want to use DP, we have to find atomic operations,
    for this stock problem, a transation consists of a buy
    and a sell actions which come in sequence. We should consider
    them saparately
127. Word Ladder
  - we can use the length of a string and alphabet to iterate
130. Surrounded Regions
  - union find quick union + pass compression is amoritized at log(n) per operation
  - union find with rank/weight + pass compression is amortized 1 per operation
132. Palindrome Partitioning II
  - find palindrome boolean matrix:
    - for each length, for each position
    - for each end, for each start
134. This is a math problem
135. This is a math problem
136. Single Number
  - x ^ x = 0
  - (x ^ y) ^ z = x ^ (y ^ z)
  - x ^ y operator is a flip based on y,
    y = 1 : flip
    y = 0 : do not filp
  - ^ : flip on one
  - x ^ y can be seen as 0 ^ x ^ y (both of x y are operations)
137. Single Number II
  - we can count the bits and use %
  - we can use binary couting. 00 01 10
138. Copy List with Random Pointer
  - we can use one Linked List and extract the clone from the merged one
  - if we use a hash, we do not really need to create the list first,
    as lone as we have the links, we can use hash only
  - java HashMap output null when key does not exist. Also, null is a permitted
    key
140. Word Break II
  - bottom up dp has a draw back: we compute all sub problems
    if we use dfs we might not need to compute them
142. Linked List Cycle II
  - fast - slow = CycleLength
  - slow = BeforeCycle + AfterCycle
  - fast = 2 * slow
  - we have: BeforeCycle = CycleLength - AfterCycle
    this means at the point of slow, if it moves BeforeCycle, it will be at the
    beginning of the Cycle
