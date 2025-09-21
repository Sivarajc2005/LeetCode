class Solution {
    static int[][] dp;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int nc = grid[0].length;
        dp = new int[n][nc];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1);
        }
        return rec( 0 , 0 , grid);
    }

    static int rec(int row , int col , int[][] arr){
        int n = arr.length;
        int nc = arr[0].length;
        // System.out.println("entering : "+row + " col :" + col );
        if(row >= n || col >= nc ){
            // System.out.println("  exiting unfoetunate");
            return 1000000;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        if(row == n-1 && col==nc-1){
            // System.out.println("i am on the correct place : bye");
            return arr[row][col];
        }

        int down = arr[row][col] + rec(row + 1 , col , arr) ;
        int right = arr[row][col] + rec(row , col+ 1 , arr);
        // System.out.println("Think i got : " + down + " right :" + right);
        return dp[row][col] = Math.min(down , right);
    }
}