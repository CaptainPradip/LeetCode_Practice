class SmallestInfiniteSet {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    HashSet<Integer> set= new HashSet<>();
    public SmallestInfiniteSet() {
        for(int i=1;i<=1000;i++){
            this.heap.add(i);
            this.set.add(i);
        }
    }
    
    public int popSmallest() {
        int num = this.heap.remove();
        set.remove(num);
        return num ;
    }
    
    public void addBack(int num) {
        if(!set.contains(num)){
            set.add(num);
            this.heap.add(num);
        }
 
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */