class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // 1. sort the interval with start time
        // 2. keep the min Heap with the earlest interval
        // 3. check with current meeting start time with the earlest meeting end time
        // if current time greater than the or equal then update the earlest end time
        // with current start time
        // else add into heap that means we need another meeting room
        // return the size of min heap is the meeting room count;

        // sort based on start time
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
        for (int[] interval : intervals) {

            if (!heap.isEmpty() && heap.peek() <= interval[0]) {
                heap.remove();
            }
            heap.add(interval[1]);
        }
        return heap.size();

    }
    // [[0,30],[5,10],[15,20]]
    // 30
}