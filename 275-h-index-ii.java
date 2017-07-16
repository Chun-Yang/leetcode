public class Solution {
  public int hIndex(int[] citations) {
    int n = citations.length;

    int lo = 0;
    int hi = n;

    while (lo < hi) {
      int mid = lo + (hi - lo + 1) / 2;
      if (citations[n - mid] < mid) hi = mid - 1;
      else lo = mid;
    }

    return lo;
  }

  // NOTE:
  // the reason this works is
  // it treats binary search as an exclusion approach
  // we want any i, i < l to be excluded so that l is the first included
  // public int hIndex(int[] citations) {
  //   int n = citations.length;

  //   if(n == 0) return 0;

  //   int l = 0, r = n;
  //   while(l < r){
  //     int mid = l + (r - l) / 2;
  //     if(citations[mid] == n - mid) return n - mid;
  //     if(citations[mid] < citations.length - mid) l = mid + 1;
  //     else r = mid;
  //   }
  //   return n - l;
  // }

  // // NOTE: lo < hi, lo = mid + 1, hi = mid
  // public int hIndex(int[] citations) {
  //   int n = citations.length;
  //   if (n == 0 || citations[n-1] == 0) return 0;

  //   int lo = 1;
  //   int hi = n;
  //   int mid = 0;

  //   while (lo < hi) {
  //     mid = lo + (hi - lo) / 2;
  //     if (citations[n - mid] > mid) lo = mid + 1;
  //     else hi = mid;
  //   }

  //   if (citations[n - lo] >= lo) return lo;
  //   return lo - 1;
  // }
}
