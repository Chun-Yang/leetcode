// A strobogrammatic number is a number that looks the same
// when rotated 180 degrees (looked at upside down).
// Write a function to determine if a number is strobogrammatic.
// The number is represented as a string.

// For example, the numbers "69", "88", and "818" are all strobogrammatic.

// solution1: two pointers
// they all start from middle (different for even, same for odd)
// and move towards boundaries.
// use a map to determin the pair:
// 1 -> 1
// 6 -> 9
// 8 -> 8
// 9 -> 6
