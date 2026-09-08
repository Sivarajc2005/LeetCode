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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return rec(root, targetSum, 0, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> rec(TreeNode root, int target, int sum, List<Integer> temp, List<List<Integer>> sol) {
        if(root == null) {
            return sol;
        }

        sum += root.val;
        temp.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == target) {
                sol.add(new ArrayList<>(temp));
            }
        }

        sol = rec(root.left, target, sum, temp, sol);
        sol = rec(root.right, target, sum, temp, sol);
        temp.remove(temp.size() - 1);

        return sol; 
    }
}