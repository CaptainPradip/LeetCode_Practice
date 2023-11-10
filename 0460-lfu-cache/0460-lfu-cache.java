class Pair {
    public Integer frequency;
    public Integer value;
    Pair(Integer frequency, Integer value){
        this.frequency = frequency;
        this.value= value;
    }
}

class LFUCache {
    private Map<Integer,Pair> cache ;
    private Map<Integer,LinkedHashSet<Integer>> frequencies;
    private int minf;
    private int capacity;

    private void insert(int key , int frequency,int value){
        cache.put(key,new Pair(frequency,value));
        frequencies.putIfAbsent(frequency,new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }


    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.minf = 0;
        this.capacity= capacity;
    }
    
    public int get(int key) {
        Pair pair = cache.get(key); // get cache value
        if(pair==null){
            return -1;
        }
        int frequency = pair.frequency; // get frequency 
        Set<Integer> keys = frequencies.get(frequency); // get all keys with same frequency
        keys.remove(key); // as we are gona increase the freqency no need to keep in set remove it 
        if(keys.isEmpty()){ // 
            frequencies.remove(frequency); // if keys not present remove the set 
            if(minf==frequency) {
                ++minf;
            }
        }
        int value = pair.value;
        insert(key, frequency+1, value); // update the value as it most frequently used key;
        return value;

    }
    
    public void put(int key, int value) {
        if(this.capacity<=0){
            return ;
        }
        Pair pair = cache.get(key);
        // check for already key present update
        if(pair!=null){
            cache.put(key,new Pair(pair.frequency,value));
            get(key);// used to update the frequency 
            return ;
        }
        if(capacity==cache.size()){
            Set<Integer> keys = frequencies.get(minf);
            int keytoDelete = keys.iterator().next();
            cache.remove(keytoDelete);
            keys.remove(keytoDelete);
            if(keys.isEmpty()){
                frequencies.remove(minf);
            }
        }
        minf = 1;
        insert(key,1,value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */