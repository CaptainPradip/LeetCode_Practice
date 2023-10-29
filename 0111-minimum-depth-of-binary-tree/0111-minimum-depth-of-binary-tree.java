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
class Pair {
    TreeNode node;
    int val;
    Pair(TreeNode node , int val){
        this.node = node;
        this.val = val; 
    }
}
class Solution {
    public int minDepth(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        if(root==null){
            return 0;
        }
        queue.add(new Pair(root,1));
        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            if(pair.node.left==null && pair.node.right==null){
                return pair.val;
            }
            if(pair.node.left!=null){
                queue.add(new Pair(pair.node.left,pair.val+1));
            }
            if(pair.node.right!=null){
                queue.add(new Pair(pair.node.right,pair.val+1));
            }
        }
        return -1;
    }
}