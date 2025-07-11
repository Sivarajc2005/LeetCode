class Solution {

    static int rec(int[] dp , int[] arr , int ind){
        if(dp[ind] != -1){
            return dp[ind];
        }
        return dp[ind] = arr[ind] + Math.min(rec(dp , arr , ind  - 1 ) , rec(dp , arr , ind - 2));
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+ 1];
        Arrays.fill(dp , -1);
        dp[0] = cost[0];
        dp[1] = cost[1];

        return Math.min(rec(dp , cost , cost.length -1 ) , rec(dp , cost , cost.length - 2));
    }
}