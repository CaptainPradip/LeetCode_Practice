class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
		String[] component = path.split("/");
		for(String direc : component){
			if(direc.equals(".") || direc.isEmpty()){
				continue;
			} else if(direc.equals("..")){
				if(!stack.isEmpty()){
					stack.pop();
				}
			} else{
				stack.push(direc);
			}
		}
		StringBuilder sb = new  StringBuilder();
		for(String dir: stack){
				sb.append("/");
				sb.append(dir);
		}
		return sb.isEmpty() ? "/": sb.toString();
    }
}