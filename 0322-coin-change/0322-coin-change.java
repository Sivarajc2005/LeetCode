class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp , -1);
        int ans = rec(dp,coins,amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static int rec(int[] dp , int[] coins , int amo ){
        if(amo == 0){
            return 0;
        }

        if(amo < 1){
            return Integer.MAX_VALUE;
        }

        if(dp[amo] != -1){
            return dp[amo];
        }
        int min_coin = Integer.MAX_VALUE;
        for(int c : coins){
            int ans = rec(dp , coins , amo - c);
            if(ans != Integer.MAX_VALUE){
                min_coin = Math.min(min_coin , ans + 1);
            }
        }

        return dp[amo] = min_coin;
    }
}