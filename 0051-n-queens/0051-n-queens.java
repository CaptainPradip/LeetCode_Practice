class Solution {
    List<List<String>> result = new ArrayList<>();
    int n ;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char [][] board = createEmptyBoard(n);
        backTrack(0,new HashSet<>(),new HashSet<>(),new HashSet<>(),board);
        return result;
    }
    /**
    * Back Tracking 
    */
    public void backTrack(int row,Set<Integer> colSet , Set<Integer> diagonalSet,Set<Integer> antiDiagonalSet,char[][] board) {
        //Base Condition as all Queens are Placed 
        if(row==this.n){
            result.add(createString(board));
        }
        for(int col=0;col<n;col++) {
            int diagonal = row - col;
            int antiDiagonal= row + col;

            // Check for same col and Diagonal and reverse Diagonal
            if(!colSet.contains(col) && !diagonalSet.contains(diagonal) && !antiDiagonalSet.contains(antiDiagonal) ){
                    colSet.add(col);
                    diagonalSet.add(diagonal);
                    antiDiagonalSet.add(antiDiagonal);
                    board[row][col]='Q';
                    backTrack(row+1,colSet,diagonalSet,antiDiagonalSet,board);

                    colSet.remove(col);
                    diagonalSet.remove(diagonal);
                    antiDiagonalSet.remove(antiDiagonal);
                    board[row][col]='.';
                }
        }
    }

    /**
    This Method used to crate the result String
     */
    public List<String> createString(char[][] board){
        List<String> result = new ArrayList<>();
        for(int row =0; row < board.length; row++) {
            String currentRow= new String(board[row]) ;
            result.add(currentRow);
        }
        return result;
    }
    /**
    * Create Empty Board
    */
    public char [][] createEmptyBoard(int n){
        char [][] board = new char [n][n];
        for(int i=0; i< n;i++){
            for(int j=0;j< n;j++){
                board[i][j]='.';
            }
        }
        return board;
    }
}