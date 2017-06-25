public class Solution {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    return (C - A) * (D - B) + (G - E) * (H - F) - overlap(A, C, E, G) * overlap(B, D, F, H);
  }
  private int overlap(int l1, int r1, int l2, int r2) {
    return r1 <= l2 || r2 <= l1 ? 0 : Math.min(r1, r2) - Math.max(l1, l2);
  }
}
