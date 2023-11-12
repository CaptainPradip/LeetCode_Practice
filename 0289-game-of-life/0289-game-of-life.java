class Solution {
    public void gameOfLife(int[][] board) {
        int rows= board.length;
        int cols= board[0].length;
        int [][] newBoard= new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j < cols;j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        for(int row=0; row < rows;row++) {
            for(int col=0;col < cols ; col++) {
                int liveNeighbor = 0;
                int top = Math.max(0,row-1);
                int bottom = Math.min(rows-1,row + 1);
                int left= Math.max(0,col-1);
                int right = Math.min(cols-1, col + 1 );
                for(int i= top ;i<= bottom;i++){
                     for(int j= left ;j<= right;j++){
                        if(!(i==row && j==col) &&  newBoard[i][j]==1){
                            liveNeighbor++;
                        }
                    }
                }
                if(liveNeighbor<2 || liveNeighbor>3){
                    board[row][col]=0;
                }else if(liveNeighbor==3){
                      board[row][col]=1;
                }
              
            }
        }

    }
}