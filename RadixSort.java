import java.util.*;

public class RadixSort {
  public static void main (String[] args) {
    // lsd
    assert Arrays.equals(new String[] {}, RadixSort.lsd(new String[] {}));
    assert Arrays.equals(new String[] { "a", "c", "z" }, RadixSort.lsd(new String[] { "c", "a", "z" }));
    assert Arrays.equals(new String[] { "ab", "ad", "cb", "za" }, RadixSort.lsd(new String[] { "cb", "ab", "za", "ad" }));
    // msd
    assert Arrays.equals(new String[] {}, RadixSort.msd(new String[] {}));
    assert Arrays.equals(new String[] { "a", "c", "z" }, RadixSort.msd(new String[] { "c", "a", "z" }));
    assert Arrays.equals(new String[] { "ab", "ad", "cb", "za" }, RadixSort.msd(new String[] { "cb", "ab", "za", "ad" }));
    assert Arrays.equals(
      new String[] { "", "a", "abc", "abd", "ad", "cb", "za" },
      RadixSort.msd(new String[] { "cb", "abd", "abc", "", "za", "ad", "a" })
    );
  }
  private RadixSort() {}

  // Least Significant Digit
  static String[] lsd(String[] strings) {
    if (strings.length == 0) return strings;
    int digits = strings[0].length();
    int length = strings.length;
    int[] counts = new int[128];
    String[] partiallySorted = new String[length];
    for (int i=digits-1; i>=0; i--) {
      Arrays.fill(counts, 0);
      for (int j=0; j<length; j++) counts[strings[j].charAt(i)]++;
      // note the counts are the end position (exclusive)
      for (int j=1; j<128; j++) counts[j] += counts[j-1];
      // NOTE: we loop from the end the string the reason is:
      // initial: [ "cb", "ab", "za", "ad" ]
      // sorted1: [ "za", "cb", "ab", "ad" ]
      // sorted2: - [ * ,    * ,    * , *  ]
      // sorted2: - [ * ,    "ad" , * , *  ]
      // sorted2: - [ "ab" , "ad" , * , *  ]
      // if we loop from start to end, then the order will be reversed
      for (int j=length-1; j>=0; j--) partiallySorted[--counts[strings[j].charAt(i)]] = strings[j];
      for (int j=0; j<length; j++) strings[j] = partiallySorted[j];
    }
    return strings;
  }

  // Most Significatn Digit
  static String[] msd(String[] strings) {
    String[] aux = new String[strings.length];
    msdSort(strings, aux, 0, strings.length, 0);
    return strings;
  }

  static int getIndex(String string, int digit) {
    if (digit == string.length()) return 0;
    return string.charAt(digit) + 1;
  }

  private static void msdSort(String[] strings, String[] aux, int start, int end, int digit) {
    if (end - start <= 1) return;
    // NOTE 0 means empty and should be the first one
    // NOTE last digit is always the count of all numbers
    // so that when we segment, we can use the counts array
    int WIDTH = 128 + 2;
    int[] counts = new int[WIDTH];
    for (int i=start; i<end; i++) counts[getIndex(strings[i], digit)]++;
    for (int i=1; i<WIDTH; i++) counts[i] += counts[i-1];
    for (int i=start; i<end; i++) {
      int offset = --counts[getIndex(strings[i], digit)];
      aux[start + offset] = strings[i];
    }
    for (int i=start; i<end; i++) strings[i] = aux[i];
    for (int i=1; i<WIDTH - 1; i++) {
      msdSort(strings, aux, start + counts[i], start + counts[i + 1], digit+1);
    }
  }
}
