/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        // 1.
        if (root == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node trav = root;
        while (trav != null) {
            stack.push(trav);
            trav = trav.left;
        }

        Node start = stack.peek();
        Node finish = null;
        while (!stack.isEmpty()) {
            trav = stack.pop();
            
            if (finish != null) {
                finish.right = trav;
            }

            trav.left = finish;

            finish = trav;

            trav = trav.right;
            if (trav != null) {
                while (trav != null) {
                    stack.push(trav);
                    trav = trav.left;
                }
            }
        }
        start.left = finish;
        finish.right = start;
        return start;

    }
}