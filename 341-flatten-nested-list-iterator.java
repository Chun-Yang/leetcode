/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.*;

// Solution: do not use indexes stack, use iterator instead
public class NestedIterator implements Iterator<Integer> {
  LinkedList<Iterator<NestedInteger>> path;
  Integer nextValue;

  public NestedIterator(List<NestedInteger> nestedList) {
    path = new LinkedList<>();
    path.add(nestedList.iterator());
    nextValue = getNext();
  }

  private Integer getNext() {
    while (true) {
      Iterator<NestedInteger> iter = path.peekLast();
      if (!iter.hasNext()) {
        path.pollLast();
        if (path.size() == 0) return null;
      } else {
        NestedInteger n = iter.next();
        if (n.isInteger()) {
          return n.getInteger();
        } else {
          path.offerLast(n.getList().iterator());
        }
      }
    }
  }

  @Override
  public Integer next() {
    Integer value = this.nextValue;
    nextValue = getNext();
    return value;
  }

  @Override
  public boolean hasNext() {
    return nextValue != null;
  }
}


// Solution: use indexes to keep track of the current index of the list
// public class NestedIterator implements Iterator<Integer> {
//   LinkedList<List<NestedInteger>> path;
//   LinkedList<Integer> indexes;
//   Integer nextValue;

//   public NestedIterator(List<NestedInteger> nestedList) {
//     path = new LinkedList<>();
//     path.add(nestedList);
//     indexes = new LinkedList<>();
//     indexes.add(-1);
//     // prepare the next value before hand
//     nextValue = getNext();
//   }

//   private Integer getNext() {
//     indexes.offerLast(indexes.pollLast() + 1);
//     while (true) {
//       int index = indexes.peekLast();
//       List<NestedInteger> list = path.peekLast();
//       if (list == null || list.size() == index) {
//         indexes.pollLast();
//         path.pollLast();
//         if (path.size() == 0) return null;
//         indexes.offerLast(indexes.pollLast() + 1);
//       } else if (list.get(index) == null) {
//         continue;
//       } else if (list.get(index).isInteger()) {
//         return list.get(index).getInteger();
//       } else {
//         indexes.offerLast(0);
//         path.offerLast(list.get(index).getList());
//       }
//     }
//   }

//   @Override
//   public Integer next() {
//     Integer value = this.nextValue;
//     nextValue = getNext();
//     return value;
//   }

//   @Override
//   public boolean hasNext() {
//     return nextValue != null;
//   }
// }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
