class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int bracket = 0;
        int st = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sb.append(ch);
            if (ch == '(') {
                bracket++;
            } else {
                bracket--;
            }

            if (bracket == 0) {
                // System.out.println(sb);
                sb.deleteCharAt(st);
                sb.deleteCharAt(sb.length() - 1);
                st = sb.length();
            }
        }
        return sb.toString();
    }
}