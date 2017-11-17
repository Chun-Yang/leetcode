// Equations are given in the format A / B = k, where A and B are variables
// represented as strings, and k is a real number (floating point number). Given
// some queries, return the answers. If the answer does not exist, return -1.0.

// Example:
// Given a / b = 2.0, b / c = 3.0.
// queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
// return [6.0, 0.5, -1.0, 1.0, -1.0 ].

// According to the example above:

// equations = [ ["a", "b"], ["b", "c"] ],
// values = [2.0, 3.0],
// queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
// The input is always valid. You may assume that evaluating the queries will
// result in no division by zero and there is no contradiction.

// solution1: dfs
import java.util.*;
class Solution {
  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    HashMap<String, HashSet<String>> adj = new HashMap<>();
    HashMap<String, Double> quotients = new HashMap<>();
    for (int i=0; i<equations.length; i++) {
      String divident = equations[i][0];
      String divisor = equations[i][1];
      if (!adj.containsKey(divident)) {
        adj.put(divident, new HashSet<>());
      }
      adj.get(divident).add(divisor);
      if (!adj.containsKey(divisor)) {
        adj.put(divisor, new HashSet<>());
      }
      adj.get(divisor).add(divident);
      quotients.put(divident + "/" + divisor, values[i]);
      quotients.put(divisor + "/" + divident, 1.0 / values[i]);
    }

    double[] results = new double[queries.length];
    for (int i=0; i<queries.length; i++) {
      results[i] = calc(adj, quotients, queries[i]);
    }
    return results;
  }
  private double calc(HashMap<String, HashSet<String>> adj, HashMap<String, Double> quotients, String[] query) {
    String divident = query[0];
    String divisor = query[1];
    if (!adj.containsKey(divident) || !adj.containsKey(divisor)) return -1.0;
    if (divident.equals(divisor)) return 1.0;
    Double result = dfs(divident, divisor, new HashSet<String>(), adj, quotients, 1);
    return result == null ? -1.0 : result;
  }
  private Double dfs(String divident, String divisor, HashSet<String> visited, HashMap<String, HashSet<String>> adj, HashMap<String, Double> quotients, double value) {
    if (visited.contains(divident)) return null;

    if (adj.get(divident).contains(divisor)) return value * quotients.get(divident + "/" + divisor);

    visited.add(divident);
    for (String nextDivident : adj.get(divident)) {
      Double result = dfs(nextDivident, divisor, visited, adj, quotients, value * quotients.get(divident + "/" + nextDivident ));
      if (result != null) return result;
    }
    visited.remove(divident);
    return null;
  }
}

// solution2: calculate values from the equations, with assumptions that unknown values are 1
