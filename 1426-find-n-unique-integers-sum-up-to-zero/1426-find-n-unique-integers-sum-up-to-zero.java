class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int ind = 0;
        if(n % 2 != 0){
            ans[ind++] = 0;
        }

        for(int i = 1 ; i <= n / 2 ; i++){
            ans[ind++] = i;
            ans[ind++] = i*-1;
        }

        return ans;
    }
}