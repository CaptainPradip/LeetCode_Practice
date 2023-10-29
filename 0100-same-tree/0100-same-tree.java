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
     TreeNode p ;
     TreeNode q ;
     Pair(TreeNode p, TreeNode q){
         this.p = p;
         this.q = q;
     }
 }
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<Pair> queue = new LinkedList<>();
        if(p==q){
            return true;
        }
        queue.add(new Pair(p,q));
        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            if(pair.p==null && pair.q!=null || pair.q==null && pair.p!=null){
                return false;
            }
            if(pair.p.left!=null && pair.q.left!=null){
                queue.add(new Pair(pair.p.left,pair.q.left));
            }else if(pair.p.left != pair.q.left){
               return false;
            }
            if(pair.p.right!=null && pair.q.right!=null){
                queue.add(new Pair(pair.p.right,pair.q.right));
            }else if(pair.p.right != pair.q.right ){
               return false;
            }
            if(pair.p.val!=pair.q.val){
                return false;
            }

        }
        return true;
    }
}