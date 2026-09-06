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
    public int goodNodes(TreeNode root) {
        return rec(root, Integer.MIN_VALUE, 0);
    }

    public int rec(TreeNode root, int max, int count) {
        if(root == null) {
            return count;
        }

        if(root.val >= max) {
            // System.out.println("ele: "+ root.val);
            max = root.val;
            count++;
        }
        count = rec(root.left, max, count);
        count =  rec(root.right, max, count);
        return  count;
    }
}