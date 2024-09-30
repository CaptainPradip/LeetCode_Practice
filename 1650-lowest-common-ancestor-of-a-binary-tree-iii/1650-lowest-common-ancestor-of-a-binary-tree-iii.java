/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pNode = p;
        Node qNode = q;
        while (pNode != qNode) {

            if (pNode.parent != null) {
                pNode = pNode.parent;
            } else {
                pNode = q;
            }
            if (qNode.parent != null) {
                qNode = qNode.parent;
            } else {
                qNode = p;
            }
        }
        return qNode;
    }
}