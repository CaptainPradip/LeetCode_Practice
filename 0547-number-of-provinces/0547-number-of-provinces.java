class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean [n] ;
        for(int i= 0;i< n ;i++) {
            if(!visited[i]){
                count++;
                DFS(isConnected,i, visited) ;
            }
        }
        return count;
    }

    public void DFS(int[][] isConnected, int i , boolean [] visited){
        visited[i]= true ;
        for(int j=0; j< isConnected[i].length;j++){
            if(isConnected[i][j]== 1 && !visited[j]){
                DFS(isConnected,j, visited) ;
            }
        }
    }
}