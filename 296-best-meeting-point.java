// A group of two or more people wants to meet and minimize the total travel
// distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home
// of someone in the group. The distance is calculated using Manhattan Distance,
//    where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

// For example, given three people living at (0,0), (0,4), and (2,2):

// 1 - 0 - 0 - 0 - 1
// |   |   |   |   |
// 0 - 0 - 0 - 0 - 0
// |   |   |   |   |
// 0 - 0 - 1 - 0 - 0
// The point (0,2) is an ideal meeting point, as the total travel
// distance of 2+2+2=6 is minimal. So return 6.



// https://discuss.leetcode.com/topic/28150/am-i-the-only-person-who-don-t-know-why-median-could-give-shortest-distance/8
// house location: [1,6] -> best point can be anywhere between 1~6
// house location: [1,2,6] -> best point is 2, because 1 and 6 don't care where it is as long as the point is between them
// house location: [1,2,3,6] -> best point is 2.5(actually 2 or 3)
// For a sequence [a1, a2 ... an], dist(a1,bestPoint)+dist(an,bestPoint) is constant and equal to dist(a1,an)
// https://math.stackexchange.com/questions/113270/the-median-minimizes-the-sum-of-absolute-deviations




















// Solution1: O(n * m * k)
// for each point, we check the total distance
// Solution2: O((n + m) * k)
// seperate two dimentions
