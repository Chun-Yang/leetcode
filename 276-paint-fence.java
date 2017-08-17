// There is a fence with n posts, each post can be painted with one of the k
// colors. You have to paint all the posts such that no more than two adjacent
// fence posts have the same color. Return the total number of ways you can
// paint the fence.

























// f(0) = 1
// f(1) = k
// f(n) = f(n-1) * (k-1) + f(n-2) * (k-1)
//        different        same
