- 69. Sqrt(x)
  - for binary search, try to find the constrain for mid
    as long as we get in the constrain, the mid will be correct
  - for binary search, when we do ``` l + (r - l) / 2 ```,
    we can not use (r - 1) to try to converge, since divide operation
    goes to the left side: e.g. 1 / 2 == 1
  - to avoid int overflow, we should use divide instead of multiply,
