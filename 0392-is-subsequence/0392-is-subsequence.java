class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int ind = 0;
        int n = t.length();
        if(slen == 0) {
            return true;
        }
        if(n == 0) {
            return false;
        }
        for(int i = 0; i < n; i++) {
            char tch = t.charAt(i);
            char sch = s.charAt(ind);
            if(tch == sch) {
                ind++;
            }
            if(ind == slen) {
                return true;
            }
        }
        
        return false;
    }
}