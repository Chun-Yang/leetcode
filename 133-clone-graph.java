/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return null;

    HashMap<Integer, UndirectedGraphNode> visited = new HashMap<>();
    return dfs(node, visited);
  }
  private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> visited) {
    UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
    visited.put(node.label, clone);

    for (UndirectedGraphNode neighbor : node.neighbors) {
      if (visited.containsKey(neighbor.label)) clone.neighbors.add(visited.get(neighbor.label));
      else clone.neighbors.add(dfs(neighbor, visited));
    }

    return clone;
  }
}
