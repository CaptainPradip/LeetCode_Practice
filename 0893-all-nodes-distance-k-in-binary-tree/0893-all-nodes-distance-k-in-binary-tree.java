/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  
     public static Map<Integer, List<Integer>> convertTreeToGraph(TreeNode root) {
       Map<Integer, List<Integer>>  graph = new HashMap<>();
        buildGraph(root, graph);
        return graph;
    }

    private static void buildGraph(TreeNode node, Map<Integer, List<Integer>> graph) {
        if (node == null) {
            return;
        }

        // Add the current node to the graph
        graph.putIfAbsent(node.val, new ArrayList<>());

        // Add edges to left and right children
        if (node.left != null) {
            graph.get(node.val).add(node.left.val);
            graph.putIfAbsent(node.left.val, new ArrayList<>());
            graph.get(node.left.val).add(node.val);
            buildGraph(node.left, graph);
        }
        if (node.right != null) {
            graph.get(node.val).add(node.right.val);
            graph.putIfAbsent(node.right.val, new ArrayList<>());
            graph.get(node.right.val).add(node.val);
            buildGraph(node.right, graph);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph =  convertTreeToGraph(root);
        Queue<Integer> queue = new  LinkedList<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new  HashSet<>();
        queue.add(target.val);
        visited.add(target.val);
        int level = 0;
        while(!queue.isEmpty()){
            if(level==k){
                result.add(queue.remove());
                continue;
            } 
            int size = queue.size();
            for(int i=0;i < size;i++){
                Integer currentNode = queue.remove();
               
                for(Integer node :graph.get(currentNode)){
                    
                    if(!visited.contains(node)){
                        queue.add(node);
                        visited.add(node);
                    }      
                }
            }

            level++;
        }
        return result;
    }
}