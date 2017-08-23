// You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller
// elements to the right of nums[i].

// Example:

// Given nums = [5, 2, 6, 1]

// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.
// Return the array [2, 1, 1, 0].

// Solution 1 Binary Search Tree
import java.util.*;

class Solution {
  class Node {
    int val;
    int smaller;
    int dup;
    Node left;
    Node right;
    public Node(int val) {
      this.val = val;
      smaller = 0;
      dup = 1;
    }
  }
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> counts = new ArrayList<Integer>();

    Node tree = null;

    for (int i=nums.length - 1; i>=0; i--) {
      tree = search(nums[i], tree, counts, 0);
    }

    Collections.reverse(counts);
    return counts;
  }
  private Node search(int val, Node node, List<Integer> counts, int count) {
    if (node == null) {
      counts.add(count);
      return new Node(val);
    }
    if (val > node.val) {
      node.right = search(val, node.right, counts, count + node.smaller + node.dup);
    } else if (val < node.val) {
      node.smaller += 1;
      node.left = search(val, node.left, counts, count);
    } else {
      counts.add(count + node.smaller);
      node.dup++;
    }

    return node;
  }
}
