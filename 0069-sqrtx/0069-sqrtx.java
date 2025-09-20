class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int st =  1;
        int en = x ;
        int ans = -1;
        while(st <= en){
            int mid = ( st + en ) / 2;
            
            if( mid == x / mid ){
                return mid;
            }
            else if( mid > x / mid ){
                en = mid - 1;
            }
            else{
                ans = mid;
                st = mid + 1;
            }
        }
        return ans;
    }
}