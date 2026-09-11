class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        int n = s.length();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == ']') {
                StringBuilder temp = new StringBuilder();
                while(!stack.peek().equals("[")) {
                    String curr = stack.pop();
                    temp.insert(0, curr);
                    // System.out.println("appending: "+ curr);
                }
                // temp.reverse();
                stack.pop();
                // System.out.println("current temp: "+ temp);
                StringBuilder num = new StringBuilder();
;                while(!stack.isEmpty() && isNum(stack.peek())) {
                    String dig = stack.pop();
                    num.append(dig);
                }
                if(!num.isEmpty()) {
                    num.reverse();
                    int count = Integer.parseInt(num.toString());
                    String temptemp = temp.toString();
                    for(int j = 1;j < count; j++) {
                        temp.append(temptemp);
                    }
                }
                stack.push(temp.toString());
                // sb = temp;
                // System.out.println("fsinal updates: "+ stack);
            } else {
                stack.push(String.valueOf(ch));
                // System.out.println("pushed: "+ ch);
            }
        }
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public boolean isNum(String num) {
        String[] numbers = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        if(Arrays.asList(numbers).contains(num)){
            return true;
        }
        return false;
    }
}