class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String,List<String>> graph = new HashMap<>();
        for(int i = 0 ;i < regions.size();i++) {
            String start = regions.get(i).get(0);
             graph.put(start,new ArrayList<>());
            for(int j=1 ; j < regions.get(i).size();j++) {
                String region = regions.get(i).get(j);
                graph.get(start).add(region);
                graph.put(region,new ArrayList<>());
            }
        }
       

      return  DFS(graph,regions.get(0).get(0),region1,region2);
    }
    public String DFS(Map<String,List<String>> graph, String root,String region1, String region2){
        Stack<String> stack = new Stack<>();
        Map<String, String> parents = new HashMap<>();
        Set<String> ancesstor = new HashSet<>();
        stack.push(root);
        parents.put(root," ");
        while(!parents.containsKey(region1)|| !parents.containsKey(region2)){
            String currentNode = stack.pop();
            for(String node : graph.get(currentNode)){
                parents.put(node,currentNode);
                stack.push(node);
            }
        }
        // Find the common ancestor
        while (!region1.equals(" ")) {
            ancesstor.add(region1);
            region1 = parents.get(region1);
        }
        while (!ancesstor.contains(region2)) {
            region2 = parents.get(region2);
        }
        return region2;
    }
   
}