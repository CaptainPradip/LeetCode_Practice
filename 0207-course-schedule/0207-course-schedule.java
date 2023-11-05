class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
		for(int i=0;i< numCourses;i++){
			graph.add(new ArrayList<>());
		}
		int[] indegree = new int [numCourses];
		for(int[] prerequisite: prerequisites){
			int start = prerequisite[1];// its start node 
			int end = prerequisite[0] ;// as the course end
			graph.get(start).add(end);
			indegree[end]++;
		}
		// add all 0 indegree nodes in queue;
		Queue<Integer> queue = new LinkedList<>();
		int visitedNode = 0; 
		for(int i=0;i< numCourses;i++){
			if(indegree[i]==0){
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()){
			int currentNode = queue.remove();
			visitedNode++;
			for(int neibor : graph.get(currentNode)){
				indegree[neibor]--;
				if(indegree[neibor]==0){
					queue.add(neibor);
				}
			}

		}
		return visitedNode== numCourses;
    }
}