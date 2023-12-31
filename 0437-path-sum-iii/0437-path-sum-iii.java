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
    int count = 0;
    int k ;
    HashMap<Long,Integer> prefixSumMap = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        prefixSumMap.put(0L,1);
        preorderTraversal(root,0L);
        return count;
    }
    /**
        This Problem can be solve by prefix sum;
    */
    public void preorderTraversal(TreeNode root,long currentSum){
        if(root==null){
            return;
        }
         // current prefix sum
        currentSum+=root.val;
        // number of times the curr_sum − k has occured already, 
        // determines the number of times a path with sum k 
        // has occured upto the current node
        if(prefixSumMap.containsKey(currentSum-k)){
            count+=prefixSumMap.get(currentSum-k);
        }
        prefixSumMap.put(currentSum,prefixSumMap.getOrDefault(currentSum,0)+1);
        preorderTraversal(root.left,currentSum);
        preorderTraversal(root.right,currentSum);
        // remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        prefixSumMap.put(currentSum,prefixSumMap.get(currentSum)-1);
    }
}