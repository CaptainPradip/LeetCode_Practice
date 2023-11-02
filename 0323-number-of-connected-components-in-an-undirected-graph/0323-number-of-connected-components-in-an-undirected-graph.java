class Solution {
    public int countComponents(int n, int[][] edges) {
        //1. create the adjacencyList 
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0; i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        //2. create a visited array having total nodes
        boolean[] visited = new boolean [n];
        int count=0;
        //3. check all the nodes and to dfs make all node visited true
        for(int i=0; i< n;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,adjacencyList);
		    }
        }
        return count;
    }

    public void dfs(int startNode,boolean[] visited,List<List<Integer>> adjacencyList){
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
		while (!stack.isEmpty()) {
			int node = stack.pop();
			for (int neighbour : adjacencyList.get(node)) {
				if(visited[neighbour]){
                    continue;
                 }
                visited[neighbour]=true;
				stack.push(neighbour);
            }
		}
    }

}