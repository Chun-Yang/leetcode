import java.util.List;
import java.util.ArrayList;

public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> l = new ArrayList<>();
    TreeNode cur = root;
    Stack<TreeNode> stack = new Stack<>();
    while (cur != null || !stack.empty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      l.add(cur.val);
      cur = cur.right;
    }
    return l;
  }
  // public List<Integer> inorderTraversal(TreeNode root) {
  //   if (root == null) return new ArrayList<>();

  //   List<Integer> l = new ArrayList<>();
  //   Stack<TreeNode> stack = new Stack<TreeNode>();
  //   stack.push(root);
  //   while (!stack.empty()) {
  //     // down
  //     TreeNode bottom = stack.peek();
  //     while (bottom.left != null || bottom.right != null) {
  //       if (bottom.left != null) {
  //         bottom = bottom.left;
  //       } else {
  //         l.add(bottom.val);
  //         bottom = bottom.right;
  //       }
  //       stack.push(bottom);
  //     }
  //     l.add(bottom.val);
  //     // up
  //     while (true) {
  //       bottom = stack.pop();
  //       if (stack.empty()) break;
  //       TreeNode parent = stack.peek();
  //       if (parent.left == bottom) {
  //         if (parent.right == null) l.add(parent.val);
  //         else {
  //           stack.push(parent.right);
  //           l.add(parent.val);
  //           break;
  //         }
  //       }
  //     }
  //   }

  //   return l;
  // }
  // public List<Integer> inorderTraversal(TreeNode root) {
  //   List<Integer> l = new ArrayList<>();
  //   dfs(root, l);
  //   return l;
  // }
  // private void dfs(TreeNode root, List<Integer> l) {
  //   if (root == null) return;
  //   dfs(root.left, l);
  //   l.add(root.val);
  //   dfs(root.right, l);
  // }
  public static void main (String[] args) {
    Solution s = new Solution();
  }
}