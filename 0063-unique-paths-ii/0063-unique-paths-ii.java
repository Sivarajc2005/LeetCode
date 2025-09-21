class Solution {
    static int[][] dp ;
    public int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length;
        dp = new int[n][arr[0].length];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1);
        }
        return rec(0,0,arr);
    }

    static int rec(int row , int col , int[][] arr){

        int n = arr.length;
        int nc = arr[0].length;

        if( row >= n || col >= nc || arr[row][col] == 1 ){
            return 0;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        if(row == n-1 && col == nc-1){
            return 1;
        }

        return dp[row][col] = rec(row + 1 , col , arr) + rec( row , col + 1 , arr);
    }
}