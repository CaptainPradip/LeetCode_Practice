class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            int first = matrix[i][0];
            int last = matrix[i][matrix[i].length-1];
            //Find the column for search
            if(target>=first && target<=last){
                return isFound(matrix[i],target);
            }
        }
        return false;
        
    }
    public boolean isFound(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start )/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid] < target){
                start = mid+1;
            } else{
                end=mid-1;
            }
        }
        return false;
    }
}