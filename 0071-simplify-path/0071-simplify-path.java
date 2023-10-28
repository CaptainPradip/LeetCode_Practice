class Solution {
   	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] components = path.split("/");
		for (String dic : components) {

			if (dic.equals(".") || dic.isEmpty()) {
				continue;
			} else if (dic.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(dic);
			}
		}
		StringBuilder result = new StringBuilder();
		for (String dir : stack) {
			result.append('/');
			result.append(dir);
		}
		return result.length() > 0 ? result.toString() : "/";
	}
}