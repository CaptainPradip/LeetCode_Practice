class Solution {
    public List<Integer> minAvailableDuration(int[][] slotsA, int[][] slotsB, int dur) {
        Arrays.sort(slotsA, (a, b) -> a[0] - b[0]);
        Arrays.sort(slotsB, (a, b) -> a[0] - b[0]);
        int pointA = 0;
        int pointB = 0;
        List<Integer> result = new ArrayList<>();
        while (pointA < slotsA.length && pointB < slotsB.length) {
            int minDura = 
                    Math.min(slotsA[pointA][1], slotsB[pointB][1]) - Math.max(slotsA[pointA][0], slotsB[pointB][0]) ;
            if (minDura >= dur) {
                int max = Math.max(slotsA[pointA][0], slotsB[pointB][0]);
                result.add(max);
                result.add(max + dur);
                return result;
            }
            if (slotsA[pointA][1] < slotsB[pointB][1]) {
                pointA++;
            } else {
                pointB++;
            }
        }
        return result;
    }

}