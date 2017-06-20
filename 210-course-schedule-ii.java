public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> adjs = new HashMap<>();
    for (int[] prerequisite : prerequisites) {
      int from = prerequisite[0];
      int to = prerequisite[1];
      if (!adjs.containsKey(from)) adjs.put(from, new ArrayList<Integer>());
      adjs.get(from).add(to);
    }

    List<Integer> sorted = new ArrayList<Integer>();
    boolean[] onStack = new boolean[numCourses];
    boolean[] visited = new boolean[numCourses];

    for (int i=0; i<numCourses; i++) {
      if (!postOrder(i, adjs, sorted, onStack, visited)) return new int[0];
    }

    int[] sortedArray = new int[numCourses];
    for (int i=0; i<numCourses; i++) {
      sortedArray[i] = sorted.get(i);
    }
    return sortedArray;
  }

  private boolean postOrder(int i, HashMap<Integer, List<Integer>>adjs, List<Integer> sorted, boolean[] onStack, boolean[] visited) {
    if (onStack[i]) return false;
    if (visited[i]) return true;

    visited[i] = true;
    if (adjs.containsKey(i)) {
      onStack[i] = true;
      for (int j : adjs.get(i)) {
        if (!postOrder(j, adjs, sorted, onStack, visited)) {
          return false;
        }
      }
      onStack[i] = false;
    }
    sorted.add(i);
    return true;
  }
}
