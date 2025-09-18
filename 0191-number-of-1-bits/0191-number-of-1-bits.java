class Solution {
    public int hammingWeight(int n) {
        int c = 0;
        long track = 1;
        int i = 0;
        while( (track << i) <= n){
            // System.out.println()
            if( (n & (track << i) ) != 0 ){
                c++;
            }
            i++;
        }
        return c;
    }
}