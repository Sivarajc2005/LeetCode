/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return deep(root, 1);
    }

    public int deep(TreeNode root, int val) {
        if(root == null) {
            return val - 1;
        }
        return Math.max(deep(root.left, val + 1), deep(root.right, val + 1));
    }
}