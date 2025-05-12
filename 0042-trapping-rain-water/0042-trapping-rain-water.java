class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        int waterCount = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] < lMax){
                    waterCount += lMax - height[left];
                }
                else{
                    lMax = height[left];
                }
                left++;
            }
            else{
                if(height[right] < rMax){
                    waterCount += rMax - height[right];
                }
                else{
                    rMax = height[right];
                }
                right--;
            }
        }
        return waterCount;
    }
}