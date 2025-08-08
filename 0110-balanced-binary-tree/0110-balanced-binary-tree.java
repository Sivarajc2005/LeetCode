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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = getheight(root.left, 0);

        // System.out.println(root.val +" -> " + left);
        int right = getheight(root.right , 0);

        // System.out.println(root.val +" -> " + right);

        

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    static int getheight(TreeNode temp , int v){
        if(temp == null){
            return 0;
        }
        return Math.max(getheight(temp.left,v) , getheight(temp.right,v))+1; 
    }



}