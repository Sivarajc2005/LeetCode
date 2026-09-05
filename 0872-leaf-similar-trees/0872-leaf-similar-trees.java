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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ls1 = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>();
        List<Integer> ele1 = traverse(root1, ls1);
        List<Integer> ele2 = traverse(root2, ls2);
        int lenls1 = ele1.size();
        int lenls2 = ele2.size();
        // System.out.println("ele1: "+ lenls1+ " Array: "+ ele1);
        // System.out.println("ele2: "+ lenls2+ " Array: "+ ele2);
        if(lenls1 != lenls2) {
            return false;
        }
        for(int i = 0; i < lenls1; i++) {
            if(!ele1.get(i).equals(ele2.get(i))) {
                // System.out.println("ele1: "+ ele1.get(i)+ " ele2: "+ ele2.get(i));
                return false;
            }
        }
        return true;
    }

    private List<Integer> traverse(TreeNode root, List<Integer> ele) {
        if(root.left == null && root.right == null) {
            ele.add(root.val);
            return ele;
        }
        if(root.left != null) {
            ele = traverse(root.left, ele);
        }
        if(root.right != null) {
            ele = traverse(root.right, ele);
        }
        return ele;
    }
}