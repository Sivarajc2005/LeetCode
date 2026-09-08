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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        return check(root, targetSum, 0);
    }

    public boolean check(TreeNode root, int target, int val) {
        if(root == null) {
            return false;
        } else if(root.left == null && root.right == null) {
            return (val + root.val) == target;
        }

        return check(root.left, target, val + root.val) || check(root.right, target, val + root.val);
    }
}