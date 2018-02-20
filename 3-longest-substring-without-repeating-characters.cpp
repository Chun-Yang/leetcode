class Solution {
public:
    int lengthOfLongestSubstring(string s) {
      vector<int> indexes(256, -1);
      int left = 0;
      int length = 0;
      for(int right=0; right<s.size(); right++) {
        if (indexes[s[right]] >= left) {
          left = indexes[s[right]] + 1;
        } else {
          length = max(length, right - left + 1);
        }
        indexes[s[right]] = right;
      }
      return length;
    }
};
