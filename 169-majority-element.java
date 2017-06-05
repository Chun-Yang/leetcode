public class Solution {
  public int majorityElement(int[] nums) {
    int counter = 1;
    int major = nums[0];
    int length = nums.length;
    for (int i=1; i<length; i++) {
      if (nums[i] == major) {
        counter++;
      } else {
        counter--;
        if (counter < 0) {
          major = nums[i];
          counter = 1;
        }
      }
    }
    return major;
  }
}
