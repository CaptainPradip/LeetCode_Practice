class Solution {
    public int maxArea(int[] height) {
        // 1. Use two pointer  
        // 2. Check for both side calculate the area take max ;
        // 3. Move the pointer whoes size is less 
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left< right){
            maxArea = Math.max(maxArea,Math.min(height[left],height[right])* (right-left));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}