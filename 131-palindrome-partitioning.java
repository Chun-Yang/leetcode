import java.util.*;
public class Solution {
  public List<List<String>> partition(String s) {
    int length = s.length();
    if (length == 0) return new ArrayList<>();
    // create an array of ends for all starts inclusive
    boolean [][] valid = new boolean[length][length];
    for (int l=1; l<=length; l++) {
      for (int start=0; start<=length-l; start++) {
        int end = start+l-1;
        valid[start][end] = s.charAt(start) == s.charAt(end)
          && (end - start <= 2 || valid[start+1][end-1]);
      }
    }

    // dp:
    // [endOfSubstring][partitionIndex][StringIndex]
    // partitionsForEachEnd = [ partitions... ]
    // partitions = [ partition... ]
    // partition = [ string... ]

    // get all partitions using dp
    List<List<List<String>>> partitions = new ArrayList<>();
    List<List<String>> first = new ArrayList<>();
    first.add(new ArrayList<String>());
    partitions.add(first);
    // NOTE: [start, end) for the appendix
    for (int end=1; end<=length; end++) {
      List<List<String>> p = new ArrayList<>();
      for (int start=0; start<end; start++) {
        if (valid[start][end-1]) {
          String appendix = s.substring(start, end);
          for (List<String> prefixes : partitions.get(start)) {
            List<String> arrangement = new ArrayList<>();
            arrangement.addAll(prefixes);
            arrangement.add(appendix);
            p.add(arrangement);
          }
        }
      }
      partitions.add(p);
    }
    return partitions.get(length);
  }
}
