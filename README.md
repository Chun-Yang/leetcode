## 2017-10-10(3rd)

### TODO:
- review 1-400
- next 151-160

### HARD:
4-median-of-two-sorted-arrays.java
29-divide-two-integers.java
30-substring-with-concatenation-of-all-words.java
45-jump-game-ii.java
47-permutations-ii.java
52-n-queens-ii.java
72-edit-distance.java
81-search-in-rotated-sorted-array-ii.java
87-scramble-string.java
94-binary-tree-inorder-traversal.java
- postorder and preorder are similar
99-recover-binary-search-tree.java
138-copy-list-with-random-pointer.java
151-reverse-words-in-a-string.java

### TEACH:
1. Know solution to every problem in the pool, create a excel
- best for interiview
- optimal (if different from best and explain why)
- other ways to solve this
- similarity
- familarity/readiness
2. Set assumptions on interviewee's ability
3. Set plans for them depending on the ability

## tips and lessons
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
    - postorder: reverse preorder
      outdated: two stacks (like preorder, but from one stack to another)
116. Populating Next Right Pointers in Each Node
  - We can use the structure we setup, here we can use the next pointer
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
  - we can use the whole words as toVisit set and remove from them
  - rember to remove the element as soon as we see it
129. Word Ladder II
  - BFS to build an directed adjacency graph
    (from end to top, there may have orphaned nodes)
    then DFS back track using the graph
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
  - we can use substring as hash key for dp
142. Linked List Cycle II
  - fast - slow = CycleLength
  - slow = BeforeCycle + AfterCycle
  - fast = 2 * slow
  - we have: BeforeCycle = CycleLength - AfterCycle
    this means at the point of slow, if it moves BeforeCycle, it will be at the
    beginning of the Cycle
143. Reorder List
  - in the while loop for linked list, we can check node equal to stop, not just null
144. Binary Tree Preorder Traversal
  - we can store right instead of parent
  - we can store both and pop them one by one for left and right using
    stack property
145. Binary Tree Postorder Traversal
  - single stack: preorder + reverse (note: this only work for serailization,
    not for general operation) some times we just want to traverse the tree
    and not save the whole sequence. and if we do it this way,
    we are not doing it in the right order.
    This might be ok since we can run the traverse function on the final
149. Max Points on a Line
  - as long as we have the same asymptotic complexity,
    we can choose the one that is simpler to reason and implement
  - the sign of gcd is the first number passed to gcd
  - use normalized delta to indicate slop
162. Find Peak Element
  - this is like climbing a mountain, we just need to choose the higher path
164. Maximum Gap
  - use bucket sort, couting sort, radix sort when we need a O(n) sort
166. Fraction to Recurring Decimal
  - four parts: sign, before dot, dot, after dot
  - move one decimal at a time for denominator
  - rem is int all the time
  - remove (0) if we found it
168. Excel Sheet Column Title
  - We can convert 1-26 to 0-25
169. Majority Element
  - we can assume current element is the major
    - yes +1
    - no -1
    - 0 change the element to the new element
174. Dungeon Game
  - sometimes we can think from the opposite direction
187. Repeated DNA Sequences
  - use two sets to make sure we only save one repeation once
190. Reverse Bits
  - for bit cacheing, we can use small size to cache
204. Count Primes
  - we need to go from 2 to the max for each number if the current is prime
    the reason is for each prime number, we want to find all non-prime numbers
    by multiplying the prime number with any number(prime or not)
    2 * 4 (none prime)
    2 * 3 (prime)
259. 3Sum Smaller
  - two pointer
  - i < j < k does not mean we can not sort, it only mean one number can not
    be used twice in the triplet
269. Alien Dictionary
  - khan's BFS topological sort:
    https://discuss.leetcode.com/topic/32900/java-bfs-solution/2
    - use indegree, 0 means it is one of the starts
    - if the visited count does not equal to count of nodes, then there is loop (this is not obvious)
  - we can compare two adjancent and get the first difference to build the adjancecy hash
278. First Bad Version
  - lo < hi, mid = lo + (hi - lo) / 2, lo = mid + 1: find the first qualified one(bad version in this case)
    you can think of (lo = mid + 1) removes all unqualified ones(good versions in this case)
279. Perfect Squares
  - dp: find all possible squares and a previous one that is smallest and composed with squares

## hard problems for me
- https://leetcode.com/problems/populating-next-right-pointers-in-each-node/#/description
- https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/#/description
- https://leetcode.com/problems/word-ladder/
- https://leetcode.com/problems/word-ladder-ii/
- https://leetcode.com/problems/palindrome-partitioning/#/description
- https://leetcode.com/problems/palindrome-partitioning-ii/#/description
- https://leetcode.com/problems/word-break/#/description
- https://leetcode.com/problems/word-break-ii/#/description
- https://leetcode.com/problems/binary-tree-postorder-traversal/#/description
- https://leetcode.com/problems/sort-list/#/description
- https://leetcode.com/problems/find-peak-element/#/description
- https://leetcode.com/problems/fraction-to-recurring-decimal/#/description
- https://leetcode.com/problems/maximum-gap/#/description
- https://leetcode.com/problems/number-of-1-bits/#/description
- https://leetcode.com/problems/binary-tree-right-side-view/#/description
- https://leetcode.com/problems/count-primes/#/description
- https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
- https://leetcode.com/problems/contains-duplicate-iii/#/description
- https://leetcode.com/problems/the-skyline-problem/#/description
- https://leetcode.com/problems/maximal-square/#/description
- https://leetcode.com/problems/count-complete-tree-nodes/#/description
- https://leetcode.com/problems/implement-stack-using-queues/#/description
- https://leetcode.com/problems/majority-element-ii/#/description
- https://leetcode.com/problems/sliding-window-maximum/#/description
- 248-strobogrammatic-number-iii.java
- 253-meeting-rooms-ii.java
- 261-graph-valid-tree.java
- 271-encode-and-decode-strings.java
- 272-closest-binary-search-tree-value-ii.java
- https://leetcode.com/problems/h-index/#/description
- https://leetcode.com/problems/h-index-ii/#/description
- https://leetcode.com/problems/perfect-squares/#/description
- https://leetcode.com/problems/expression-add-operators/#/description
- https://leetcode.com/problems/find-the-duplicate-number/#/description
- https://leetcode.com/problems/find-median-from-data-stream/#/description
- https://leetcode.com/problems/longest-increasing-subsequence/#/description "O(n * log(n))"
- https://leetcode.com/problems/remove-invalid-parentheses/#/description
- 311-sparse-matrix-multiplication.java
- 314-binary-tree-vertical-order-traversal.java
- 315-count-of-smaller-numbers-after-self.java
- https://leetcode.com/problems/remove-duplicate-letters/description/
- 321-create-maximum-number.java
- 363-max-sum-of-rectangle-no-larger-than-k.java
- 371-sum-of-two-integers.java
- 375-guess-number-higher-or-lower-ii.java
- 384-shuffle-an-array.java
- 390-elimination-game.java
- 392-is-subsequence.java
- 397-integer-replacement.java
