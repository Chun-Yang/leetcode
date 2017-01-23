class Solution(object):
    def zigzagLevelOrder(self, root):
        if not root:
            return []

        cur, groups, reverse = [root], [], False
        while True:
            nex, values = [], []

            for node in cur:
                values.append(node.val)
                if reverse:
                    node.right and nex.append(node.right)
                    node.left and nex.append(node.left)
                else:
                    node.left and nex.append(node.left)
                    node.right and nex.append(node.right)
            if not values:
                break

            cur = nex[::-1]
            groups.append(values)
            reverse = not reverse
        return groups
