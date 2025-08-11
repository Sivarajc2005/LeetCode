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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list= new ArrayList<>();
        list = rec(list , root);
        return list.get(k-1);
    }

    static ArrayList<Integer> rec(ArrayList<Integer> list , TreeNode temp ){
        if(temp == null){
            return list;
        }

        list = rec(list , temp.left);
        list.add(temp.val);
        list = rec(list , temp.right);
        
        return list;
    }
}