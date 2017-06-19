// cycle detection
// 1. [MINE] dfs using visited and sorted
// if I try to visite a visited and not sorted node, there must be a cycle
// because connecting from a lower lever to a higher level will create a cycle
// 2. [ALGO4] dfs using back tracking
// 3. bfs kahn's algorithem ( keep track of outdegree )
// - queue start from 0 outdegree
// - decrease indegress of adjencent ones
// - put the ones that are zero into queue
// TODO: topological sort (when we encounter)
// 1. [MINE] dfs
// 2. [ALGO4] dfs reversed post order
// 3. bfs kahn's algorithem
//
// java stack.push != stack.offer, stack.pop == stack.poll
public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] prerequisite: prerequisites) {
      int from = prerequisite[0];
      int to = prerequisite[1];
      if (!adj.containsKey(to)) adj.put(to, new ArrayList<Integer>());
      adj.get(to).add(from);
    }

    int[] outdegree = new int[numCourses];
    Arrays.fill(outdegree, 0);
    for (int[] prerequisite: prerequisites) {
      int from = prerequisite[0];
      outdegree[from]++;
    }

    int count = 0;
    Queue<Integer> verges = new LinkedList<Integer>();
    for (int i=0; i<numCourses; i++) {
      if (outdegree[i] == 0) verges.offer(i);
    }
    while (!verges.isEmpty()) {
      count++;
      int to = verges.poll();
      for (int from : adj.getOrDefault(to, new ArrayList<>())) {
        outdegree[from]--;
        if (outdegree[from] == 0) {
          verges.offer(from);
        }
      }
    }

    return count == numCourses;
  }
  // // 2. [ALGO4] dfs using back tracking
  // public boolean canFinish(int numCourses, int[][] prerequisites) {
  //   HashMap<Integer, List<Integer>> adj = new HashMap<>();
  //   for (int[] prerequisite: prerequisites) {
  //     int from = prerequisite[0];
  //     int to = prerequisite[1];
  //     if (!adj.containsKey(from)) adj.put(from, new ArrayList<Integer>());
  //     adj.get(from).add(to);
  //   }

  //   boolean[] onStack = new boolean[numCourses];
  //   boolean[] visited = new boolean[numCourses];
  //   for (int i=0; i<numCourses; i++) {
  //     if (!dfs(i, adj, onStack, visited)) return false;
  //   }
  //   return true;
  // }

  // private boolean dfs(int i, HashMap<Integer, List<Integer>> adj, boolean[] onStack, boolean[] visited) {
  //   if (onStack[i]) return false;
  //   if (visited[i]) return true;
  //   visited[i] = true;
  //   onStack[i] = true;

  //   for (int j : adj.getOrDefault(i, new ArrayList<>())) {
  //     if (!dfs(j, adj, onStack, visited)) return false;
  //   }

  //   onStack[i] = false;
  //   return true;
  // }


  // // 1. [MINE] dfs using visited and sorted
  // public boolean canFinish(int numCourses, int[][] prerequisites) {
  //   // create the map
  //   HashMap<Integer, List<Integer>> edges = new HashMap<>();
  //   for (int[] prerequisite: prerequisites) {
  //     int from = prerequisite[0];
  //     int to = prerequisite[1];
  //     if (!edges.containsKey(from)) edges.put(from, new ArrayList<Integer>());
  //     edges.get(from).add(to);
  //   }

  //   // dfs
  //   boolean[] visited = new boolean[numCourses];
  //   boolean[] sorted = new boolean[numCourses];

  //   for (int i=0; i<numCourses; i++) {
  //     if (!dfs(i, edges, visited, sorted)) return false;
  //   }
  //   return true;
  // }
  // private boolean dfs(int i, HashMap<Integer, List<Integer>> edges, boolean[] visited, boolean[] sorted) {
  //   if (visited[i]) {
  //     return sorted[i];
  //   }
  //   visited[i] = true;
  //   for (int j: edges.getOrDefault(i, new ArrayList<Integer>())) {
  //     if (!dfs(j, edges, visited, sorted)) return false;
  //   }
  //   sorted[i] = true;
  //   return true;
  // }
}
