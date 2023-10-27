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
class BSTIterator {
    ArrayList<Integer> inOrder= new ArrayList<>();
    int currentIndex ;
    public BSTIterator(TreeNode root) {
        this.inOrder = new ArrayList<>();
        this.currentIndex=-1;
        this._inOrderTracv(root);
    }
    private void _inOrderTracv(TreeNode root){
        if(root==null){
            return;
        }
        this._inOrderTracv(root.left);
        this.inOrder.add(root.val);
        this._inOrderTracv(root.right);

    }
    
    public int next() {
        return this.inOrder.get(++this.currentIndex);
    }
    
    public boolean hasNext() {
        return this.currentIndex + 1 < this.inOrder.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */