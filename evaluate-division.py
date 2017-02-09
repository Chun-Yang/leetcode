from collections import defaultdict

class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        edges = defaultdict(set)
        weights = {}
        for i in range(len(equations)):
            start, end = equations[i]
            edges[start].add(end)
            edges[end].add(start)
            weights[(start, end)] = values[i]
            weights[(end, start)] = 1.0 / values[i]

        path = set()

        def dfs(start, end, value):
            if start == end:
                return value

            for node in edges[start]:
                if node not in path:
                    path.add(node)
                    val = dfs(node, end, value * weights[(start, node)])
                    path.remove(node)
                    if val != -1.0:
                        return val

            return -1.0

        res = []
        for start, end in queries:
            if end not in edges:
                res.append(-1.0)
            else:
                res.append(dfs(start, end, 1.0))
        return res
