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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return che(root , set, k);

    }

    static boolean che(TreeNode temp , HashSet<Integer> set , int k){
        if(temp == null){
            return false;
        }

        int rem = k - temp.val;
        if(set.contains(rem)){
            return true;
        } 
        set.add(temp.val);
        return che(temp.left,set,k) || che(temp.right,set,k);
    }
}