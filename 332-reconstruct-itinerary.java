// Given a list of airline tickets represented by pairs of departure and arrival
// airports [from, to], reconstruct the itinerary in order. All of the tickets
// belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

// Note:
// If there are multiple valid itineraries, you should return the itinerary that
// has the smallest lexical order when read as a single string. For example, the
// itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].

// All airports are represented by three capital letters (IATA code).
// You may assume all tickets form at least one valid itinerary.

// Example 1:
// tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
// Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

// Example 2:
// tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
// Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But
// it is larger in lexical order.

import java.util.*;

// https://discuss.leetcode.com/topic/36383/share-my-solution
// Hierholzer's algorithm (greedy)
class Solution {
  Map<String, PriorityQueue<String>> flights;
  LinkedList<String> path;

  public List<String> findItinerary(String[][] tickets) {
    flights = new HashMap<>();
    path = new LinkedList<>();
    for (String[] ticket : tickets) {
      flights.putIfAbsent(ticket[0], new PriorityQueue<>());
      flights.get(ticket[0]).add(ticket[1]);
    }
    dfs("JFK");
    return path;
  }

  public void dfs(String departure) {
    PriorityQueue<String> arrivals = flights.get(departure);
    if (arrivals != null && arrivals.size() > 0) {
      dfs(arrivals.poll());
    }
    path.addFirst(departure);
  }
}

// Solution 1 backtracking
// dfs, pq for ordering
// class Solution {
//   public static void main (String[] args) {
//     Solution s = new Solution();
//     s.findItinerary(new String[][]{
//       new String[]{"JFK","KUL"},
//       new String[]{"JFK","NRT"},
//       new String[]{"NRT","JFK"},
//     });
//   }
//   public List<String> findItinerary(String[][] tickets) {
//     // build adjancency list
//     HashMap<String, List<String>> adjList = new HashMap<>();
//     for (String[] ticket : tickets) {
//       adjList.putIfAbsent(ticket[0], new ArrayList<String>());
//       adjList.get(ticket[0]).add(ticket[1]);
//     }

//     // dfs to build itinerary until adjancency list is empty
//     List<String> itinerary = new ArrayList<String>(Arrays.asList("JFK"));
//     dfs(adjList, itinerary,  "JFK");
//     return itinerary;
//   }
//   // true: valid itinerary
//   private boolean dfs(HashMap<String, List<String>> adjList, List<String> itinerary, String from) {
//     if (adjList.isEmpty()) return true;

//     if (!adjList.containsKey(from)) return false;

//     List<String> destinations = adjList.get(from);

//     // back tracking
//     if (destinations.size() == 1) {
//       String destination = destinations.get(0);

//       adjList.remove(from);
//       itinerary.add(destination);
//       if (dfs(adjList, itinerary, destination)) return true;
//       itinerary.remove(itinerary.size() - 1);
//       adjList.put(from, destinations);
//     } else {
//       List<String> sortedDestinations = new ArrayList<>(destinations);
//       Collections.sort(sortedDestinations);
//       for (String destination : sortedDestinations) {
//         destinations.remove(destination);
//         itinerary.add(destination);
//         if (dfs(adjList, itinerary, destination)) return true;
//         itinerary.remove(itinerary.size() - 1);
//         destinations.add(destination);
//       }
//     }
//     return false;
//   }
// }
