
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int start = pre[1];
            int end = pre[0];
            graph.get(start).add(end);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] instack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCycle(i, graph, visited, instack)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean[] instack) {
        if (instack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        instack[node] = true;
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (isCycle(nei, adj, visited, instack)) {
                return true;
            }
        }
        instack[node] = false;
        return false;

    }
}