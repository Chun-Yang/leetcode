public class Solution {
  public int candy(int[] ratings) {
    int length = ratings.length;
    int[] candies = new int[length];
    Arrays.fill(candies, 1);

    for (int i=1; i<length; i++) {
      if (ratings[i] > ratings[i-1]) candies[i] = candies[i-1] + 1;
    }

    for (int i=length-1; i>0; i--) {
      if (ratings[i-1] > ratings[i]) candies[i-1] = Math.max(candies[i-1], candies[i] + 1);
    }

    int sum = 0;
    for (int c: candies) sum += c;
    return sum;
  }
}
