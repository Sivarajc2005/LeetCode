class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                boolean isFalse = false;
                int temp = i;
                for(int j = 0; j < n; j++) {
                    if(s.charAt(temp % n) != goal.charAt(j)) {
                        isFalse = true;
                        break;
                    }
                    temp += 1;
                }
                if(!isFalse) {
                    return true;
                }
            }
        }
        return false;
    }
}