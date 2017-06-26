// this is a partition problem
public class Solution {
  public List<Integer> diffWaysToCompute(String input) {
    // parse into tokens
    List<String> tokens = new ArrayList<>();
    int start = 0;
    for (int i=0; i<input.length(); i++) {
      char c = input.charAt(i);
      if (c < '0' || c > '9') {
        tokens.add(input.substring(start, i));
        tokens.add(input.substring(i, i + 1));
        start = i + 1;
      }
    }
    tokens.add(input.substring(start));

    return dfs(tokens, 0, tokens.size() - 1);
  }
  List<Integer> dfs(List<String> tokens, int start, int end) {
    ArrayList<Integer> results = new ArrayList<>();
    // only 1 number
    if (start == end) {
      results.add(Integer.parseInt(tokens.get(start)));
      return results;
    }
    for (int i=start + 1; i < end; i += 2) {
      for (int left : dfs(tokens, start, i - 1)) {
        for (int right : dfs(tokens, i + 1, end)) {
          results.add(calc(left, right, tokens.get(i)));
        }
      }
    }
    return results;
  }
  private int calc(int left, int right, String operator) {
    if (operator.equals("+")) return left + right;
    else if (operator.equals("-")) return left - right;
    else return left * right;
  }
}
