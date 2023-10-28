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
        List<Integer> leafNodes1 = new ArrayList<>();
         List<Integer> leafNodes2 = new ArrayList<>();
         dfs(root1,leafNodes1);
         dfs(root2,leafNodes2);
         return leafNodes1.equals(leafNodes2);

    }
    public void dfs(TreeNode root1, List<Integer> leafNodes){
        if(root1!=null){
            if(root1.left==null && root1.right==null){
                leafNodes.add(root1.val);
            }
            dfs(root1.left,leafNodes);
            dfs(root1.right,leafNodes);
        }
    }
}