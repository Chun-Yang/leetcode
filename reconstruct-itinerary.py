class Solution(object):
    def findItinerary(self, tickets):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        routes = {}
        for start, end in tickets:
            if start in routes:
                routes[start].append(end)
            else:
                routes[start] = [end]

        for start in routes:
            routes[start] = sorted(routes[start])

        itinerary = ['JFK']

        def dfs():
            if not routes:
                return True

            start = itinerary[-1]

            if start not in routes:
                return False

            ends = routes[start][:]
            for i in range(len(ends)):
                if i > 0 and ends[i] == ends[i - 1]:
                    continue

                itinerary.append(ends[i])
                routes[start] = ends[:i] + ends[i + 1:]
                if not routes[start]:
                    del routes[start]

                if dfs():
                    return True

                routes[start] = ends
                itinerary.pop()

            return False

        dfs()

        return itinerary

# Solution().findItinerary([["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]])
