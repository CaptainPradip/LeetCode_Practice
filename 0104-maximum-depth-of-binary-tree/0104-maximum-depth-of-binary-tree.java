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
 class Pair{
    public TreeNode node;
    public int val;
     Pair(TreeNode node,int val){
         this.node = node;
         this.val = val;
     }
 }
class Solution {
    public int maxDepth(TreeNode root) {
        Stack<Pair> stack= new Stack<>();
        if(root==null){
            return 0;
        }
        stack.push(new Pair(root,1));
        int level = 0;
        while(!stack.isEmpty()){
          //  for(int i=0 ;i<size;i++){
                Pair currentNode = stack.pop();
                if(currentNode.node.left==null && currentNode.node.right==null){
                    level = Math.max(level,currentNode.val);
                }
                if(currentNode.node.left!=null){
                    stack.push(new Pair(currentNode.node.left,currentNode.val+1));
                }
                if(currentNode.node.right!=null){
                    stack.push(new Pair(currentNode.node.right,currentNode.val+1));
                }

        }
        return level;
    }
}