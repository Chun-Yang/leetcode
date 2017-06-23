import java.util.Stack;

// https://discuss.leetcode.com/topic/2424/my-modified-answer-from-geeksforgeeks-in-java/6
// NOTE: in this solution, we only calculate rect when we POP
public class Solution {
    public int largestRectangleArea(int[] height) {
        int maxRect = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i <= height.length; ++i) {
            int h = i == height.length ? 0 : height[i];
            // calculate all max rect that STOP here
            // NOTE: when the height is the same, we still pop,
            // the previous one is not going to be the max one,
            // but we will still calculate the current one which is wider
            while (!stack.isEmpty() && h < height[stack.peek()]) {
                int rect = height[stack.pop()] * (stack.isEmpty() ? i : (i-stack.peek()-1));
                maxRect = Math.max(maxRect, rect);
            }
            // push my self for pop and calculation later
            stack.push(i);
        }

        return maxRect;
    }
}

// public class Solution {
//   public int largestRectangleArea(int[] heights) {
//     int maxArea = 0;
//     int l = heights.length;
//     Stack<Integer> lefts = new Stack<Integer>();
//     Stack<Integer> lHeights = new Stack<Integer>();

//     for (int i=0; i<=l; i++) {
//       int h = i == l ? 0 : heights[i];
//       int left = i;

//       while (!lefts.empty() && h <= lHeights.peek()) {
//         left = lefts.pop();
//         maxArea = Math.max(maxArea, lHeights.pop() * (i - left));
//       }

//       lefts.push(left);
//       lHeights.push(h);
//     }

//     return maxArea;
//   }
//   public static void main (String[] args) {
//     Solution s = new Solution();
//     // assert s.largestRectangleArea(new int[] {2, 1}) == 2;
//     // assert s.largestRectangleArea(new int[] {1, 1}) == 2;
//     assert s.largestRectangleArea(new int[] {2,1,5,6,2,3}) == 10;
//   }
// }
