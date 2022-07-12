# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        # sorted_nums = []
        # self.kthSmallestHelp(node, sorted_nums)
        # return sorted_nums[k - 1]
        result = [0, -1]
        self.kthSmallestIndex(root, k, result)
        return result[1]

    def kthSmallestHelp(self, node, sorted_nums):

        if not node:
            return

        self.kthSmallestHelp(node.left, sorted_nums)
        sorted_nums.append(node.val)
        self.kthSmallestHelp(node.right, sorted_nums)


    def kthSmallestIndex(self, node, k, order_num):

        if not node or order_num[0] == k:
            return

        self.kthSmallestIndex(node.left, k, order_num)

        order_num[0] += 1
        if order_num[0] == k:
            order_num[1] = node.val

        print(str(order_num[0]) + " smallest is " + str(node.val))
        return

        self.kthSmallestIndex(node.right, k, order_num)
