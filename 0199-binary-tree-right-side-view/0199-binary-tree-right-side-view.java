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
    
    class Sol {
        int place;
        TreeNode node;

        public Sol(int place, TreeNode node) {
            this.place = place;
            this.node = node;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        
        List<Sol> sol = new ArrayList<>();
        sol.add(new Sol(0, root));
        sol = rec(root, sol, 0);

        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        // ans.add(sol.get(0).node.val);

        // for(int i = 0; i < sol.size(); i++) {
        //     Sol curr = sol.get(i);
        //     System.out.println("curr val: { place: " + curr.place + " node: "+ curr.node.val + " }");
        // }
        if(sol.size() == 1) {
            ans.add(root.val);
            return ans;
        }
        for(int i = 1; i < sol.size(); i++) {
            Sol curr = sol.get(i);
            Sol pre = sol.get(i-1);

            // System.out.println("pre val: { place: " + pre.place + " node: "+ pre.node.val + " }");
            // System.out.println("curr val: { place: " + curr.place + " node: "+ curr.node.val + " }");

            if(pre.place != curr.place) {
                ans.add(pre.node.val);

                // System.out.println("Added pre: "+ pre.node.val);

                // if(i == sol.size() - 1 && sol.size() != 1) {
                //     ans.add(curr.node.val);
                //     // System.out.println("Added curr: "+ curr.node.val);
                
                // }
            }

            if(i == sol.size() - 1 && sol.size() != 1) {
                ans.add(curr.node.val);
                // System.out.println("Added curr: "+ curr.node.val);
            
            }
        }

        return ans;
    }

    public List<Sol> rec(TreeNode node, List<Sol> sol, int currInd) {
        if(node == null) {
            return sol;
        }

        Sol curr = sol.get(currInd);

        if(node.left != null) {
            sol.add(new Sol(curr.place + 1, node.left));
        }
        if(node.right != null) {
            sol.add(new Sol(curr.place + 1, node.right));
        }
        

        if(currInd != sol.size() - 1) {
           sol = rec(sol.get(currInd + 1).node, sol, currInd + 1);
        }

        return sol;
    }

    
}