class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int totalPositions = n * n +1;
        int [] flatten = new int [totalPositions + 1 ]; 
        int position = 1;
        int target = n*n ;
        boolean leftToRight = true;
        int [] range = new int []{1,2,3,4,5,6};
        for(int row = n-1 ;row>=0;row--){
            if(leftToRight){
                for(int col = 0 ;col< n ; col++){
                    flatten[position++] = board[row][col];  
                }
            } else {
                for(int col = n-1 ;col>=0 ; col--){
                    flatten[position++] = board[row][col];
                }
            }
            leftToRight=!leftToRight;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean [totalPositions + 1];
        queue.add(1);
        visited[1] = true;
        int level = 0 ;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ;i< size;i++){
                int currentPosition = queue.remove();
                if(currentPosition==target){
                    return level;
                }
                for(int nPosition:range) {
                    int nextPosition = currentPosition + nPosition;
                    if(nextPosition<=target) {
                        if(flatten[nextPosition]!=-1){
                            nextPosition = flatten[nextPosition];
                        }
                        if(!visited[nextPosition]){
                            queue.add(nextPosition);
                            visited[nextPosition]= true;
                        }
                    }
                }
            }
            level++;
        }
       return -1;
    }
}
