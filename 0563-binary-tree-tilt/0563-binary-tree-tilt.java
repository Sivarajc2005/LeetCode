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
    static int sum;
    public int findTilt(TreeNode root) {
        sum = 0;
        rec(root);
        return sum;
    }

    static int rec(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = rec(root.left);
        int right = rec(root.right);

        sum += Math.abs(right - left);

        // System.out.println("sum : "+ left +" - "+right +" = " + sum + " -- > root :" + root.val );

        return root.val + left + right;
    }
}