class Solution {
    public String longestPalindrome(String s) {
        String sol = "";
        for(int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while(s.charAt(left) == s.charAt(right)) {
                left -= 1;
                right += 1;
                if(left < 0 || right >= s.length()) {
                    break;
                }
            }
            String tempOdd = s.substring(left + 1, right);
            if(tempOdd.length() > sol.length()) {
                sol = tempOdd;
            }
            left = i-1;
            right = i;

            while(left >= 0 && s.charAt(left) == s.charAt(right)) {
                left -= 1;
                right += 1;
                if(left < 0 || right >= s.length()) {
                    break;
                }
            }
            String tempEven = s.substring(left + 1, right);
            if(tempEven.length() > sol.length()) {
                sol = tempEven;
            }
        }
        return sol;
    }
}