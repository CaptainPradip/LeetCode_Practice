class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int totalPositions = n * n +1;

        // Make given board in flatten Array
        int [] flatten = new int [totalPositions + 1 ]; 
        int position = 1;
        // Target is last index;
        int target = n*n ;
        // Dice Range 
        int [] diceRange = new int []{1,2,3,4,5,6};

        // Logic for the Flatten the array 
         boolean leftToRight = true;
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
        // Do the BFS 
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ;i< size;i++){
                int currentPosition = queue.remove();
                if(currentPosition==target){
                    return level;
                }
                // Get all Possible Dice number 
                for(int diceNumber:diceRange) {
                    int nextPosition = currentPosition + diceNumber;
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
