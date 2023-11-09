class LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> hashMap ;


    public LRUCache(int capacity) {
        hashMap = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(hashMap.containsKey(key)){
            int val= hashMap.get(key);
            hashMap.remove(key);
            hashMap.put(key,val);
            return hashMap.get(key);
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(hashMap.containsKey(key)){
            hashMap.remove(key);
        }else if(hashMap.size()==capacity){
                hashMap.remove(hashMap.keySet().iterator().next());  
        }
         hashMap.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */