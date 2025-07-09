class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. create a Graph
        // 2. check indegree
        // 3. add all 0 degree nodes to queue
        // 4. once visited then reduce the degree
        // 5. check the all visited nodes with total nodes
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int start = pre[0];
            int end = pre[1];
            graph.get(start).add(end);
            indegree[end]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int visitedNodes = 0;
        while (!queue.isEmpty()) {
            int currentNode = queue.remove();
            visitedNodes++;
            for (int nei : graph.get(currentNode)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        return visitedNodes == numCourses;
    }

}