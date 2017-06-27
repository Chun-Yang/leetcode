public class Solution {
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, new Comparator<int[]>() {
      public int compare(int[] x, int[] y) {
        return x[1] - y[1];
      }
    });
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    int time = 0;
    for (int[] course : courses) {
      queue.offer(course[0]);
      time += course[0];
      if (time > course[1]) {
        time -= queue.poll();
      }
    }
    return queue.size();
  }
}
