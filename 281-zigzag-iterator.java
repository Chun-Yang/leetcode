// Given two 1d vectors, implement an iterator to return their elements
// alternately.

// For example, given two 1d vectors: v1 = [1, 2] v2 = [3, 4, 5, 6]
// By calling next repeatedly until hasNext returns false, the order of elements
// returned by next should be: [1, 3, 2, 4, 5, 6]. Follow up: What if you are
// given k 1d vectors? How well can your code be extended to such cases?





















import java.util.*;

class Node {
  public int size;
  public int index;
  public int current;
  public Node(int size, int index) {
    this.size = size;
    this.index = index;
    current = 0;
  }
}

public class Solution {
  public List<Integer> zigzagIterator(int[][] vectors) {
    Queue<Node> queue = new LinkedList<Node>();
    List<Integer> values = new LinkedList<Integer>();
    for (int i=0; i < vectors.length; i++) {
      queue.offer(new Node(vectors[i].length, i));
    }
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node.current < node.size) {
        values.add(vectors[node.index][node.current]);
        queue.offer(node);
        node.current++;
      }
    }
    return values;
  }
  public static void main(String[] args) {
    Solution i = new Solution();
    assert Arrays.asList( 1, 3, 2 ).equals(i.zigzagIterator(new int[][]{ new int[]{1, 2}, new int[]{3} }));
    assert Arrays.asList( 1, 2, 3 ).equals(i.zigzagIterator(new int[][]{ new int[]{1, 2, 3}, new int[]{} }));
    assert Arrays.asList( 1, 2, 3 ).equals(i.zigzagIterator(new int[][]{ new int[]{}, new int[]{1, 2, 3} }));
    assert Arrays.asList( 1, 2, 3, 4, 5 ).equals(i.zigzagIterator(new int[][]{ new int[]{1, 4}, new int[]{2, 5}, new int[]{3} }));
  }
}
