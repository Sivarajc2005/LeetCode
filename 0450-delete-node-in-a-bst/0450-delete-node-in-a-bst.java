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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val == key) {
            return arrange(root);
        }

        rec(root, key);

        return root;

    }

    public void rec(TreeNode root, int key) {
        if(root == null) {
            return;
        }

        if(root.left != null && root.left.val == key) {
            root.left = arrange(root.left);
            // return parent;
        } else if( root.right != null && root.right.val == key) {
            root.right = arrange(root.right);
            // return parent;
        }
        
        if(root.val > key) {
            rec(root.left, key);
        } else {
            rec(root.right, key);
        }
    }

    public TreeNode arrange(TreeNode root) {
        if(root.left == null && root.right == null) {
            // handle leaf node
            return null;
        } if(root.left == null) {
            root = root.right;
            return root;
        } else if(root.right == null) {
            root = root.left;
            return root;
        }

        // save the del root left
        TreeNode saveFisLeft = root.left;

        // save the replacement's left NOTE: it may be null no issues on it.
        TreeNode saveLasLeft = root.right.left;

        // replace the replacement's left with del left
        root.right.left = saveFisLeft;

        // move to the right of the left
        TreeNode lastRig = lastRig(saveFisLeft);

        // adding the replacement's left the most right of the left 
        lastRig.right = saveLasLeft;

        return root.right;
    }

    public TreeNode lastRig(TreeNode root) {
        if(root.right == null) {
            return root;
        }
        return lastRig(root.right);
    }
}