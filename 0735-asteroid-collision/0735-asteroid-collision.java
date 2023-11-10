class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack= new Stack<>();
        for(int asteroid: asteroids){
           boolean flag = true;
            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                if(Math.abs(stack.peek()) < Math.abs(asteroid)){
                    stack.pop();
                    continue;
                } else if(Math.abs(stack.peek()) == Math.abs(asteroid)){
                      stack.pop();
                }
                flag = false;
                break;
            }
            if(flag)
            stack.push(asteroid);
        }
       
        int [] result = new int [stack.size()] ;
         int i = 0;
        for(int asteroid : stack){
            result[i++] = asteroid;
        }
        return result;
    }
}