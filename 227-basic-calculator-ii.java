public class Solution {
  public int calculate(String s) {
    int plus = 0;
    int mult = 1;
    char plusSign = '+';
    char multSign = '*';
    int num = 0;

    char[] chars = s.toCharArray();
    for (int i=0; i<chars.length; i++) {
      switch(chars[i]) {
        case '+':
        case '-':
          plus += (plusSign == '+' ? 1 : -1) * mult;
          plusSign = chars[i];
          mult = 1;
          multSign = '*';
          break;
        case '*':
        case '/':
          multSign = chars[i];
        case ' ':
          break;
        default:
          // this is number
          num = 0;
          while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
            num = num * 10 + (chars[i] - '0');
            i++;
          }
          if (multSign == '*') mult *= num;
          else mult /= num;
          i--;
          break;
      }
    }

    plus += (plusSign == '+' ? 1 : -1) * mult;

    return plus;
  }
}
