class StockPrice {
    int latestTime;
    Map<Integer, Integer> timestampPriceMap; // Map of Timestamp,price
    TreeMap<Integer, Integer> priceFrequency; // keep price frequency count

    public StockPrice() {
        latestTime = 0;
        timestampPriceMap = new HashMap<>();
        priceFrequency = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        latestTime = Math.max(timestamp, latestTime); // for gettting the latest price
        if (timestampPriceMap.containsKey(timestamp)) {
            int oldPrice = timestampPriceMap.get(timestamp);
            priceFrequency.put(oldPrice, priceFrequency.get(oldPrice) - 1);
            if (priceFrequency.get(oldPrice) == 0) {
                priceFrequency.remove(oldPrice);
            }
        }
        timestampPriceMap.put(timestamp, price);
        priceFrequency.put(price, priceFrequency.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timestampPriceMap.get(latestTime);
    }

    public int maximum() {
        return priceFrequency.lastKey();
    }

    public int minimum() {
        return priceFrequency.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */