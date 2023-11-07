class Solution {
    public int halveArray(int[] nums) {
     double sum = IntStream.of(nums).mapToLong(i -> i).sum() ;
     double halfTarget = sum / 2d;
     PriorityQueue<Double> heap = new PriorityQueue<>(Collections.reverseOrder());
     for(int num : nums ){
         heap.add((double)num);
     }
     int operation = 0;
     while(halfTarget < sum){
         double num = heap.remove();
          num /= 2.0;
          sum -= num;
          heap.add(num);
          operation++;
     }
     return operation;
    }
}