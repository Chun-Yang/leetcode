import java.util.*;

public class LRUCache {
  private class ListNode {
    int val;
    ListNode pre;
    ListNode next;
    public ListNode(int val) {
      this.val = val;
    }
  }

  ListNode head;
  ListNode tail;
  int length;
  int capacity;
  HashMap<Integer, Integer> valueMap;
  HashMap<Integer, ListNode> nodeMap;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    valueMap = new HashMap<>();
    nodeMap = new HashMap<>();
    head = new ListNode(-1);
    tail = new ListNode(-1);
    head.next = tail;
    tail.pre = head;
  }

  public int get(int key) {
    if (!valueMap.containsKey(key)) return -1;

    ListNode node = nodeMap.get(key);

    // remove
    node.pre.next = node.next;
    node.next.pre = node.pre;

    // add to end
    tail.pre.next = node;
    node.pre = tail.pre;
    node.next = tail;
    tail.pre = node;

    return valueMap.get(key);
  }

  public void put(int key, int value) {
    if (valueMap.containsKey(key)) {
      // move the node to the right
      ListNode node = nodeMap.get(key);
      node.pre.next = node.next;
      node.next.pre = node.pre;

      tail.pre.next = node;
      node.pre = tail.pre;
      node.next = tail;
      tail.pre = node;

      // update valueMap
      valueMap.put(key, value);
      return;
    }

    length++;
    // invalidate the Least Recently Used (head)
    if (length > capacity) {
      ListNode lruNode = head.next;
      // remove from list
      head.next.next.pre = head;
      head.next = head.next.next;
      // remove from maps
      valueMap.remove(lruNode.val);
      nodeMap.remove(lruNode.val);
    }

    // add to list
    ListNode newNode = new ListNode(key);
    newNode.next = tail;
    newNode.pre = tail.pre;
    tail.pre.next = newNode;
    tail.pre = newNode;
    // add to maps
    valueMap.put(key, value);
    nodeMap.put(key, newNode);
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
