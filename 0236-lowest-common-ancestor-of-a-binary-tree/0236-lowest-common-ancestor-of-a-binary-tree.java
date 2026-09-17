/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // static boolean pval;
    // static boolean qval;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // pval = false;
        // qval = false;
        return rec(root , p , q);
    }

    static TreeNode rec(TreeNode temp , TreeNode p , TreeNode q){
        if(temp == null){
            return temp;
        }

        

        TreeNode left = rec(temp.left , p , q);
        TreeNode right = rec(temp.right , p , q);

        
        if(temp == p){
            // pval = true;
            return temp;
        }
        else if(temp == q){
            // qval = true;
            return temp;
        }
        if(left != null && right!= null){
            return temp;
        }
        
        return (left != null) ? left : right;
    }
}