class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                sb.append(ch);
            }
        }
        StringBuilder sol = new StringBuilder();
        int curr = sb.length() - 1;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                sol.append(sb.charAt(curr));
                curr--;
            } else {
                sol.append(ch);
            }
        }
        return sol.toString();
    }
}