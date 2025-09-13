class Solution {
    static int[][] arr;
    public int uniquePaths(int m, int n) {
        arr = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(arr[i] ,  -1);
        }
        return rec(m,n,0,0);
    }

    static int rec(int m , int n , int r , int c){
        if(r < 0 || r >= m || c < 0 || c >= n){
            return 0;
        }
        else if(r==m-1 && c==n-1){
            return 1;
        }

        if(arr[r][c] != -1){
            return arr[r][c];
        }

        arr[r][c] = rec(m,n,r+1,c) + rec(m,n,r,c+1);
        return arr[r][c];
    }
}