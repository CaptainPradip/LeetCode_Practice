class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (position.length == 1)
            return 1;
        int result = 0;
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
      
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(position[i], speed[i]));
        }
        Collections.sort(pairs, (a, b) -> Integer.compare(b.getKey(), a.getKey()));
        int fleet = 1;
        double prevTime = (double) (target - pairs.get(0).getKey()) / pairs.get(0).getValue();
        for (int i = 1; i < n; i++) {
            double currentTime = (double) (target - pairs.get(i).getKey()) / pairs.get(i).getValue();
            if(currentTime > prevTime){
                fleet++;
                prevTime = currentTime;
            }
        }
        return fleet;
    }
}