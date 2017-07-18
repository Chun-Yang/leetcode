// Serialization is the process of converting a data structure or object into a
// sequence of bits so that it can be stored in a file or memory buffer, or
// transmitted across a network connection link to be reconstructed later in
// the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There is no
// restriction on how your serialization/deserialization algorithm should work.
// You just need to ensure that a binary tree can be serialized to a string and
// this string can be deserialized to the original tree structure.

// For example, you may serialize the following tree

//     1
//    / \
//   2   3
//      / \
//     4   5

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    List<String> tokens = new LinkedList<>();
    serializeDfs(root, tokens);
    return String.join(" ", tokens);
  }
  private void serializeDfs (TreeNode root, List<String> tokens) {
    if (root == null) {
      tokens.add("#");
      return;
    }
    tokens.add(Integer.toString(root.val));
    serializeDfs(root.left, tokens);
    serializeDfs(root.right, tokens);
  }

  int index;

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] tokens = data.split(" ");
    if (tokens.length == 0) return null;
    index = 0;
    return deserializeDfs(tokens);
  }
  private TreeNode deserializeDfs(String[] tokens) {
    String token = tokens[index];
    index++;
    if (token.equals("#")) {
      return null;
    }
    int val = Integer.parseInt(token);
    TreeNode node = new TreeNode(val);
    node.left = deserializeDfs(tokens);
    node.right = deserializeDfs(tokens);
    return node;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
