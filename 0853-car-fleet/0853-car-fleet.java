class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    if (n == 1) return 1; // Only one car, so one fleet

    // Create pairs of position and speed
    List<Pair<Integer, Integer>> pairs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        pairs.add(new Pair<>(position[i], speed[i]));
    }

    // Sort pairs based on position in descending order
    Collections.sort(pairs, (a, b) -> Integer.compare(b.getKey(), a.getKey()));

    Stack<Double> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
        double currentTime = (double) (target - pairs.get(i).getKey()) / pairs.get(i).getValue();
        if (!stack.isEmpty() && currentTime <= stack.peek()) {
            // If the current car catches up to the previous fleet
            continue;
        } else {
            // Otherwise, it forms a new fleet
            stack.push(currentTime);
        }
    }

    return stack.size(); // Number of fleets
}
}