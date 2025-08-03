class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        double diagnol = 0;
        for(int[] arr : dimensions){
            double val = Math.sqrt( Math.pow(arr[0] , 2) + Math.pow(arr[1] , 2) );
            if(val >= diagnol){
                if(val == diagnol){
                    // diagnol = val;
                    ans = Math.max(ans , ( arr[0] * arr[1] ) );
                }
                else{
                    diagnol = val;
                    ans = arr[0]* arr[1] ;
                }
            }
        }
        return ans;
    }
}