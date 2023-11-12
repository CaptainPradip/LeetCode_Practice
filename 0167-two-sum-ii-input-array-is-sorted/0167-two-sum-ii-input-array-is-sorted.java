class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i =0;
       
        int n = numbers.length;
        int sum = 0;
         int j=n-1;
        while(j > i ){
            sum = numbers[i] + numbers[j];
            if(sum>target){
                j--;
            }else if(sum < target ){
                i++;
            } else{
                result[0]=i+1;
                result[1]=j+1;
                break;
            }
        }
        return result;
    }
}