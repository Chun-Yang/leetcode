public class Solution {
  public String fractionToDecimal(int numerator, int denominator) {
    StringBuilder sb = new StringBuilder();
    String sign = (numerator > 0 == denominator > 0 || numerator == 0) ? "" : "-";
    sb.append(sign);

    long num = Math.abs((long)numerator);
    long den = Math.abs((long)denominator);
    sb.append(num / den);
    long rem = num % den;

    if (rem == 0) return sb.toString();
    sb.append(".");

    HashMap<Long, Integer> rems = new HashMap<>();
    while (!rems.containsKey(rem)) {
      rems.put(rem, sb.length());
      rem = 10 * rem;
      sb.append(rem / den);
      rem = rem % den;
    }
    sb.insert(rems.get(rem), "(");
    sb.append(")");

    return sb.toString().replace("(0)", "");
  }
}
