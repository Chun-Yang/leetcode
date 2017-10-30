// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
// The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
//
//
//
//
// Visually, the graph looks like the following:
//
// 1
// / \
// /   \
// 0 --- 2
// / \
// \_/


// https://leetcode.com/problems/clone-graph
// HashMap(oldNode, newNode) + dfs
// if not visited, we create the node in the HashMap

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
