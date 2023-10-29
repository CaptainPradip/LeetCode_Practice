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
    public int sumNumbers(TreeNode root) {
      return  sumNumbers(root, new LinkedList<>());
    }

    public int sumNumbers(TreeNode root,LinkedList<Integer> list){
        if(root==null){
            return 0;
        }
        list.add(root.val);
        if(root.left==null && root.right==null){
            int sum =0 ;
            for(int n : list){
                sum=sum*10 + n;
            }
             list.removeLast();
            return sum;
           
        }
       int sum1=  sumNumbers(root.left,list);
       int sum2 = sumNumbers(root.right,list);
       list.removeLast();
       return sum1 + sum2;

    }
}