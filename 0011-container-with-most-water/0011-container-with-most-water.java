class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int st = 0;
        int en = n -1;
        int left = height[st];
        int right = height[en];
        int ans = Integer.MIN_VALUE;
        while(st <= en){
            if(Math.min(height[st] , height[en])*(en - st) > ans){
                // System.out.println("en : "+en+" st : "+st+" = "+(en - st));
                // System.out.println(Math.min(height[st] , height[en]));
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