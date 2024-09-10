class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. find the frequency of each task
        // 2. use max heap to pick a task
        // 3. use queue to take task to add in heap with count and when that task can be
        // picked
        HashMap<Character, Integer> frequency = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (char task : tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }
        heap.addAll(frequency.values());
        Deque<int[]> queue = new ArrayDeque<>();
        int time = 0;
        while (!heap.isEmpty() || !queue.isEmpty()) {

            if (!queue.isEmpty() && time >= queue.peek()[1]) {
                heap.add(queue.remove()[0]);
            }
            if (!heap.isEmpty()) {
                int count = heap.remove() - 1;
                if (count > 0) {
                    queue.add(new int[] { count, time + n + 1 });
                }
            }
            time++;
        }
        return time;
    }
}