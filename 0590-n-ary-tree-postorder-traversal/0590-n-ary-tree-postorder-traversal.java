/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> result = new LinkedList<>();
    public List<Integer> postorder(Node root) {

        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.addFirst(current.val);
            if (current.children.size() != 0) {
                for (Node n : current.children) {
                    if (n != null) {
                        stack.push(n);
                    }
                }
            }
        }
        return result;
    }
}