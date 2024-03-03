class Solution {
    public int maxEvents(int[][] events) {
        // Sort all event by start time
        // Store end days of the events in min heap;
        // Join the earliest ending in progress evetns from the earliest start event to
        // the latest start evetn.
        // 1) Get current date
        // 2) Add just started events at current day in the min heap
        // 3) Join the earliest ending event
        // 4) Remove already ended events
        // Do the loop until we explore all the events and the min heap is empty.
        // Time complexity: O(NlogN)
        // Space complexity: O(N)

        if (events.length == 0) {
            return 0;
        }
        int n = events.length;
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i = 0;
        int day = 0;
        int result = 0;
        while (i < n || !heap.isEmpty()) {
            if (heap.isEmpty()) {
                day = events[i][0];
            }
            while (i < n && day == events[i][0]) {
                heap.add(events[i][1]); // end time ;
                i++;
            }
            heap.remove();
            result++;
            day++;
            while (!heap.isEmpty() && day > heap.peek()) {
                heap.remove();
            }
        }
        return result;
    }
}