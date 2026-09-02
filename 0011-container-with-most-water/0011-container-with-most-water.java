class Solution {
    public int maxArea(int[] height) {
        int sol = 0;
        int st = 0;
        int en = height.length - 1;
        while(st < en) {
            int ft = height[st];
            int ls = height[en];
            int cal = Math.min(ft, ls) * (en - st);
            sol = Math.max(sol, cal);
            
            if(ft < ls) {
                st++;
            } else {
                en--;
            }
        }
        return sol;
    }
}