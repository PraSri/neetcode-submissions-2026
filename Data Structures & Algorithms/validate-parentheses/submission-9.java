class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if(c == '[' || c== '(' || c=='{') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {
                    char p = stack.pop();
                    if(c == ']' && p!='[') {
                        return false;
                    }
                    if(c == '}' && p!='{') {
                        return false;
                    }
                    if(c == ')' && p!='(') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
        
    }
}
