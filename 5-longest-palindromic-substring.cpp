class Solution {
public:
    string longestPalindrome(string s) {
      int start = 0, end = 0, length = 0;
      string longest = "";
      for (int i=0; i<s.size() * 2 - 1; i++) {
        int left = i / 2, right = (i + 1) / 2;
        while(left >= 0 && right < s.size() && s[left] == s[right]) {
          if (right - left + 1 > length) {
            length = right - left + 1;
            longest = s.substr(left, length);
          }
          left--;
          right++;
        }
      }
      return longest;
    }
};
