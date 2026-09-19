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
    class Track {
        int level;
        TreeNode node;

        Track(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public int maxLevelSum(TreeNode root) {
        List<Track> track = new ArrayList<>();
        track.add(new Track(0, root));
        track = rec(root ,track, 0);

        int len = track.size();
        int max = Integer.MIN_VALUE;
        int currlevel = -1;
        int tempSum = Integer.MIN_VALUE;
        int place = 0;

        // for(int i = 0; i < len; i++) {
        //     Track curr = track.get(i);
        //     System.out.println("place: "+ curr.level+ " val: "+ curr.node.val);
        // }

        // System.out.println("max: "+ max);

        for(int i = 0; i < len; i++) {
            Track curr = track.get(i);
            if(curr.level != currlevel) {
                if(max < tempSum) {
                    max = tempSum;
                    place = currlevel + 1;
                }
                max = Math.max(max, tempSum);
                tempSum = 0;
                currlevel = curr.level;
            }

            tempSum += curr.node.val;

            if(i == len - 1) {
               if(max < tempSum) {
                    max = tempSum;
                    place = currlevel + 1;
                }
            }

            // System.out.println("tempSum: "+ tempSum + " maxSum: "+ max +" maxLevel: "+ place);
        }

        return place;
    }

    public List<Track> rec(TreeNode node, List<Track> track, int currInd) {

        Track curr = track.get(currInd);
        if(node.left != null) {
            track.add(new Track(curr.level + 1, node.left));
        }
        if(node.right != null) {
            track.add(new Track(curr.level + 1, node.right));
        }

        if(currInd != track.size() - 1) {
            track = rec(track.get(currInd + 1).node, track, currInd+1);
        }

        return track;
    }
}