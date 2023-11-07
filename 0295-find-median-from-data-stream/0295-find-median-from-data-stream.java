class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
      // 1. add element at the first heap which is max heap 
      // 2. then take a top element and add it to min heap 
      // 3. now remove form max heap ;
      // 4. check size of max heap is less than then add to max heap 
      // 5. remove from the min heap 
       maxHeap.add(num);
       minHeap.add(maxHeap.peek());
       maxHeap.remove();
       if(maxHeap.size() < minHeap.size()){
           maxHeap.add(minHeap.peek());
           minHeap.remove();
       }
        
    }
    
    public double findMedian() {
        return maxHeap.size()> minHeap.size()? maxHeap.peek() : ( (double) minHeap.peek() + maxHeap.peek())* 0.5; 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */