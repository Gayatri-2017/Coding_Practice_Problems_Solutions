class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        tree_nodes = []
        bfs_queue = collections.deque()
        bfs_queue.append(root)

        while bfs_queue:
            nodes_in_a_level = []
            for i in range(len(bfs_queue)):
                node = bfs_queue.popleft()
                if node:
                    nodes_in_a_level.append(node.val)
                    bfs_queue.append(node.left)
                    bfs_queue.append(node.right)
            if nodes_in_a_level:
                tree_nodes.append(nodes_in_a_level)
        return tree_nodes
