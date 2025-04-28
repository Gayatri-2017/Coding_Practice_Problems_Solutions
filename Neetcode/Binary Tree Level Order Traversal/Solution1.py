# https://neetcode.io/problems/level-order-traversal-of-binary-tree

# Given a binary tree root, return the level order traversal of it as a nested list, where each sublist contains the values of nodes at a particular level in the tree, from left to right.

# Example 1:

#            1
#        /      \
#     2            3
#   /  \         /   \
# 4      5     6       7

# Input: root = [1,2,3,4,5,6,7]

# Output: [[1],[2,3],[4,5,6,7]]
# Example 2:

# Input: root = [1]

# Output: [[1]]
# Example 3:

# Input: root = []

# Output: []
# Constraints:

# 0 <= The number of nodes in both trees <= 1000.
# -1000 <= Node.val <= 1000
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        tree_nodes = [[] for _ in range(1001)]
        # Instead we can also initialize this to be empty list and append for every new level that is discovered within the traverse function
        #if len(tree_nodes) == level: tree_nodes.append([])
        # This way we can avoid initalizing to a big list of lists at once

        def traverse(level:int, root: Optional[TreeNode]):
            if root is None:
                return (None, None)

            tree_nodes[level].append(root.val)

            traverse(level+1, root.left)
            traverse(level+1, root.right)

        
        traverse(0, root)

        return [x for x in tree_nodes if x]
