class Solution {
    public String simplifyPath(String path) {
        // 1. split with "/"
        // 2. check for . || empty
        // 3. check for .. then pop if stack having not empty value
        // 4. other push on stack
        Stack<String> stack = new Stack<>();
        String[] dirctories = path.split("/");
        for (String dir : dirctories) {
            if (dir.equals(".") || dir.isEmpty()) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder("");
        for (String str : stack) {
            sb.append("/");
            sb.append(str);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}