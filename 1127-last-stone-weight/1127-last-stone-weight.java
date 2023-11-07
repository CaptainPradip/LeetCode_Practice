class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            heap.add(stone);
        }
        while(heap.size()>1){
            int firstStone = heap.remove();
            int secondStone = heap.remove();
            if(firstStone!=secondStone){
                heap.add(firstStone-secondStone);
            }
        }
        return heap.size()==0 ? 0: heap.peek();
    }
}