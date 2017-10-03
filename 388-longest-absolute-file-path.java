// Suppose we abstract our file system by a string in the following manner:

// The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

// dir
//     subdir1
//     subdir2
//         file.ext
// The directory dir contains an empty
// sub-directory subdir1 and a sub-directory subdir2 containing a file
// file.ext.

// The string
// "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
// represents:

// dir
//     subdir1
//         file1.ext
//         subsubdir1
//     subdir2
//         subsubdir2
//             file2.ext

// We are interested in finding the longest (number of characters) absolute
// path to a file within our file system. For example, in the second example
// above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and
// its length is 32 (not including the double quotes).

// Given a string representing the file system in the above format, return the
// length of the longest absolute path to file in the abstracted file system.
// If there is no file in the system, return 0.

// Note: The name of a file contains at least a . and an extension. The name of
// a directory or sub-directory will not contain a ..
// Time complexity required: O(n) where n is the size of the input string.

// Notice that a/aa/aaa/file1.txt is not the longest file path, if there is
// another path aaaaaaaaaaaaaaaaaaaaa/sth.png.

// Solution1: dfs backtracking
import java.util.*;

class Solution {
  public int lengthLongestPath(String input) {
    int maxLength = 0;
    int length = 0;
    LinkedList<Integer> folderLengths = new LinkedList<>();
    String[] tokens = input.split("\n");

    for (int i=0; i<tokens.length; i++) {
      int depth = 0;
      for (int j=0; j<tokens[i].length(); j++) {
        if (tokens[i].charAt(j) == '\t') depth++;
        else break;
      }
      int depthToRemove = folderLengths.size() - depth;
      for (int j=0; j<depthToRemove; j++) {
        length -= folderLengths.removeLast();
      }
      boolean isFile = tokens[i].contains(".");
      if (isFile) {
        maxLength = Math.max(maxLength, length + tokens[i].length() - depth);
      } else {
        // 1 is for '/'
        int l = tokens[i].length() + 1 - depth;
        length += l;
        folderLengths.add(l);
      }
    }

    return maxLength;
  }
}
