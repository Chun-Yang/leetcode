// Description:
// Count the number of prime numbers less than a non-negative number, n.
//
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.


// https://leetcode.com/problems/count-primes

// solution1: dp
// time O(n^2) space O(n)
// use an array to lable if its a prime,
// use multiplication of the current value and all previous values to
// mark the result as prime
// overflow: multi / current should equal to the other value
// NOTE: we only need to check primes with previous values
