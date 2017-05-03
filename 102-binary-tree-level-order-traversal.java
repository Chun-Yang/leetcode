// import java.util.*;

public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new LinkedList<>();

    List<List<Integer>> listOfList = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new LinkedList<Integer>();
      for (int i=0; i<size; i++) {
        TreeNode last = queue.poll();
        list.add(last.val);
        if (last.left != null) queue.offer(last.left);
        if (last.right != null) queue.offer(last.right);
      }
      listOfList.add(list);
    }

    return listOfList;
  }
  // public List<List<Integer>> levelOrder(TreeNode root) {
  //   if (root == null) return new ArrayList<>();
  //   List<List<Integer>> list = new ArrayList<>();
  //   List<TreeNode> level = new ArrayList<TreeNode>(Arrays.asList(root));

  //   while (!level.isEmpty()) {
  //     List<Integer> listItem = new ArrayList<Integer>();
  //     List<TreeNode> newLevel = new ArrayList<TreeNode>();
  //     for (TreeNode node: level) {
  //       listItem.add(node.val);
  //       if (node.left != null) newLevel.add(node.left);
  //       if (node.right != null) newLevel.add(node.right);
  //     }
  //     list.add(listItem);
  //     level = newLevel;
  //   }

  //   return list;
  // }
  // public List<List<Integer>> levelOrder(TreeNode root) {
  //   if (root == null) return new ArrayList<>();
  //   List<List<Integer>> left = levelOrder(root.left);
  //   List<List<Integer>> right = levelOrder(root.right);
  //   List<List<Integer>> combined = new ArrayList<List<Integer>>();
  //   combined.add(new ArrayList<Integer>(Arrays.asList(root.val)));
  //   int leftSize = left.size();
  //   int rightSize = right.size();
  //   for (int i=0; i<Math.max(leftSize, rightSize); i++) {
  //     List<Integer> combinedItem = new ArrayList<Integer>();
  //     if (i < leftSize) {
  //       for (int leftNum: left.get(i)) combinedItem.add(leftNum);
  //     }
  //     if (i< rightSize) {
  //       for (int rightNum: right.get(i)) combinedItem.add(rightNum);
  //     }
  //     combined.add(combinedItem);
  //   }
  //   return combined;
  // }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}
