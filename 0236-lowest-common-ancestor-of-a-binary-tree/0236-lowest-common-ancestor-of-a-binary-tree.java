/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Set<TreeNode> ancesstor = new HashSet<>();
        stack.push(root);
        parents.put(root,null);
        while(!parents.containsKey(p)|| !parents.containsKey(q)){
            TreeNode currentNode = stack.pop();
            if(currentNode.left!=null){
                parents.put(currentNode.left,currentNode);
                stack.push(currentNode.left);
            }
             if(currentNode.right!=null){
                parents.put(currentNode.right,currentNode);
                stack.push(currentNode.right);
            }
        }
        while(p!=null){
            ancesstor.add(p);
            p= parents.get(p);
        }
         while(!ancesstor.contains(q)){
            q = parents.get(q);
        }
        return q;
    }
}