class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
		int n= matrix[0].length;
		List<Integer> result = new ArrayList<>();
		int left=0;
		int right=n-1;
		int down= m-1;
		int up=0;
		while(result.size()< m*n){
			for(int col= left; col<= right;col++){
				result.add(matrix[up][col]);
			}
			for(int row = up+1 ; row<=down;row++){
				result.add(matrix[row][right]);
			}
			if(down!=up){
				for(int col= right-1 ; col>= left;col--){
					result.add(matrix[down][col]);
				}
			}
			if(right!=left){
				for(int row = down-1 ; row > up;row--){
					result.add(matrix[row][left]);
				}
			}
			left++;
			right--;
			down--;
			up++;
		} 
		return result;
    }
}