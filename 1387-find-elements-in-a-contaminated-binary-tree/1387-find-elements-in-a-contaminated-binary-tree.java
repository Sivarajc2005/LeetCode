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
class FindElements {
    HashSet<Integer> set = new HashSet<>();
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        rec(root);
    }

    void rec(TreeNode root){
        if(root == null){
            return;
        }
        if(root.val == -1){
            root.val = 0;
            set.add(0);
        }
        // System.out.print(root.val+"-> ");

        if(root.left != null){
            int val = 2 * root.val + 1;
            root.left.val = val;
            set.add(val);
        }
        if(root.right != null){
            int val = 2 * root.val + 2;
            root.right.val = val;
            set.add(val);
        }
        
        rec(root.left);
        rec(root.right);
    }
    
    public boolean find(int target) {
        // return rr(target , root);
        return set.contains(target);
    }

    // boolean rr(int tar , TreeNode temp){
    //     if(temp == null){
    //         return false;
    //     }
    //     System.out.print(temp.val + "-->");
    //     if(temp.val == tar){
    //         return true;
    //     }

    //     return rr(tar , temp.left) || rr(tar , temp.right);
    // }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */