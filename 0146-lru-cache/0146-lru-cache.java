class LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> cache;
    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
         if(cache.containsKey(key)){
            cache.remove(key);
         } else if(cache.size()==this.capacity) {
            cache.remove(cache.keySet().iterator().next());
         }
        cache.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */