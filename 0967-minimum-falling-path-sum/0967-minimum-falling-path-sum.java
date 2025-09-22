class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for(int[] i: dp){
            Arrays.fill(i, Integer.MIN_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--){
            ans  = Math.min(ans, minTotal(matrix, n - 1, i, dp));
        }
        return ans;
    }

    private int minTotal(int[][] matrix, int row, int col, int[][] dp){
        if(row == 0){
            return matrix[row][col];
        }
        if(dp[row][col] != Integer.MIN_VALUE){
            return dp[row][col];
        }
        int same = minTotal(matrix, row - 1, col, dp);
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(col > 0){
            left =  minTotal(matrix, row - 1, col - 1, dp);
        }
        if(col < matrix.length - 1){
            right = minTotal(matrix, row - 1, col + 1, dp);
        }
        return dp[row][col] = matrix[row][col] + Math.min(same, Math.min(left, right));
    }
}