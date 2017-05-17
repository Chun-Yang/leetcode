/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode hat = new RandomListNode(0);
    RandomListNode iterOrigin = head;
    RandomListNode iterClone = hat;

    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

    while (iterOrigin != null) {
      iterClone.next = new RandomListNode(iterOrigin.label);
      map.put(iterOrigin, iterClone.next);

      iterClone = iterClone.next;
      iterOrigin = iterOrigin.next;
    }

    iterOrigin = head;
    iterClone = hat.next;
    while (iterOrigin != null) {
      if (map.containsKey(iterOrigin.random)) {
        iterClone.random = map.get(iterOrigin.random);
      }

      iterClone = iterClone.next;
      iterOrigin = iterOrigin.next;
    }

    return hat.next;
  }
}
