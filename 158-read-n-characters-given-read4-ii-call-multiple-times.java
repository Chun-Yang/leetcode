// The API: int read4(char *buf) reads 4 characters at a time from a file.

// The return value is the actual number of characters read.
// For example, it returns 3 if there is only 3 characters left in the file.

// By using the read4 API, implement the function int read(char *buf, int n)
// that reads n characters from the file.

// Note:
// The read function may be called multiple times.


// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times

// solution1:
// NOTE: we need to keep reading the file in the following testcase
// so we need to keep track of where are we, is that eof already?
// what is the last position in the buffer and what is the length in the buffer?