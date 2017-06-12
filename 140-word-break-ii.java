import java.util.*;

public class Solution {
  // NOTE: dfs useing start as cache key
  public List<String> wordBreak(String s, List<String> wordDict) {
    return dfs(s, 0, new HashSet<String>(wordDict), new HashMap<Integer, List<String>>());
  }
  private List<String> dfs(String s, int start, HashSet<String> words, HashMap<Integer, List<String>> cache) {
    if (cache.containsKey(start)) return cache.get(start);
    if (start == s.length()) return new ArrayList<String>(Arrays.asList(""));

    List<String> partitions = new ArrayList<String>();
    for (int end=start + 1; end<=s.length(); end++) {
      if (words.contains(s.substring(start, end))) {
        for (String subPartition: dfs(s, end, words, cache)) {
          if (subPartition.isEmpty()) {
            partitions.add(s.substring(start, end));
          } else {
            partitions.add(s.substring(start, end) + " " + subPartition);
          }
        }
      }
    }

    cache.put(start, partitions);
    return partitions;
  }

  // // NOTE: dfs using string as cache key
  // public List<String> wordBreak(String s, List<String> wordDict) {
  //   return dfs(s, new HashSet<String>(wordDict), new HashMap<String, List<String>>());
  // }
  // private List<String> dfs(String s, HashSet<String> words, HashMap<String, List<String>> cache) {
  //   if (cache.containsKey(s)) return cache.get(s);
  //   if (s.isEmpty()) return new ArrayList<String>(Arrays.asList(""));

  //   List<String> partitions = new ArrayList<String>();
  //   for (int end=1; end<=s.length(); end++) {
  //     if (words.contains(s.substring(0, end))) {
  //       for (String sub: dfs(s.substring(end), words, cache)) {
  //         if (sub.isEmpty()) {
  //           partitions.add(s.substring(0, end));
  //         } else {
  //           partitions.add(s.substring(0, end) + " " + sub);
  //         }
  //       }
  //     }
  //   }

  //   cache.put(s, partitions);
  //   return partitions;
  // }

  // public List<String> wordBreak(String s, List<String> wordDict) {
  //   int length = s.length();
  //   HashSet<String> words = new HashSet<String>(wordDict);

  //   boolean[] valid = new boolean[length + 1];
  //   valid[0] = true;
  //   for (int end=1; end<=length; end++) {
  //     for (int start=0; start < end; start++) {
  //       if (valid[start] && words.contains(s.substring(start, end))) {
  //         valid[end] = true;
  //         break;
  //       }
  //     }
  //   }
  //   if (!valid[length]) return new ArrayList<>();

  //   List<List<String>> breaks = new ArrayList<>();
  //   breaks.add(new ArrayList<String>(Arrays.asList("")));

  //   for (int end=1; end<=length; end++) {
  //     List<String> breakForIndex = new ArrayList<>();
  //     for (int start=0; start<end; start++) {
  //       if (words.contains(s.substring(start, end))) {
  //         for (String b : breaks.get(start)) {
  //           if (start == 0) {
  //             breakForIndex.add(s.substring(start, end));
  //           } else {
  //             breakForIndex.add(b + " " + s.substring(start, end));
  //           }
  //         }
  //       }
  //     }
  //     breaks.add(breakForIndex);
  //   }

  //   return breaks.get(length);
  // }
}
