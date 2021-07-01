'''
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        self.inorder_dict = {}
        self.current_preorder_index = -1
        
        # Assumming the elements in the inorder array are distinct
        for ind, elem in enumerate(inorder):
            self.inorder_dict[elem] = ind
            
        return self.solve(0, len(inorder)-1, inorder, preorder)
        
    def solve(self, start, end, inorder, preorder):
        if(start>end):
            return None
        
        self.current_preorder_index += 1
        current_root = TreeNode(preorder[self.current_preorder_index])
        
        if(start == end):
            return current_root
        
        current_root_pos = self.inorder_dict[preorder[self.current_preorder_index]]
        current_root.left = self.solve(start, current_root_pos-1, inorder, preorder)
        current_root.right = self.solve(current_root_pos+1, end, inorder, preorder)
        
        return current_root
    
    
