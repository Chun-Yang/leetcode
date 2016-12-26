class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        origin = path.split('/')
        simplified = []
        for segment in origin:
            if not segment or segment == '.':
                continue
            elif segment == '..':
                if simplified:
                    simplified.pop()
            else:
                simplified.append(segment)

        return '/' + ('/').join(simplified)
