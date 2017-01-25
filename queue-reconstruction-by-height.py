class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        queue = []
        for h, k in sorted(people, key=lambda p: [-p[0], p[1]]):
            queue.insert(k, [h, k])
        return queue
