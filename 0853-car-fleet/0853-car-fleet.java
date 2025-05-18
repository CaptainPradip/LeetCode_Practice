class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (position.length == 1)
            return 1;
        int result = 0;
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(position[i], speed[i]));
        }
        Collections.sort(pairs, (a, b) -> Integer.compare(b.getKey(), a.getKey()));
        for (int i = 0; i < n; i++) {
            double currentTime = (double) (target - pairs.get(i).getKey()) / pairs.get(i).getValue();
            if (!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            } else {
                stack.push(currentTime);
            }
        }
        return stack.size();
    }
}