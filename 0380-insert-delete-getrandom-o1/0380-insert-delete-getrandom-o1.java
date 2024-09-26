class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (this.map.containsKey(val)) {
            return false;
        }
        this.map.put(val, list.size());
        this.list.add(this.list.size(), val);
        return true;

    }

    public boolean remove(int val) {
        if (!this.map.containsKey(val)) {
            return false;
        }
        int lastEle = this.list.get(this.list.size() - 1);
        int index = this.map.get(val);
        this.list.set(index, lastEle);
        this.map.put(lastEle, index);
        list.remove(this.list.size() - 1);
        this.map.remove(val);
        return true;
    }

    public int getRandom() {
        return this.list.get(rand.nextInt(this.list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */