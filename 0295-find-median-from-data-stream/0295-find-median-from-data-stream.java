class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        // 1. Add to max heap ;
        // 2. remove form max 
        // 3. add to min heap;
        // 4. check size 
        // 5. maxheap size alway max ;
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (minHeap.peek()+ maxHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */