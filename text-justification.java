import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {
  private String formatLine(ArrayList<String> words, int length, int maxWidth) {
    int wordsSize = words.size();

    if (wordsSize == 1) return formatLastLine(words, length, maxWidth);

    int space = (maxWidth - length) / (wordsSize - 1);
    int plusOnes = (maxWidth - length) - space * (wordsSize - 1);
    StringBuilder sb = new StringBuilder(words.get(0));
    for (int i = 1; i < wordsSize; i++) {
      int spaceSize = space + (plusOnes >= i ? 1 : 0);
      for (int j = 0; j < spaceSize; j++) {
        sb.append(" ");
      }
      sb.append(words.get(i));
    }
    return sb.toString();
  }

  private String formatLastLine(ArrayList<String> words, int length, int maxWidth) {
    int wordsSize = words.size();
    int paddingAtEnd = maxWidth - length - wordsSize + 1;
    StringBuilder sb = new StringBuilder(words.get(0));
    for (int i = 1; i < wordsSize; i++) {
      sb.append(" ");
      sb.append(words.get(i));
    }
    for (int i = 0; i < paddingAtEnd; i++) sb.append(" ");
    return sb.toString();
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    if (words.length == 0) return new ArrayList<>();
    // divide words into lines
    ArrayList<ArrayList<String>> lines = new ArrayList<>();
    ArrayList<Integer> lineLengths = new ArrayList<>();

    ArrayList<String> line = new ArrayList<>(Arrays.asList(words[0]));
    int lineLength = words[0].length();

    for (int i = 1; i < words.length; i++) {
      if (words[i].length() == 0) {
        continue;
      } else if (lineLength + 1 + words[i].length() > maxWidth) {
        lines.add(line);
        lineLengths.add(lineLength - line.size() + 1);
        line = new ArrayList<>(Arrays.asList(words[i]));
        lineLength = words[i].length();
      } else {
        line.add(words[i]);
        lineLength += 1 + words[i].length();
      }
    }

    if (lineLength > 0) {
      lines.add(line);
      lineLengths.add(lineLength - line.size() + 1);
    }

    int linesLength = lines.size();
    if (linesLength == 0) {
      char[] spaces = new char[maxWidth];
      Arrays.fill(spaces, ' ');
      String spaceLine = new String(spaces);
      return new ArrayList<>(Arrays.asList(spaceLine));
    }

    ArrayList<String> linesOfString = new ArrayList<>();
    // format each line
    for (int i = 0; i < linesLength - 1; i++) {
      linesOfString.add(formatLine(
        lines.get(i),
        lineLengths.get(i),
        maxWidth
      ));
    }

    // format last line
    linesOfString.add(formatLastLine(
          lines.get(linesLength - 1),
          lineLengths.get(linesLength - 1),
          maxWidth
          ));

    return linesOfString;
  }

  public static void main (String[] args) {
    Solution s = new Solution();

    String[] s1 = {"ab cd", "ef   "};
    ArrayList<String> a1 = new ArrayList<>(Arrays.asList(s1));
    assert s.fullJustify(new String[] {"ab", "cd", "ef"}, 5).equals(a1);

    String[] s2 = {"ab  ", "efdd"};
    ArrayList<String> a2 = new ArrayList<>(Arrays.asList(s2));
    assert s.fullJustify(new String[] {"ab  ", "efdd"}, 4).equals(a2);

    String[] s3 = {"     "};
    ArrayList<String> a3 = new ArrayList<>(Arrays.asList(s3));
    assert s.fullJustify(new String[] {"", ""}, 5).equals(a3);

    String[] s4 = {"  "};
    ArrayList<String> a4 = new ArrayList<>(Arrays.asList(s4));
    assert s.fullJustify(new String[] {""}, 2).equals(a4);
  }
}
