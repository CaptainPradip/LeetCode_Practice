class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        // [5,-10,-5,7]
        // -10,-5,7
        for (int rock : asteroids) {
            boolean flag = true; // 5
            while (!stack.isEmpty() && stack.peek() > 0 && rock < 0 ) { // 5
                if (Math.abs(rock) > Math.abs(stack.peek())) {
                    stack.pop();
                    continue;
                } else if (Math.abs(rock) == Math.abs(stack.peek())) {
                    stack.pop();

                }
                flag = false;
                break;
            }
            if (flag == true) {
                stack.push(rock);
            }
        }

        int[] result = new int[stack.size()];
        int i = 0;
        for (int n : stack) {
            result[i] = n;
            i++;
        }
        return result;

    }
}