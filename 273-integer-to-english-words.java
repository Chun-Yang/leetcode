// Convert a non-negative integer to its english words representation.
// Given input is guaranteed to be less than 2^31 - 1.

// For example,
// 123 -> "One Hundred Twenty Three"
// 12345 -> "Twelve Thousand Three Hundred Forty Five"
// 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

public class Solution {
  static final String[] units = new String[]{
    "",
    " Thousand",
    " Million",
    " Billion"
  };
  static final String[] underTwenty = new String[]{
    "",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen"
  };
  static final String[] tens = new String[]{
    "",
    "",
    "Twenty",
    "Thirty",
    "Forty",
    "Fifty",
    "Sixty",
    "Seventy",
    "Eighty",
    "Ninety"
  };

  public String numberToWords(int num) {
    if (num == 0) return "Zero";

    String[] parts = new String[4];
    Arrays.fill(parts, "");
    for (int i=0; i<4; i++) {
      parts[i] = unitToWords(num % 1000);
      num /= 1000;
      if (num == 0) break;
    }

    List<String> presentParts = new ArrayList<String>();
    for (int i=3; i>=0; i--) {
      if (!parts[i].isEmpty()) {
        presentParts.add(parts[i] + units[i]);
      }
    }

    return String.join(" ", presentParts);
  }

  private String unitToWords(int num) {
    if (num == 0) return "";

    // hundred
    StringBuilder words = new StringBuilder();
    if (num >= 100) {
      words.append(underTwenty[num / 100] + " Hundred");
      num %= 100;
      if (num == 0) return words.toString();
      else words.append(" ");
    }

    // num < 20
    if (num < 20) {
      words.append(underTwenty[num]);
      return words.toString();
    }

    // 100> num >= 20
    words.append(tens[num / 10]);
    num %= 10;
    if (num == 0) return words.toString();
    else words.append(" ");

    words.append(underTwenty[num]);
    return words.toString();
  }
}
