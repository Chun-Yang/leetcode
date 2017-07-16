// Given an array of citations (each citation is a non-negative integer) of a researcher,
// write a function to compute the researcher's h-index.

// According to the definition of h-index on Wikipedia:
// "A scientist has index h if h of his/her N papers have at least h citations each,
// and the other N − h papers have no more than h citations each."

// For example, given citations = [3, 0, 6, 1, 5],
// which means the researcher has 5 papers in total and each of them had received
// 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with
// at least 3 citations each and the remaining two with no more than 3 citations each,
// his h-index is 3.

// Note: If there are several possible values for h, the maximum one is taken as the h-index.
// https://discuss.leetcode.com/topic/28276/java-o-n-time-with-easy-explanation

// NOTE: there is exactuly one h-index, the reason this thinks h index
// has more than one possible values, is when they only consider the first part
// of the definition

public class Solution {
  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] counts = new int[n+1];

    for (int c : citations) counts[Math.min(n, c)]++;
    int total = 0;
    for (int i=n; i>=0; i--) {
      total += counts[i];
      if (total >= i) return i;
    }

    return 0;
  }
  // public int hIndex(int[] citations) {
  //   Arrays.sort(citations);
  //   int h = 0;
  //   int n = citations.length;
  //   for (int i=0; i<n; i++) {
  //     if (citations[i] >= n-i) h = Math.max(h, Math.min(citations[i], n-i));
  //   }
  //   return h;
  // }
}
