class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
			graph.add(new ArrayList<>());
		}
		int[] indegree = new int [numCourses];
		for(int[] pre: prerequisites) {
			int start = pre[1];
			int end = pre[0];
			graph.get(start).add(end);
			indegree[end]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		// add the all 0 indegaree courses 
		 for(int i=0;i<numCourses;i++) {
			 if(indegree[i]==0){
				 queue.add(i);
			 }
		 }
		 ArrayList<Integer> ordering = new ArrayList<>();
		 int visited = 0 ;
		 while(!queue.isEmpty()){
			 int currentNode = queue.remove();
			 visited++;
			 ordering.add(currentNode);
			 for(int node : graph.get(currentNode)){
				 indegree[node]--;
				 if(indegree[node]==0){
					 queue.add(node);
				 }
			 }
		 }
		if(visited==numCourses){
			return ordering.stream()
    .mapToInt(Integer::intValue) // Convert Integer objects to int
    .toArray();
		}else{
			return new int[0];
		}

    }
}