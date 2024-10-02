class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 1.Create Graph with undirectional Graph from each edges;
        // 2. create the set for keeping visited track
        // use BFS
        // add source to the queue and visit
        // iterate until queue is empty
        //
        // remove the first node
        // check the currentNode == destination;return true
        // get the size of the nodes
        // add the level to the make add only non visited node
        // make it visited
        // add into queue

        // return false;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);// 0 - [1,2]
            graph.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);// 1 - [0,2] 2 -[0,1]
        }
        Set<Integer> visited = new HashSet<>();// 0,1,2
        Queue<Integer> queue = new ArrayDeque<>();// 2,
        queue.add(source);// 0
        visited.add(source);// 0
        while (!queue.isEmpty()) {
            int currentNode = queue.remove(); // 2
            if (currentNode == destination) {
                return true;
            }
            for (int nextNode : graph.get(currentNode)) { // 0
                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    queue.add(nextNode);
                }
            }
        }
        return false;

    }
}