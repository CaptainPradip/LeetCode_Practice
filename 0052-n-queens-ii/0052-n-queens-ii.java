class Solution {
    private int size;
    public int totalNQueens(int n) {
        size=n;
        return backTrack(0,new HashSet<Integer>(),new HashSet<Integer>(),new HashSet<Integer>());
        
    }
    
    private int backTrack(int row,Set<Integer> diagonal,Set<Integer> antiDiagonals,Set<Integer>cols){
        if(row==size){
            return 1;
        }
        int solution =0;
        for(int col=0;col<size;col++){
            int currentDiagonal= row-col;
            int currentAntiDiagonal = row+col;
            if(cols.contains(col)|| diagonal.contains(currentDiagonal)|| antiDiagonals.contains(currentAntiDiagonal)){
                continue;
            }
            cols.add(col);
            diagonal.add(currentDiagonal);
            antiDiagonals.add(currentAntiDiagonal);
            solution+=backTrack(row+1,diagonal,antiDiagonals,cols);
            cols.remove(col);
            diagonal.remove(currentDiagonal);
            antiDiagonals.remove(currentAntiDiagonal);
        }
        return solution;
    }
}