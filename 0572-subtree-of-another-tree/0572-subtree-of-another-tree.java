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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

		if(root==null){
			return false;
		}
		if(isIdenticalTree(root, subRoot)){
			return true;
		}
		return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        
    }
	public boolean isIdenticalTree(TreeNode root, TreeNode subRoot){

		if(root ==null || subRoot==null){
			return root ==null &&  subRoot==null ;
		}

		return root.val == subRoot.val && isIdenticalTree(root.left,subRoot.left
		) && isIdenticalTree(root.right ,subRoot.right);

	}
}

