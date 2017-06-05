public class Solution {
  public String largestNumber(int[] nums) {
    int length = nums.length;
    String[] strs = new String[length];
    for (int i=0; i<length; i++) {
      strs[i] = Integer.toString(nums[i]);
    }
    Arrays.sort(strs, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
      }
    });
    if (strs[0].equals("0")) return "0";
    return String.join("", strs);
  }
}
