class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        List<String> bank1 = Arrays.asList(bank);
        queue.add(startGene);
        seen.add(startGene);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String node = queue.remove();
                if (node.equals(endGene)) {
                    return steps;
                }
                for (char c : new char[] { 'A', 'C', 'G', 'T' }) {
                    for (int i = 0; i < node.length(); i++) {
                        String neighbor = node.substring(0, i) + c + node.substring(i + 1);
                        if (!seen.contains(neighbor) && bank1.contains(neighbor)) {
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }
            steps++;

        }
        return -1;
    }
}