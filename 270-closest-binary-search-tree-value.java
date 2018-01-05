// Given a non-empty binary search tree and a target value,
// find the value in the BST that is closest to the target.

// solution1: branch after the current value
// postorder
// - t > v right
// - t < v left
// - t == v return
// return current value or children's value
// O(h)
