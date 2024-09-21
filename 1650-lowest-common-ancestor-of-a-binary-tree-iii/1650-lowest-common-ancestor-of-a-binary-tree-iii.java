/*
// Definition for a Node.
class FamilyNode {
    public int val;
    public Node parent;
		Public List<Node> childerns;
		FamilyNode(String name){
			this.parent= null;
		}
		addchild
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> hash = new HashSet<Node>();
        while (p != null) {
            hash.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (hash.contains(q)) {
                return q;
            }
            q = q.parent;
        }

        return q;
    }

}