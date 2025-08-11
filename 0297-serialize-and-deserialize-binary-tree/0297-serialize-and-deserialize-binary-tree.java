/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        //first val;
        sb.append(String.valueOf(root.val) );

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                queue.offer(curr.left);
                sb.append(",");
                sb.append(String.valueOf(curr.left.val));
            }
            else{
                sb.append(",");
                sb.append("null");
            }

            if(curr.right != null){
                queue.offer(curr.right);
                sb.append(",");
                sb.append(String.valueOf(curr.right.val));
            }
            else{
                sb.append(",");
                sb.append("null");
            }
        }
        sb.append("]");
        System.out.println(sb);

        return sb.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0 ){
            return null;
        }

        String[] arr = data.substring(1 , data.length() -1 ).split(",");
        
        // System.out.println(Arrays.toString(arr) + " -> " + arr.length);
        Queue<TreeNode> queue= new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        int pos = 1;
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            curr.left = arr[pos].equals("null") ? null : new TreeNode(Integer.valueOf(arr[pos]));
            pos++;
            curr.right = arr[pos].equals("null") ? null : new TreeNode(Integer.valueOf(arr[pos]));
            pos++;

            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));