class Solution {
    public int longestSubarray(int[] nums) {
        int currZero  = -1;
        int n = nums.length;
        int sol = 0;
        int st = 0;
        for(int i = 0; i < n; i ++) {
            int curr = nums[i];
            if(curr == 0) {
                if(st != currZero) {
                    st = currZero + 1;
                } else {
                    st += 1;
                }
                currZero = i;
            } 
            sol = Math.max(sol, i - st);
        }
        return sol;
    }
}