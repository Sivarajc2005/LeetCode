class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack();
        int n = s.length();
        int sol = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    sol++;
                } else {
                    stack.pop();
                }
            }
        }

        sol += stack.size();
        return sol;
    }
}