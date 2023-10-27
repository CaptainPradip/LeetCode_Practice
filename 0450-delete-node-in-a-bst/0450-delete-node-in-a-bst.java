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
        if (root == null) return null;

        if(root.val>key){
            root.left= deleteNode(root.left,key);
        }else if( root.val < key){
            root.right = deleteNode(root.right,key);
        }else{
              if(root.left==null && root.right==null){
                  root=null;
              } else if(root.right!=null){
                  TreeNode temp = inOrderSuccessor(root.right);
                  root.val = temp.val;
                  root.right = deleteNode(root.right,root.val);
              } else if( root.left!=null){
                  TreeNode temp = inOrderPrecessor(root.left);
                  root.val = temp.val;
                  root.left = deleteNode(root.left,root.val);
              }
        }
        return root;
       
    }

    public TreeNode inOrderPrecessor(TreeNode root){
         while(root!=null && root.right!=null){
             root = root.right;
         }
         return root;
    }
    public TreeNode inOrderSuccessor(TreeNode root){
         while(root!=null && root.left!=null){
             root = root.left;
         }
         return root;
    }
}