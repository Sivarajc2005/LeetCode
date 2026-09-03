class Solution {
    public int maxVowels(String s, int k) {
        int vol = 0;
        int max = 0;
        for(int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if(isVol(ch)) {
                vol++;
            }
        }
        max = vol;
        int st = 0;
        int n = s.length();
        for(int i = k; i < n; i++) {
            char ft = s.charAt(st);
            char cur = s.charAt(i);
            if(isVol(ft)) {
                vol--;
            }
            if(isVol(cur)) {
                vol++;
            }
            max = Math.max(max, vol);
            st++;
        }
        return max;
    }

    public boolean isVol(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}