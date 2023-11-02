class Solution {
    int count=0 ;

    public int minReorder(int n, int[][] connections) {
         Map<Integer, List<int []>> graph = buildGraph(connections); 
         DFS(graph,0,-1);
         return count;
    }
    public void DFS(Map<Integer, List<int []>> graph, int node, int parent ){
        if(!graph.containsKey(node)){
            return ;
        }
        for(int [] nei :graph.get(node)){
            int child = nei[0];
            int sign = nei[1];
            if(child!=parent){
                count+=sign;
                DFS(graph,child,node);
            }
        }
    }
    public  Map<Integer, List<int []>> buildGraph(int[][] connections){
        Map<Integer, List<int []>> graph = new HashMap<>();
        for(int i =0; i< connections.length;i++){
            if(!graph.containsKey(connections[i][0])){
                graph.put(connections[i][0],new ArrayList<>());
            }
             if(!graph.containsKey(connections[i][1])){
                graph.put(connections[i][1],new ArrayList<>());
            }
            graph.get(connections[i][0]).add(new int []{ connections[i][1],1});      
            graph.get(connections[i][1]).add(new int []{ connections[i][0],0});   
        }

        return graph;
    }
}