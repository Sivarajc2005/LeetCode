class Solution {
    int[][] dp ;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int nc = matrix[0].length;
        dp = new int[n][nc];
        for(int i = 0 ; i < n ;i++){
            Arrays.fill(dp[i] , Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < nc ;i++){
            int res = rec( 0 , i , matrix);
            ans = Math.min(ans , res);
        }
        return ans;
    }

    int rec(int row, int col , int[][] arr){
        

        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }

        if(row == arr.length-1){
            return arr[row][col];
        }

        int down = (row + 1 < arr.length) ? rec(row + 1, col, arr) : 1000000;

        int right = 1000000;
        int left =  1000000;

        if(col > 0)
            left  = rec( row + 1 , col -1 , arr);   //left going

        if(col < arr[0].length-1)
            right = rec(row + 1 , col +1 , arr);   // right going 

        int chose = Math.min(left , Math.min( down , right ) );

        return dp[row][col]  =  arr[row][col] + chose ;
    }
}