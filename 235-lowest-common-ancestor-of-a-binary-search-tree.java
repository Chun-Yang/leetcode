// Given a binary search tree (BST), find the lowest common ancestor (LCA) of
// two given nodes in the BST.
//
//
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor
// is defined between two nodes v and w as the lowest node in T that has both v
// and w as descendants (where we allow a node to be a descendant of itself).”
//
//
//
// _______6______
// /              \
// ___2__          ___8__
// /      \        /      \
// 0      _4       7       9
// /  \
// 3   5
//
//
//
// For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another
// example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of
// itself according to the LCA definition.


// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree

// solution1: dfs post-order (too complicated)
// - found LCA: return LCA
// - isLeft or isRight, return current
// - found on left + found on right: return current
// - found left, not right: return left
// - found right, nor left: return right

// solution2: dfs
// - go left
// - go right
// - current
