class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> frequncy = new HashMap<>();
        int majority= Integer.MIN_VALUE;
        int result =nums [0];
        for(int num: nums ){
            frequncy.put(num,frequncy.getOrDefault(num,0)+1);
            if(majority < frequncy.get(num)){
                majority = frequncy.get(num);
                result = num;
            }
            
        }
        return result;

    }
}