class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;

        while(a > 0 || b > 0 || c > 0){
            int a_bit = a & 1;
            int b_bit = b & 1;
            int c_bit = c & 1;

            if( (a_bit | b_bit ) != c_bit){
                if((a_bit == b_bit) && c_bit == 0){
                    ans+=2;
                }
                else{
                    ans++;
                }
            }

            a >>=1;
            b >>=1;
            c >>=1;
        }
        return ans;
    }
}