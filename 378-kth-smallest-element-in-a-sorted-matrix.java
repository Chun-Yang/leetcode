// Given a n x n matrix where each of the rows and columns are sorted in ascending
// order, find the kth smallest element in the matrix.

// Note that it is the kth smallest element in the sorted order,
// not the kth distinct element.

// Example:

// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,

// return 13.

import java.util.*;

// Solution 3: n * Log(max - min)
// https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code/2

// Solution 2: improve on solution 1 O(k * log(n))
class Solution {
  class Node implements Comparable<Node> {
    int val;
    int row;
    int col;
    public Node (int row, int col, int val) {
      this.val = val;
      this.row = row;
      this.col = col;
    }

    @Override
    public int compareTo(Node that) {
      return this.val - that.val;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    for(int j = 0; j <= n-1; j++) pq.offer(new Node(0, j, matrix[0][j]));
    for(int i = 0; i < k-1; i++) {
      Node t = pq.poll();
      if(t.row == n-1) continue;
      pq.offer(new Node(t.row+1, t.col, matrix[t.row+1][t.col]));
    }
    return pq.poll().val;
  }
}

// Solution 1: pq greedy O(k * log(n))
// class Solution {
//   class Node {
//     int val;
//     int row;
//     int col;
//     public Node (int val, int row, int col) {
//       this.val = val;
//       this.row = row;
//       this.col = col;
//     }
//   }
//   public int kthSmallest(int[][] matrix, int k) {
//     int m = matrix.length;
//     int n = matrix[0].length;

//     PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
//       @Override
//       public int compare(Node n1, Node n2) {
//         return n1.val - n2.val;
//       }
//     });
//     pq.offer(new Node(matrix[0][0], 0, 0));

//     HashSet<String> visited = new HashSet<>();

//     for (int i=1; i<k; i++) {
//       Node minNode = pq.poll();
//       if (minNode.row < m - 1 && !visited.contains((minNode.row + 1) + " " + minNode.col)) {
//         visited.add((minNode.row + 1) + " " + minNode.col);
//         pq.offer(new Node(matrix[minNode.row + 1][minNode.col], minNode.row + 1, minNode.col));
//       }
//       if (minNode.col < n - 1 && !visited.contains(minNode.row + " " + (minNode.col + 1))) {
//         visited.add(minNode.row + " " + (minNode.col + 1));
//         pq.offer(new Node(matrix[minNode.row][minNode.col + 1], minNode.row, minNode.col + 1));
//       }
//     }
//     return pq.peek().val;
//   }
// }
