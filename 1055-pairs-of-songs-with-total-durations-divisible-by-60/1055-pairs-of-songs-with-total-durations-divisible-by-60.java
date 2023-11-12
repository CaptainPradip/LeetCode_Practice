class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // 1. keeping Hash Map same as 2 sum 
        // 2. check for 60 - t%60 is in hashmap ; b % 60=0,  if a % 60=0 \space \text{if } a \space \% \space 60=0 if 

        HashMap<Integer,Integer> hashMap= new HashMap<>();
        int count=0;
        for(int t: time){
            if(t%60==0){
                count+= hashMap.getOrDefault(0,0);
            }else{
                count+= hashMap.getOrDefault(60-t%60,0);
            }
            hashMap.put(t%60,hashMap.getOrDefault(t%60,0)+1);
        }
        return count;
    }
}