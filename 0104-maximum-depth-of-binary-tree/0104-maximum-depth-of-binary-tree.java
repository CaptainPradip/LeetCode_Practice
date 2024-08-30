/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue =new ArrayDeque<>();

        if(root==null){
            return 0;
        }
        queue.add(root);
        int level=0;
        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.remove();
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            level++;

        }
        return level;
    }
}