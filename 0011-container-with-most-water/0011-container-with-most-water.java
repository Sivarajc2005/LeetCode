class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int st = 0;
        int en = n -1;
        int ans = Integer.MIN_VALUE;
        while(st <= en){
            if(Math.min(height[st] , height[en])*(en - st) > ans){
                ans = Math.min(height[st] , height[en])*(en - st);
            }
            if(height[st] <= height[en]){
                st++;
            }
            else{
                en--;
            }
            
        }

        return ans;
    }
}